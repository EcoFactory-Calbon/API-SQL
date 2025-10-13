package org.example.apisql.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta com detalhes de um funcionário de uma empresa")
public class FuncionarioDetalhesDTO {

    private Long numeroCracha;
    private String nome;
    private String sobrenome;
    private String email;
    private String cargo;
    private String setor;

    public FuncionarioDetalhesDTO(Long numeroCracha, String nome, String sobrenome, String email, String cargo, String setor) {
        this.numeroCracha = numeroCracha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cargo = cargo;
        this.setor = setor;
    }

    public Long getNumeroCracha() { return numeroCracha; }
    public void setNumeroCracha(Long numeroCracha) { this.numeroCracha = numeroCracha; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
}