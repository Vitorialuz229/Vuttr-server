package com.github.vitoria_abadia.vuttr.controllers;

import com.github.vitoria_abadia.vuttr.DTO.ToolsRequestDTO;
import com.github.vitoria_abadia.vuttr.DTO.ToolsResponseDTO;
import com.github.vitoria_abadia.vuttr.services.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class ToolsController {
    @Autowired
    private ToolsService toolsService;

    /**
     * Obtém todas as ferramentas.
     *
     * @return Uma lista de DTOs de resposta das ferramentas.
     */
    @GetMapping
    public ResponseEntity<List<ToolsResponseDTO>> getAll() {
        // Utilizando o serviço de tools para obter a lista
        final var toolsList = this.toolsService.listAll();

        // Retornando status OK para o consumidor da API e retornando no corpo da requisição a lista de ferramentas
        return ResponseEntity.status(HttpStatus.OK).body(toolsList);
    }

    /**
     * Obtém uma ferramenta por ID.
     *
     * @param id O ID da ferramenta a ser obtida.
     * @return A ferramenta encontrada, encapsulada em ResponseEntity.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ToolsResponseDTO> getById(@PathVariable(name = "id") UUID id) {
        // Utilizando o serviço de tools para obter uma tool com o ID
        final var tool =  this.toolsService.getById(id);

        // Retornando status OK para a busca realizada e no corpo a ferramenta encontrada pelo ID
        return ResponseEntity.status(HttpStatus.OK).body(tool);
    }

    /**
     * Obtém ferramentas por tag.
     *
     * @param tag A tag pela qual as ferramentas serão filtradas.
     * @return Uma lista de ferramentas encontradas pela tag, encapsulada em ResponseEntity.
     */
    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<ToolsResponseDTO>> findByTag(@PathVariable(name = "tag") String tag) {
        // Encontrando ferramentas pela tag utilizando o serviço de tools
        final var tools = this.toolsService.findByTag(tag);

        // Retorna um status OK para o consumidor da API e no corpo da requisição retorna as ferramentas encontradas pela tag
        return ResponseEntity.status(HttpStatus.OK).body(tools);
    }

    /**
     * Cria uma nova ferramenta.
     *
     * @param toolsRequestDTO DTO contendo os dados da nova ferramenta.
     * @return A ferramenta recém-criada, encapsulada em ResponseEntity.
     */
    @PostMapping
    public ResponseEntity<ToolsResponseDTO> create(@RequestBody ToolsRequestDTO toolsRequestDTO) {
        // Instancia uma ferramenta e salva no repositório utilizando o serviço de tools
        final var tools = this.toolsService.create(toolsRequestDTO);

        // Retorna uma resposta 201 (CREATED) com a ferramenta recém-criada no corpo da resposta.
        return ResponseEntity.status(HttpStatus.CREATED).body(tools);
    }

    /**
     * Deleta uma ferramenta por ID.
     *
     * @param id O ID da ferramenta a ser deletada.
     * @return ResponseEntity sem corpo indicando que a ferramenta foi deletada com sucesso.
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        this.toolsService.delete(id);
        return ResponseEntity.ok().body("Tool has been deleted");
    }
}