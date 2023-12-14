package com.github.vitoria_abadia.vuttr.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ToolsRequestDTO {
    private String title;
    private String link;
    private String description;
    private List<String> tags;
}