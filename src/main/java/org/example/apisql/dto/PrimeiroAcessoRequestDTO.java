package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Requisição para primeiro acesso")
public class PrimeiroAcessoRequestDTO {

    @Email
    @NotNull(message = "Email não pode estar vazio")
    @Schema(description = "Email do funcionário", example = "maria.silva@empresa.com")
    private String email;

    @NotNull(message = "Número do crachá não pode estar vazio")
    @Schema(description = "Número do crachá do funcionário", example = "12345")
    private Long numero_cracha;

    @NotNull(message = "Código da empresa não pode estar vazio")
    @Schema(description = "Código da empresa (id_localizacao)", example = "5")
    private Long codigoEmpresa;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getNumeroCracha() { return numero_cracha; }
    public void setNumeroCracha(Long numeroCracha) { this.numero_cracha = numeroCracha; }

    public Long getCodigoEmpresa() { return codigoEmpresa; }
    public void setCodigoEmpresa(Long codigoEmpresa) { this.codigoEmpresa = codigoEmpresa; }
}
