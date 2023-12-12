package com.github.vitoria_abadia.vuttr.adapter;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import org.springframework.stereotype.Component;

@Component
public class ToolsAdapter {

    public ToolsModel toTool(ToolsDTO toolsDTO) {
        return ToolsModel.builder()
                .title(toolsDTO.getTitle())
                .link(toolsDTO.getLink())
                .description(toolsDTO.getDescription())
                .tags(toolsDTO.getTags())
                .build();
    }

    public ToolsDTO ToToolsDTO(ToolsModel toolsModel) {
        return ToolsDTO.builder()
                .id()
                .title(toolsModel.getTitle())
                .link(toolsModel.getLink())
                .description(toolsModel.getDescription())
                .tags(toolsModel.getTags())
                .build();
    }
}