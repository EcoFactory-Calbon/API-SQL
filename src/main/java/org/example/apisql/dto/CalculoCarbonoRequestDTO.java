package org.example.apisql.dto;

import jakarta.validation.constraints.NotNull;

public class CalculoCarbonoRequestDTO {
    @NotNull(message = "id_categoriaPergunta não pode ser nulo")
    private Integer id_CategoriaPergunta;

    private Integer valor;


    public @NotNull(message = "id_categoriaPergunta não pode ser nulo") Integer getId_CategoriaPergunta() {
        return id_CategoriaPergunta;
    }

    public void setId_CategoriaPergunta(@NotNull(message = "id_categoriaPergunta não pode ser nulo") Integer id_CategoriaPergunta) {
        this.id_CategoriaPergunta = id_CategoriaPergunta;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
