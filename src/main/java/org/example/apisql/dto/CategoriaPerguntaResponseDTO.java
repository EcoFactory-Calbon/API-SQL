package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa uma categoria de pergunta")
public class CategoriaPerguntaResponseDTO {

    @Schema(description = "Identificador único da categoria", example = "1")
    private Integer id;

    @Schema(description = "Texto da pergunta", example = "Qual o impacto ambiental?")
    private String pergunta;

    public CategoriaPerguntaResponseDTO() {}

    public CategoriaPerguntaResponseDTO(Integer id, String pergunta) {
        this.id = id;
        this.pergunta = pergunta;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
