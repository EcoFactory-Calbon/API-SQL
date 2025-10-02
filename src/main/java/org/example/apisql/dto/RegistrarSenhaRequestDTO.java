package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Requisição para registrar senha do funcionário")
public class RegistrarSenhaRequestDTO {

    @Email
    @NotNull(message = "Email não pode estar vazio")
    @Schema(description = "Email do funcionário", example = "maria.silva@empresa.com")
    private String email;

    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    @NotNull(message = "Senha não pode estar vazia")
    @Schema(description = "Nova senha a ser cadastrada", example = "senhaSegura123")
    private String senha;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
