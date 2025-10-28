package org.example.apisql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetorResponseDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    public SetorResponseDTO(Integer id, String nome, Long id_empresa) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
