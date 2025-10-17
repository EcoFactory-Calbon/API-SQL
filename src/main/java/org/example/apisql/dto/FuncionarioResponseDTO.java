package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa os dados públicos de um funcionário")
public class FuncionarioResponseDTO {

    @Schema(description = "Número único do crachá do funcionário", example = "12345")
    private Long numeroCracha;

    @Schema(description = "Nome do funcionário", example = "Maria")
    private String nome;

    @Schema(description = "Sobrenome do funcionário", example = "Silva")
    private String sobrenome;

    @Schema(description = "Email corporativo do funcionário", example = "maria.silva@empresa.com")
    private String email;

    @Schema(description = "Define se o funcionário é gestor", example = "false")
    private Boolean is_gestor;

    @Schema(description = "Id do cargo do funcionário", example = "3")
    private Long id_Cargo;

    @Schema(description = "Id do cargo do funcionário", example = "1240")
    private Long id_Localizacao;

    public FuncionarioResponseDTO() {}

    public FuncionarioResponseDTO(Long numeroCracha, String nome, String sobrenome, String email, Boolean is_gestor, Long id_Cargo, Long id_Localizacao) {
        this.numeroCracha = numeroCracha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.is_gestor = is_gestor;
        this.id_Cargo = id_Cargo;
        this.id_Localizacao = id_Localizacao;
    }


    public Long getNumeroCracha() {
        return numeroCracha;
    }
    public void setNumeroCracha(Long numeroCracha) {
        this.numeroCracha = numeroCracha;
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

    public Long getId_Cargo() {
        return id_Cargo;
    }

    public void setId_Cargo(Long id_Cargo) {
        this.id_Cargo = id_Cargo;
    }

    public Long getId_Localizacao() {
        return id_Localizacao;
    }

    public void setId_Localizacao(Long id_Localizacao) {
        this.id_Localizacao = id_Localizacao;
    }
}
