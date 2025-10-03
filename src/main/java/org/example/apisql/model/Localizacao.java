package org.example.apisql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Localizacao {
    @Id
    private Integer id;
    private String estado;
    private String cidade;

    public Localizacao() {}

    public Localizacao(Integer id, String estado, String cidade) {
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
