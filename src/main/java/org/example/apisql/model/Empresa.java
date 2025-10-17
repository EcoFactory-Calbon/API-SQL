package org.example.apisql.model;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Empresa implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "id_localizacao")
    private Long idLocalizacao;

    @Column(name = "id_categoria")
    private Long idCategoria;

    private String cnpj;

    private String senha;

    public Empresa() {}

    public Empresa(String nome, Long idLocalizacao, Long idCategoria, String cnpj, String senha) {
        this.nome = nome;
        this.idLocalizacao = idLocalizacao;
        this.idCategoria = idCategoria;
        this.cnpj = cnpj;
        this.senha = senha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Long getIdLocalizacao() { return idLocalizacao; }
    public void setIdLocalizacao(Long idLocalizacao) { this.idLocalizacao = idLocalizacao; }

    public Long getIdCategoriaEmpresa() { return idCategoria; }
    public void setIdCategoriaEmpresa(Long idCategoria) { this.idCategoria = idCategoria; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_EMPRESA"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.cnpj;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
