package com.github.vitoria_abadia.vuttr.controllers.request;

import lombok.Data;
import java.util.List;

@Data
public class ToolsRequest {
    private String title;
    private String link;
    private String description;
    private List<String> tags;
}
