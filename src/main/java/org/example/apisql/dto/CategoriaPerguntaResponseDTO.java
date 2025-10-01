package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa uma categoria de pergunta")
public class CategoriaPerguntaResponseDTO {

    @Schema(description = "Identificador único da categoria", example = "1")
    private Integer id;

    @Schema(description = "Texto da Categoria", example = "Transporte")
    private String categoria;

    public CategoriaPerguntaResponseDTO() {}

    public CategoriaPerguntaResponseDTO(Integer id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
