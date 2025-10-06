package org.example.apisql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de requisição para criar ou atualizar uma empresa")
public class EmpresaRequestDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @Schema(description = "Nome da empresa", example = "EcoFactory")
    private String nome;

    @JsonProperty("id_localizacao")
    @Schema(description = "Identificador da localização da empresa", example = "5")
    private Long idLocalizacao;

    @JsonProperty("id_categoria_empresa")
    @Schema(description = "Identificador da categoria da empresa", example = "3")
    private Long idCategoriaEmpresa;

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
