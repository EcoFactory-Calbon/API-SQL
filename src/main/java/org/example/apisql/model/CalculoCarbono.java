package org.example.apisql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CalculoCarbono {
    @Id
    private Long id;
    private Integer id_CategoriaPergunta;
    public CalculoCarbono() {}
    public CalculoCarbono(Long id, Integer id_CategoriaPergunta) {
        this.id = id;
        this.id_CategoriaPergunta = id_CategoriaPergunta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getId_CategoriaPergunta() {
        return id_CategoriaPergunta;
    }

    public void setId_CategoriaPergunta(Integer id_CategoriaPergunta) {
        this.id_CategoriaPergunta = id_CategoriaPergunta;
    }

    @Override
    public String toString() {
        return "CalculoCarbono{" +
                "id=" + id +
                ", id_CategoriaPergunta=" + id_CategoriaPergunta +
                '}';
    }
}
