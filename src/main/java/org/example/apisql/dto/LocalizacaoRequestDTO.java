package org.example.apisql.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class LocalizacaoRequestDTO {

    private Integer id;

    @Min(value = 2, message = "Estado tem que ser pela sua sigla")
    @Max(value = 2, message = "Estado tem que ser pela sua sigla")
    private String estado;

    private String cidade;

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