package com.github.vitoria_abadia.vuttr.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tags")
public class TagsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @ManyToMany
    private Set<ToolsModel> tools;

}

