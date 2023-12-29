package com.github.vitoria_abadia.vuttr.model;

import com.github.vitoria_abadia.vuttr.DTO.ToolsResponseDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;
/**
 * Entidade que representa uma ferramenta no banco de dados.
 */
@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tools")
public class ToolsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String link;
    private String description;
    /**
     * Lista de tags associadas à ferramenta.
     */
    @ElementCollection
    private List<String> tags;
    public ToolsModel(ToolsResponseDTO toolsResponseDTO) {
    }
    /**
     * Construtor que aceita um objeto DTO para facilitar a criação de instâncias a partir dos dados do DTO.
     *
     * @param toolsDTO Objeto DTO contendo os dados da ferramenta.
     */
//    public ToolsModel(ToolsDTO toolsDTO) {
//        this.title = toolsDTO.getTitle();
//        this.link = toolsDTO.getLink();
//        this.description = toolsDTO.getDescription();
//        this.tags = toolsDTO.getTags();
//    }
}