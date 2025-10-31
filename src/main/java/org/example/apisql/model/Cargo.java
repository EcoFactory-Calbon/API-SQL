package org.example.apisql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cargo {
    @Id
    private Integer id;
    private String nome;
    private Integer id_setor;
    private String nivel_cargo;

    public Cargo(){}

    public Cargo(String nome, Integer id_setor, String nivel_cargo){
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
