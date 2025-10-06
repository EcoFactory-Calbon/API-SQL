package org.example.apisql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa uma empresa cadastrada")
public class EmpresaResponseDTO {

    private Long id;
    private String nome;

    @JsonProperty("id_localizacao")
    private Long idLocalizacao;

    @JsonProperty("id_categoria_empresa")
    private Long idCategoriaEmpresa;

    public EmpresaResponseDTO() {}

    public EmpresaResponseDTO(Long id, String nome, Long idLocalizacao, Long idCategoriaEmpresa) {
        this.id = id;
        this.nome = nome;
        this.idLocalizacao = idLocalizacao;
        this.idCategoriaEmpresa = idCategoriaEmpresa;
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
}
