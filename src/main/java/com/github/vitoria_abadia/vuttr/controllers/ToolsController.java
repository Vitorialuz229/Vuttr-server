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
     * @return - Retorna uma lista do DTO de resposta das tools
     * @description - Metodo para obter todas as ferramentas
     */
    @GetMapping
    public ResponseEntity<List<ToolsResponseDTO>> getAll() {
        // Utilizando o serviço de tools para obter a lista
        final var toolsList = this.toolsService.listAll();

        // Retornando status OK para o consumidor da api e retornando no corpo da requisição a lista de ferramentas
        return ResponseEntity.status(HttpStatus.OK).body(toolsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolsResponseDTO> getById(@PathVariable(name = "id") UUID id) {
        // Utilizando serviço de tools para obter uma tool com o ID
        final var tool =  this.toolsService.getById(id);

        // retornando status OK para busca realizada e no corpo a ferramenta encontrada pelo id
        return ResponseEntity.status(HttpStatus.OK).body(tool);
    }

    @GetMapping("/{tag}")
    public ResponseEntity<List<ToolsResponseDTO>> findByTag(@PathVariable(name = "tag") String tag) {
        // Encontrando tools pela tag utilizando o serviço de tools
        final var tools = this.toolsService.findByTag(tag);

        // retorna um status OK para o consumidor da api e no corpo da requisição retorna as tools encontrada pela tag
        return ResponseEntity.status(HttpStatus.OK).body(tools);
    }
    @PostMapping
    public ResponseEntity<ToolsResponseDTO> create(@RequestBody ToolsRequestDTO toolsRequestDTO) {
        // Instancia uma tool e sava no repositorio utilizando serviço de tools
        final var tools = this.toolsService.create(toolsRequestDTO);

        // Retorna uma resposta 201 (CREATED) com a ferramenta recém-criada no corpo da resposta.
        return ResponseEntity.status(HttpStatus.CREATED).body(tools);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        this.toolsService.delete(id);
        return ResponseEntity.ok().body("Tool has been deleted");
    }
}
