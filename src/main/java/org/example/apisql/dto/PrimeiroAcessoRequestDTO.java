package org.example.apisql.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados para validação de primeiro acesso de um funcionário")
public class PrimeiroAcessoRequestDTO {

    @Email(message = "O email deve ser válido")
    @NotBlank
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "funcionario@empresa.com")
    private String email;

    @NotNull
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    private Long numeroCracha;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Long getNumeroCracha() { return numeroCracha; }
    public void setNumeroCracha(Long numeroCracha) { this.numeroCracha = numeroCracha; }
}