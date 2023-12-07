package com.github.vitoria_abadia.vuttr.model;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String link;
    private String description;
    private String tags;

    public Tools(String title, String link, String description, String tags) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }

    public Tools(ToolsDTO toolsDTO){
        this.title = toolsDTO.title();
        this.link = toolsDTO.link();
        this.description = toolsDTO.description();
        this.tags = toolsDTO.tags();
}
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tools tools = (Tools) o;
        return Objects.equals(id, tools.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
