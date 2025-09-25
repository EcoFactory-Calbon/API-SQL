package org.example.apisql.dto;

public class CategoriaPerguntaResponseDTO {
    private Integer id;
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
