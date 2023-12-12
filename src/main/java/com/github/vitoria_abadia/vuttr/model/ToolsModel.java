package com.github.vitoria_abadia.vuttr.model;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tools")
public class ToolsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String link;
    private String description;

    @ElementCollection
    private List<String> tags;

    public ToolsModel(ToolsDTO toolsDTO) {
    }
}