package org.example.apisql.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta com detalhes de um funcionário de uma empresa")
public class FuncionarioDetalhesDTO {

    private Long numeroCracha;
    private String nome;
    private String sobrenome;
    private String email;
    private String cargo;
    private Boolean is_gestor;
    private Integer id_Cargo;
    private Integer id_Localizacao;

    public FuncionarioDetalhesDTO(Long numeroCracha, String nome, String sobrenome, String email, String cargo, Boolean is_gestor, Integer id_Localizacao, Integer id_Cargo) {
        this.numeroCracha = numeroCracha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cargo = cargo;
        this.is_gestor = is_gestor;
        this.id_Localizacao = id_Localizacao;
        this.id_Cargo = id_Cargo;
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

    public Boolean getIs_gestor() {
        return is_gestor;
    }
    public void setIs_gestor(Boolean is_gestor) {
        this.is_gestor = is_gestor;
    }
    public Integer getId_Cargo() {
        return id_Cargo;
    }
    public void setId_Cargo(Integer id_Cargo) {
        this.id_Cargo = id_Cargo;
    }
    public Integer getId_Localizacao() {
        return id_Localizacao;
    }
    public void setId_Localizacao(Integer id_Localizacao) {
        this.id_Localizacao = id_Localizacao;
    }
}