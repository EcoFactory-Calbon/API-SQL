package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Objeto de requisição para criação ou atualização de funcionário")
public class FuncionarioRequestDTO {

    @NotNull(message = "Numero do cracha não pode estar vazio")
    @Schema(description = "Número único do crachá do funcionário", example = "12345")
    @Size(min = 6, max = 10)
    private Long numeroCracha;

    @NotNull(message = "Nome não pode estar vazio")
    @Schema(description = "Nome do funcionário", example = "Maria")
    @Size(min = 3, message = "Nome deve ter no minimo 3 letras")
    private String nome;

    @NotNull(message = "Sobrenome não pode estar vazio")
    @Schema(description = "Sobrenome do funcionário", example = "Silva")
    @Size(min = 3, message = "Sobrenome deve ter no minimo 3 letras")
    private String sobrenome;

    @Email
    @NotNull(message = "Email não pode estar vazio")
    @Schema(description = "Email corporativo do funcionário", example = "maria.silva@empresa.com")
    private String email;

    @Size(min = 8, message = "Senha deve ter no minimo 8 caracteres")
    @Schema(description = "Senha de acesso do funcionário (mínimo 8 caracteres)", example = "senhaSegura123")
    private String senha;

    @Schema(description = "Identificador do cargo do funcionário", example = "2")
    private Long id_cargo;

    @Schema(description = "Identificador da localização do funcionário", example = "5")
    private Long id_localizacao;

    @Schema(description = "Define se o funcionário é gestor", example = "true")
    private Boolean is_gestor;

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

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId_cargo() {
        return id_cargo;
    }
    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Long getId_localizacao() {
        return id_localizacao;
    }
    public void setId_localizacao(Long id_localizacao) {
        this.id_localizacao = id_localizacao;
    }

    public Boolean getIs_gestor() {
        return is_gestor;
    }
    public void setIs_gestor(Boolean is_gestor) {
        this.is_gestor = is_gestor;
    }
}
