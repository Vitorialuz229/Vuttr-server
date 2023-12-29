package com.github.vitoria_abadia.vuttr.adapter;

import com.github.vitoria_abadia.vuttr.DTO.ToolsRequestDTO;
import com.github.vitoria_abadia.vuttr.DTO.ToolsResponseDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import org.springframework.stereotype.Component;

/**
 * A classe ToolsAdapter é responsável por realizar a conversão entre diferentes representações
 * de objetos, como ToolsRequestDTO, ToolsResponseDTO e ToolsModel.
 *
 * Esta classe é um componente Spring, o que significa que pode ser automaticamente escaneada e
 * registrada no contexto do Spring.
 */
@Component
public class ToolsAdapter {

    /**
     * Converte um objeto ToolsRequestDTO para um objeto ToolsModel.
     *
     * @param toolsDTO O objeto ToolsRequestDTO a ser convertido.
     * @return Um objeto ToolsModel convertido.
     */
    public ToolsModel toTool(ToolsRequestDTO toolsDTO) {
        return ToolsModel.builder()
                .title(toolsDTO.getTitle())
                .link(toolsDTO.getLink())
                .description(toolsDTO.getDescription())
                .tags(toolsDTO.getTags())
                .build();
    }
    /**
     * Converte um objeto ToolsModel para um objeto ToolsResponseDTO.
     *
     * @param toolsModel O objeto ToolsModel a ser convertido.
     * @return Um objeto ToolsResponseDTO convertido.
     */
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