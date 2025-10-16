package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta da autenticação bem-sucedida.")
public class LoginAdminResponse {

    @Schema(description = "Token JWT para autorização de requisições futuras.", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY...")
    private String token;

    @Schema(description = "Nome do admin autenticado.", example = "Julia")
    private String nome;

    @Schema(description = "Email do admin autenticado.", example = "Julia@email.com")
    private String email;

    public LoginAdminResponse(String token, String nome, String email) {
        this.token = token;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
