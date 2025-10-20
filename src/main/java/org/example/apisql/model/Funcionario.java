package org.example.apisql.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Funcionario implements UserDetails {
    @Id
    @Column(name = "numero_cracha")
    private Long numeroCracha;

    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String email;
    private String senha;
    private Long id_cargo;
    private Long id_localizacao;
    private Boolean is_gestor;
    private Boolean primeiro_acesso;

    // --- Construtores, Getters e Setters existentes ---
    public Funcionario() {}

    public Funcionario(Long numeroCracha, String nome, String sobrenome, String email, String senha, Long id_cargo, Long id_localizacao, Boolean is_gestor, Boolean primeiro_acesso) {
        this.numeroCracha = numeroCracha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.id_cargo = id_cargo;
        this.id_localizacao = id_localizacao;
        this.is_gestor = is_gestor;
        this.primeiro_acesso = primeiro_acesso;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Long getId_localizacao() {
        return id_localizacao;
    }

    public void setId_localizacao(Long id_localizacao) {
        this.id_localizacao = id_localizacao;
    }

    public Boolean getIs_gestor() {
        return is_gestor;
    }

    public void setIs_gestor(Boolean is_gestor) {
        this.is_gestor = is_gestor;
    }

    public Boolean getPrimeiro_acesso() {
        return primeiro_acesso;
    }

    public void setPrimeiro_acesso(Boolean primeiro_acesso) {
        this.primeiro_acesso = primeiro_acesso;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    @Override
    public boolean isEnabled() { return true; }
}