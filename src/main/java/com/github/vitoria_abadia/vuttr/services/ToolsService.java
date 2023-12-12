package com.github.vitoria_abadia.vuttr.services;

import com.github.vitoria_abadia.vuttr.adapter.ToolsAdapter;
import com.github.vitoria_abadia.vuttr.controllers.response.ToolsResponse;
import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
@Service
public class ToolsService {
    @Autowired
    private final   ToolsRepository toolsRepository;
    private final ToolsAdapter toolsAdapter;

    public ToolsModel inserir(ToolsDTO toolsDTO) {
        ToolsModel toolsModel = new ToolsModel(toolsDTO);
        return this.toolsRepository.save(toolsModel);
    }

    public List<ToolsResponse> listAll() {
        return null;
    }

    public List<ToolsResponse> findByTag(String tag) {
        return null;
    }
}
