package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa os dados públicos de um funcionário")
public class FuncionarioResponseDTO {

    @Schema(description = "Nome do funcionário", example = "Maria")
    private String nome;

    @Schema(description = "Sobrenome do funcionário", example = "Silva")
    private String sobrenome;

    @Schema(description = "Email corporativo do funcionário", example = "maria.silva@empresa.com")
    private String email;

    @Schema(description = "Número único do crachá do funcionário", example = "12345")
    private Long numero_cracha;

    @Schema(description = "Define se o funcionário é gestor", example = "false")
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
