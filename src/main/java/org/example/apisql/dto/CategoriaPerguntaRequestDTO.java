package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de requisição para criar ou atualizar categoria de pergunta")
public class CategoriaPerguntaRequestDTO {

    @Schema(description = "Texto da pergunta da categoria", example = "Qual o impacto ambiental?")
    private String pergunta;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
