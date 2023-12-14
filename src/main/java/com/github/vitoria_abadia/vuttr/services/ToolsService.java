package com.github.vitoria_abadia.vuttr.services;

import com.github.vitoria_abadia.vuttr.DTO.ToolsRequestDTO;
import com.github.vitoria_abadia.vuttr.DTO.ToolsResponseDTO;
import com.github.vitoria_abadia.vuttr.adapter.ToolsAdapter;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @description - Serviço de tools para utilzação do repositorio e regras de negocio
 *
 */

@Service
public class ToolsService {

    @Autowired
    private ToolsRepository toolsRepository;

    @Autowired
    private ToolsAdapter toolAdapter;

    public List<ToolsResponseDTO> listAll() {
        return this.toolsRepository.findAll()
                .stream()
                .map(toolAdapter::ToToolsDTO)
                .collect(Collectors.toList());
    }

    public ToolsResponseDTO getById(UUID id){
        Optional<ToolsModel> toolFounded = this.toolsRepository.findById(id);

        if(toolFounded.isEmpty()){
            throw new RuntimeException("Ferramenta não encotrada");
        }

        final var tool = this.toolAdapter.ToToolsDTO(toolFounded.get());

        return tool;
    }

    public List<ToolsResponseDTO> findByTag(String tag) {
//        final var toolResponseList = this.listAll();
//        List<ToolsResponseDTO> newToolList = new ArrayList<ToolsResponseDTO>();
//
//        for (ToolsResponseDTO toolResponse : toolResponseList) {
//            if (tag.equals(toolResponse.getTags())) {
//                newToolList.add(toolResponse);
//            }
//        }
//
//        return newToolList;
        return this.toolsRepository.findAllByTags(tag);
    }

    public ToolsResponseDTO create(ToolsRequestDTO toolRequest) {
        final var tool = this.toolAdapter.toTool(toolRequest);
        ToolsModel newTool = this.toolsRepository.save(tool);

        return this.toolAdapter.ToToolsDTO(newTool);
    }

    public void delete(UUID id) {
        var tool = this.toolsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encotrada"));
        toolsRepository.delete((ToolsModel) tool);
    }
}