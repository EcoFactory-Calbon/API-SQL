package org.example.apisql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para definição de senha no primeiro acesso")
public class DefinirSenhaRequestDTO {

    @NotBlank
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "novaSenhaForte123")
    private String senha;

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}