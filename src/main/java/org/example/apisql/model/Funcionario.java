package org.example.apisql.model;

import jakarta.persistence.*;

@Entity
public class Funcionario {
    @Id
    private Long numero_cracha;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private Long id_cargo;

    private Long id_localizacao;

    private Boolean is_gestor;

    public Funcionario() {}

    public Funcionario(String nome, String sobrenome, String email, String senha, Long numero_cracha, Long id_cargo, Long id_localizacao, Boolean is_gestor) {
        this.numero_cracha = numero_cracha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.id_cargo = id_cargo;
        this.id_localizacao = id_localizacao;
        this.is_gestor = is_gestor;
    }


    public Long getNumero_cracha() {
        return numero_cracha;
    }

    public void setNumero_cracha(Long numero_cracha) {
        this.numero_cracha = numero_cracha;
    }
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Long getId_cargo() {
        return id_cargo;
    }

    public Long getId_localizacao() {
        return id_localizacao;
    }

    public Boolean getIs_gestor() {
        return is_gestor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public void setId_localizacao(Long id_localizacao) {
        this.id_localizacao = id_localizacao;
    }

    public void setIs_gestor(Boolean is_gestor) {
        this.is_gestor = is_gestor;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                " numero_cracha='" + numero_cracha + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", id_cargo=" + id_cargo +
                ", id_localizacao=" + id_localizacao +
                ", is_gestor="+ is_gestor +
                '}';
    }
}
