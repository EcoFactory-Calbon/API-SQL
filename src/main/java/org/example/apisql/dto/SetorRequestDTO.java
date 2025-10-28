package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class SetorRequestDTO {
    @NotNull(message = "Nome não pode ser nulo")
    @Schema(description = "Nome do setor", example = "Agricultura")
    private String nome;

    @NotNull(message = "Id da Empresa não pode ser nulo")
    @Schema(description = "Id da Empresa", example = "123")
    private Long id_empresa;

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public @NotNull(message = "Nome não pode ser nulo") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "Nome não pode ser nulo") String nome) {
        this.nome = nome;
    }
}
