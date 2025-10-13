package org.example.apisql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa uma empresa cadastrada")
public class EmpresaResponseDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("id_localizacao")
    private Long idLocalizacao;

    @JsonProperty("id_categoria_empresa")
    private Long idCategoriaEmpresa;

    @JsonProperty("cnpj")
    private String cnpj;


    public EmpresaResponseDTO(Long id, String nome, Long idLocalizacao, Long idCategoriaEmpresa, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.idLocalizacao = idLocalizacao;
        this.idCategoriaEmpresa = idCategoriaEmpresa;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getIdCategoriaEmpresa() {
        return idCategoriaEmpresa;
    }
    public void setIdCategoriaEmpresa(Long idCategoriaEmpresa) {
        this.idCategoriaEmpresa = idCategoriaEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
