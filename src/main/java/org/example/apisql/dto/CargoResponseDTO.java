package org.example.apisql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Objeto de resposta que representa um Cargo cadastrado")
public class CargoResponseDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("id_setor")
    private Integer id_setor;
    @JsonProperty("nivel_cargo")
    private String nivel_cargo;


    public CargoResponseDTO(Integer id, String nome, Integer id_setor, String nivel_cargo){
        this.id = id;
        this.nome = nome;
        this.id_setor = id_setor;
        this.nivel_cargo = nivel_cargo;
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
