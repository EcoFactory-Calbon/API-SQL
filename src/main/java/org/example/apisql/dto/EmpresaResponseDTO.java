package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa uma empresa cadastrada")
public class EmpresaResponseDTO {

    @Schema(description = "Identificador único da empresa", example = "1")
    private Long id;

    @Schema(description = "Nome da empresa", example = "EcoFactory")
    private String nome;

    @Schema(description = "Identificador da localização associada à empresa", example = "5")
    private Long id_localizacao;

    @Schema(description = "Identificador da categoria associada à empresa", example = "3")
    private Long id_categoria_empresa;

    public EmpresaResponseDTO() {}

    public EmpresaResponseDTO(Long id, String nome, Long id_localizacao, Long id_categoria_empresa) {
        this.id = id;
        this.nome = nome;
        this.id_localizacao = id_localizacao;
        this.id_categoria_empresa = id_categoria_empresa;
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
