package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Objeto de requisição para login de administrador")
public class LoginAdminRequest {


        @Email(message = "O email deve ser um endereço válido")
        @NotBlank(message = "O email não pode estar em branco")
        @Schema(description = "Email de login do administrador", example = "admin@empresa.com", requiredMode = Schema.RequiredMode.REQUIRED)
        private String email;

        @NotBlank(message = "A senha не pode estar em branco")
        @Schema(description = "Senha de acesso do administrador", example = "senhaForte123", requiredMode = Schema.RequiredMode.REQUIRED)
        private String senha;

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
}
