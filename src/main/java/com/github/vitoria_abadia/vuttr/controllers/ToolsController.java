package com.github.vitoria_abadia.vuttr.controllers;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*Essa anotação indica que a classe é um controlador Spring MVC que trata requisições HTTP.
A classe será escaneada automaticamente pelo Spring e suas rotas serão configuradas.*/
@RestController
public class ToolsController {
    /*Realiza a injeção de dependência do 'ToolsRepository', que é uma interface Spring Data JPA
     para operações de banco de dados relacionadas à entidade 'ToolsModel'*/
    @Autowired
    private ToolsRepository toolsRepository;

    /*Um método que responde a requisições GET para o endpoint raiz. Ele chama o método 'findAll'
    do 'toolsRepository' para obter todas as ferramentas no banco de dados e retorna uma resposta HTTP
    com lista de ferramentas e o status 200 (OK)*/
    @GetMapping
    public ResponseEntity<List<ToolsModel>> getAll() {
        final var list = toolsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(name = "id") UUID id){
        Optional<ToolsModel> toolsFounded = this.toolsRepository.findById(id);

        if(toolsFounded.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not founded");
        }

        final var toolsModel = toolsFounded.get();

        return ResponseEntity.status(HttpStatus.OK).body(toolsModel);
    }

    /*Esse método responde a requisições POST para o endpoint raiz. Ele recebe dados no corpo da requisição
    no formato JSON (usando a anotação @RequestBody) e cria uma nova instância de Tools com base nos dados recebidos.
    Em seguida, retorna uma resposta HTTP com a ferramenta recém-criada e o status 201 (Created).*/
    @PostMapping
    public ResponseEntity<ToolsModel> create(@RequestBody ToolsDTO toolsDTO) {
        final var tools = new ToolsModel(toolsDTO);
        final var toolsModel = this.toolsRepository.save(tools);

        return ResponseEntity.status(HttpStatus.CREATED).body(toolsModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTool(@RequestBody ToolsDTO toolsDTO, @PathVariable(value = "id") UUID id) {
        Optional<ToolsModel> tools = toolsRepository.findById(id);

        if(tools.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not found");
        }

        var toolModel = tools.get();
        final var newTool = new ToolsModel(toolsDTO);

        BeanUtils.copyProperties(toolModel, newTool);
        this.toolsRepository.save(toolModel);

        return ResponseEntity.status(HttpStatus.OK).body(toolsRepository.save(newTool));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTools(@PathVariable(value = "id") UUID id) {
        Optional<ToolsModel> toolsFounded = this.toolsRepository.findById(id);

        if(toolsFounded.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not founded");
        }
        final var tools = toolsFounded.get();

        this.toolsRepository.delete(tools);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
