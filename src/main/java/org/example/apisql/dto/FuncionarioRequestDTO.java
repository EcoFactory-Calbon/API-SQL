package org.example.apisql.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {
    @NotNull(message = "Numero do cracha não pode estar vazio")
    private Long numero_cracha;

    @NotNull(message = "Nome não pode estar vazio")
    private String nome;

    @NotNull(message = "Sobrenome não pode estar vazio")
    private String sobrenome;

    @Email
    @NotNull(message = "Email não pode estar vazio")
    private String email;

    @Size(min = 8, message = "Senha deve ter no minimo 8 caracteres")
    private String senha;


    private Long id_cargo;

    private Long id_localizacao;

    private Boolean is_gestor;


    public Long getNumero_cracha() {
        return numero_cracha;
    }

    public void setNumero_cracha(@NotNull(message = "Numero do cracha não pode estar vazio") Long numero_cracha) {
        this.numero_cracha = numero_cracha;
    }

    public @NotNull(message = "Nome não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "Nome não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "Sobrenome não pode estar vazio") String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@NotNull(message = "Sobrenome não pode estar vazio") String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public @Email @NotNull(message = "Email não pode estar vazio") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotNull(message = "Email não pode estar vazio") String email) {
        this.email = email;
    }

    public @Size(min = 8, message = "Senha deve ter no minimo 8 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@Size(min = 8, message = "Senha deve ter no minimo 8 caracteres") String senha) {
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
}
