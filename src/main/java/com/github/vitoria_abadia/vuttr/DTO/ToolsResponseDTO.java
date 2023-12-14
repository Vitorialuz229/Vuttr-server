package com.github.vitoria_abadia.vuttr.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ToolsResponseDTO {
    private UUID id;
    private String title;
    private String link;
    private String description;
    private List<String> tags;
}
