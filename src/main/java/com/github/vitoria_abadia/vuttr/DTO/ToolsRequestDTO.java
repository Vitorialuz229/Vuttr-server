package com.github.vitoria_abadia.vuttr.DTO;

import lombok.Data;

import java.util.List;
/**
 * A classe ToolsRequestDTO representa um objeto de transferência de dados (DTO)
 * utilizado para receber informações sobre ferramentas a serem criadas ou atualizadas.
 * É marcada com a anotação Lombok @Data para geração automática de getters, setters, equals, hashCode, e toString.
 */
@Data
public class ToolsRequestDTO {
    private String title;
    private String link;
    private String description;
    private List<String> tags;
}