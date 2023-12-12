package com.github.vitoria_abadia.vuttr.adapter;

import com.github.vitoria_abadia.vuttr.controllers.request.ToolsRequest;
import com.github.vitoria_abadia.vuttr.controllers.response.ToolsResponse;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import org.springframework.stereotype.Component;

@Component
public class ToolsAdapter {
    public ToolsModel toTool(ToolsRequest toolsRequest) {
        return ToolsModel.builder()
                .title(toolsRequest.getTitle())
                .link(toolsRequest.getLink())
                .description(toolsRequest.getDescription())
                .tags(toolsRequest.getTags())
                .build();
    }

    public ToolsResponse ToToolsResponse(ToolsModel toolsModel) {
        return ToolsResponse.builder()
                .id(toolsModel.getId())
                .title(toolsModel.getTitle())
                .link(toolsModel.getLink())
                .description(toolsModel.getDescription())
                .tags(toolsModel.getTags())
                .build();
    }
}