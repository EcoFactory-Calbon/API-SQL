package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginEmpresaRequest {

    @Schema(description = "CNPJ da empresa para autenticação.", example = "12345678000195", required = true)
    public String cnpj;

    @Schema(description = "Senha de acesso da empresa.", example = "senhaForte123", required = true)
    public String senha;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}