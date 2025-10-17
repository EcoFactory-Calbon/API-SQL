package org.example.apisql.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de requisição para login de funcionário")
public class LoginFuncionarioRequest {
        @NotNull(message = "O número do crachá não pode ser nulo")
        @Schema(description = "Número do crachá para login", example = "12345", requiredMode = Schema.RequiredMode.REQUIRED)
        private Long numeroCracha;

        @NotNull(message = "A senha не pode ser nula")
        @Schema(description = "Senha de acesso do funcionário", example = "senhaSegura123", requiredMode = Schema.RequiredMode.REQUIRED)
        private String senha;

        public Long getNumeroCracha() { return numeroCracha; }
        public void setNumeroCracha(Long numeroCracha) { this.numeroCracha = numeroCracha; }
        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
}
