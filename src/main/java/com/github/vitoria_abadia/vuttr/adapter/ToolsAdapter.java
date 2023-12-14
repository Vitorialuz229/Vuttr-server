package com.github.vitoria_abadia.vuttr.adapter;

import com.github.vitoria_abadia.vuttr.DTO.ToolsRequestDTO;
import com.github.vitoria_abadia.vuttr.DTO.ToolsResponseDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import org.springframework.stereotype.Component;

@Component
public class ToolsAdapter {

    public ToolsModel toTool(ToolsRequestDTO toolsDTO) {
        return ToolsModel.builder()
                .title(toolsDTO.getTitle())
                .link(toolsDTO.getLink())
                .description(toolsDTO.getDescription())
                .tags(toolsDTO.getTags())
                .build();
    }

    public ToolsResponseDTO ToToolsDTO(ToolsModel toolsModel) {
        return ToolsResponseDTO.builder()
                .id(toolsModel.getId())
                .title(toolsModel.getTitle())
                .link(toolsModel.getLink())
                .description(toolsModel.getDescription())
                .tags(toolsModel.getTags())
                .build();
    }

}