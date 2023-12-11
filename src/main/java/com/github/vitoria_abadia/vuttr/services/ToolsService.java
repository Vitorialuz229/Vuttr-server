package com.github.vitoria_abadia.vuttr.services;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class ToolsService {
    @Autowired
    private ToolsRepository toolsRepository;
    public List<ToolsModel> getAllTools() {
        return toolsRepository.findAll();
    }

    public ToolsModel inserir(ToolsDTO toolsDTO){
        ToolsModel toolsModel = new ToolsModel(toolsDTO);
        return this.toolsRepository.save(toolsModel);
    }
    public
    List<ToolsDTO> getByTag(String tag) {
        return null;
    }

    ToolsDTO postNewTool(ToolsDTO toolsDTO) {
        return null;
    }

    void deleteById(Long id) {

    }

    Optional<ToolsModel> findById(Long id) {
        return null;
    }
}

