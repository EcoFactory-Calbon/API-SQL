package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de requisição para criar ou atualizar uma empresa")
public class EmpresaRequestDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @Schema(description = "Nome da empresa", example = "EcoFactory")
    private String nome;

    @Schema(description = "Identificador da localização da empresa", example = "5")
    private Long id_localizacao;

    @Schema(description = "Identificador da categoria da empresa", example = "3")
    private Long id_categoria_empresa;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId_localizacao() {
        return id_localizacao;
    }
    public void setId_localizacao(Long id_localizacao) {
        this.id_localizacao = id_localizacao;
    }

    public Long getId_categoria_empresa() {
        return id_categoria_empresa;
    }
    public void setId_categoria_empresa(Long id_categoria_empresa) {
        this.id_categoria_empresa = id_categoria_empresa;
    }
}
