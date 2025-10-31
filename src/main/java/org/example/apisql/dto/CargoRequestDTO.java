package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class CargoRequestDTO {

    @Schema(description = "Nome do Cargo", example = "Corretor")
    private String nome;

    @Schema(description = "id do setor", example = "11")
    private Integer id_setor;

    @Schema(description = "Nivel do cargo", example = "Alto")
    private String nivel_cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId_setor() {
        return id_setor;
    }

    public void setId_setor(Integer id_setor) {
        this.id_setor = id_setor;
    }

    public String getNivel_cargo() {
        return nivel_cargo;
    }

    public void setNivel_cargo(String nivel_cargo) {
        this.nivel_cargo = nivel_cargo;
    }
}
