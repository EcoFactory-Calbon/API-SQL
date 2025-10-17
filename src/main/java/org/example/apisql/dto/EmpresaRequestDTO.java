package org.example.apisql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Objeto de requisição para criar ou atualizar uma empresa")
public class EmpresaRequestDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @Schema(description = "Nome da empresa", example = "EcoFactory")
    private String nome;

    @JsonProperty("id_localizacao")
    @Schema(description = "Identificador da localização da empresa", example = "5")
    private Long idLocalizacao;

    @JsonProperty("id_categoria")
    @Schema(description = "Identificador da categoria da empresa", example = "3")
    private Long idCategoria;

    @JsonProperty("cnpj")
    @Size(min = 14, max = 14, message = "CNPJ tem que ter 14 digitos")
    @Schema(description = "Cnpj da empresa", example = "xx.xxx.xxx/xxxx-xx")
    private String cnpj;

    @JsonProperty("senha")
    @Size(min = 8, message = "Senha deve ter mais de 8 caracteres")
    @NotNull(message = "Senha não pode ser nula")
    @Schema(description = "Senha de acesso da empresa (mínimo 8 caracteres)", example = "senhaForte123")
    private String senha;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdLocalizacao() {
        return idLocalizacao;
    }
    public void setIdLocalizacao(Long idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(Long idCategoriaEmpresa) {
        this.idCategoria = idCategoriaEmpresa;
    }

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

}

