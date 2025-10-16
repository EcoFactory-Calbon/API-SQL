package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.apisql.model.Empresa;

@Schema(description = "Resposta da autenticação bem-sucedida.")
public class LoginEmpresaResponse {

    @Schema(description = "Token JWT para autorização de requisições futuras.", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY...")
    private String token;

    @Schema(description = "Nome da empresa autenticada.", example = "Empresa Fictícia S.A.")
    private String nome;

    @Schema(description = "CNPJ da empresa autenticada.", example = "12345678000195")
    private String cnpj;


    public LoginEmpresaResponse(String token, Empresa empresa) {
        this.token = token;
        this.nome = empresa.getNome();
        this.cnpj = empresa.getCnpj();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}