package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de requisição para criar ou atualizar categoria de pergunta")
public class CategoriaPerguntaRequestDTO {

    @Schema(description = "Texto da categoria", example = "Transporte")
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String pergunta) {
        this.categoria = categoria;
    }
}
