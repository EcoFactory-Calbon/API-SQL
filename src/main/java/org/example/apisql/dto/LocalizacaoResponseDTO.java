package org.example.apisql.dto;

public class LocalizacaoResponseDTO {
    private Integer id;
    private String estado;
    private String cidade;

    public LocalizacaoResponseDTO() {}
    public LocalizacaoResponseDTO(Integer id, String estado, String cidade) {
        this.id = id;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
