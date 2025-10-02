package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Requisição de login do funcionário")
public class LoginRequestDTO {

    @Email
    @NotNull(message = "Email não pode estar vazio")
    @Schema(description = "Email do funcionário", example = "maria.silva@empresa.com")
    private String email;

    @NotNull(message = "Senha não pode estar vazia")
    @Schema(description = "Senha cadastrada", example = "senhaSegura123")
    private String senha;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
