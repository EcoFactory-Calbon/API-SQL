package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Objeto de requisição para criação ou autenticação de administrador")
public class AdminRequestDTO {

    @Email
    @Valid
    @Schema(description = "Email de login do administrador", example = "admin@empresa.com")
    private String email;

    @Valid
    @Min(value = 3, message = "O nome deve ter 3 ou mais caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @Schema(description = "Nome completo do administrador", example = "João Silva")
    private String nome;

    @Valid
    @Min(value = 8, message = "Senha deve ter mais de 8 caracteres")
    @NotNull(message = "Senha não pode ser nula")
    @Schema(description = "Senha de acesso do administrador (mínimo 8 caracteres)", example = "senhaForte123")
    private String senha;

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
