package com.github.vitoria_abadia.vuttr.controllers;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import com.github.vitoria_abadia.vuttr.model.Tools;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
public class ToolsController {
    @Autowired
    private ToolsRepository toolsRepository;

    @GetMapping
    public ResponseEntity<List<Tools>> getAll() {
        final var list = toolsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping
    public ResponseEntity<Tools> create(@RequestBody ToolsDTO toolsDTO) {
        final var tools = new Tools(toolsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tools);
    }

}
