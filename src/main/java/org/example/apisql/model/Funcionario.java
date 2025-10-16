package org.example.apisql.model;

import jakarta.persistence.*;

@Entity
public class Funcionario {
    @Id
    @Column(name = "numero_cracha") // This line tells JPA the database column name
    private Long numeroCracha;

    private String nome;

    private String sobrenome;

    private String email;

    private String senha;

    private Long id_cargo;

    private Long id_localizacao;

    private Boolean is_gestor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id") // Nome da coluna de chave estrangeira no DB
    private Empresa empresa;

    public Funcionario() {}

    public Funcionario(String nome, String sobrenome, String email, String senha, Long numeroCracha, Long id_cargo, Long id_localizacao, Boolean is_gestor) {
        this.numeroCracha = numeroCracha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.id_cargo = id_cargo;
        this.id_localizacao = id_localizacao;
        this.is_gestor = is_gestor;
    }


    public Long getNumeroCracha() {
        return numeroCracha;
    }

    public void setNumeroCracha(Long numeroCracha) {
        this.numeroCracha = numeroCracha;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
