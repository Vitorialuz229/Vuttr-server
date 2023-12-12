package com.github.vitoria_abadia.vuttr.dtos;

import lombok.Builder;
import lombok.Data;
import jdk.jshell.Snippet;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

/**
 * Record que representa os dados de transferência (DTO) para uma ferramenta.
 *
 * @param title       O título da ferramenta.
 * @param link        O link relacionado à ferramenta.
 * @param description A descrição da ferramenta.
 * @param tags        Lista de tags associadas à ferramenta.
 */
@Builder
public record ToolsDTO (
        UUID id,
        String title,
        String link,
        String description,
        List<String> tags
) {
    public static Snippet builder() {
        return null;
    }

    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String link() {
        return link;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public List<String> tags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }
}


