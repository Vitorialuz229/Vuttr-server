package com.github.vitoria_abadia.vuttr.dtos;

import java.util.List;

public record ToolsDTO<tags>(
        String title,
        String link,
        String description,
        List<String> tags
) {}


