package org.example.apisql.dto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resposta da autenticação bem-sucedida de um funcionário")
public class LoginFuncionarioResponse {

    @Schema(description = "Token JWT para autorização de requisições futuras.", example = "eyJhbGciOiJIUzI1NiJ9...")
    private String token;

    @Schema(description = "Nome do funcionário autenticado.", example = "Maria Silva")
    private String nome;

    @Schema(description = "Número do crachá do funcionário autenticado.", example = "12345")
    private Long numeroCracha;

    public LoginFuncionarioResponse(String token, String nome, Long numeroCracha) {
        this.token = token;
        this.nome = nome;
        this.numeroCracha = numeroCracha;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Long getNumeroCracha() { return numeroCracha; }
    public void setNumeroCracha(Long numeroCracha) { this.numeroCracha = numeroCracha; }
}
