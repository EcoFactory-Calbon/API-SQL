package org.example.apisql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetorResponseDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    private Long id_empresa;
    public SetorResponseDTO(Integer id, String nome, Long id_empresa) {
        this.id = id;
        this.nome = nome;
        this.id_empresa = id_empresa;
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

    public Long getId_empresa() {
        return id_empresa;
    }
    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

}
