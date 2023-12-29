package com.github.vitoria_abadia.vuttr.DTO;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.UUID;
/**
 * A classe ToolsResponseDTO representa um objeto de transferência de dados (DTO)
 * utilizado para enviar informações sobre ferramentas como resposta a requisições.
 * É marcada com as anotações Lombok @Data e @Builder para geração automática de métodos
 * e para facilitar a construção do objeto usando o padrão de design Builder.
 */
@Data
@Builder
public class ToolsResponseDTO {
    private UUID id;
    private String title;
    private String link;
    private String description;
    private List<String> tags;
}