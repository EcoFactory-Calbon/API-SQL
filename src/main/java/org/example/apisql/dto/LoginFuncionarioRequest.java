package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de requisição para login de funcionário")
public class LoginFuncionarioRequest {

        @Email(message = "O email deve ser válido")
        @NotBlank(message = "O email não pode estar em branco")
        @Schema(description = "Email de login do funcionário", example = "funcionario@empresa.com", requiredMode = Schema.RequiredMode.REQUIRED)
        private String email;

        @NotBlank(message = "A senha não pode estar em branco")
        @Schema(description = "Senha de acesso do funcionário", example = "senhaSegura123", requiredMode = Schema.RequiredMode.REQUIRED)
        private String senha;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
}