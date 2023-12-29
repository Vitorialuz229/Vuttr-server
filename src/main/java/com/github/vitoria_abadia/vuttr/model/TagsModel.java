package com.github.vitoria_abadia.vuttr.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

/**
 * Entidade que representa uma tag no banco de dados.
 */
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
}