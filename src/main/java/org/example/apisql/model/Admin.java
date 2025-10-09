package org.example.apisql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Admin implements UserDetails {
    @Id
    private String email;
    private String nome;
    private String senha;

    public Admin(){}
    public Admin (String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    public String getEmail() { return email; }
    public String getNome() { return nome; }
    public String getSenha() { return senha; }
    public void setEmail(String email) { this.email = email; }
    public void setNome(String nome) { this.nome = nome; }
    public void setSenha(String senha) { this.senha = senha; }

    // --- MÉTODOS DA INTERFACE USERDETAILS ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Como esta classe é para Admins, o papel (role) é fixo como "ADMIN"
        // O Spring Security exige o prefixo "ROLE_"
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        // No seu caso, o nome de usuário é o email
        return this.email;
    }

    //vamos considerar que a conta está sempre ativa e válida
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