package org.example.apisql.dto;

public class FuncionarioResponseDTO {
    private String nome;
    private String sobrenome;
    private String email;
    private Long numero_cracha;
    private Boolean is_gestor;


    public FuncionarioResponseDTO() {}

    public FuncionarioResponseDTO(Long numero_cracha, String nome, String sobrenome, String email, Boolean is_gestor) {
        this.numero_cracha = numero_cracha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.is_gestor = is_gestor;
    }

    public FuncionarioResponseDTO(String nome, String sobrenome, String email, Long numeroCracha, Boolean isGestor) {
    }


    public Long getNumero_cracha() {
        return numero_cracha;
    }

    public void setNumero_cracha(Long numero_cracha) {
        this.numero_cracha = numero_cracha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Boolean getIs_gestor() {
        return is_gestor;
    }

    public void setIs_gestor(Boolean is_gestor) {
        this.is_gestor = is_gestor;
    }
}