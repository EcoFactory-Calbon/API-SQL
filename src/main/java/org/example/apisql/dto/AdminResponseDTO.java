package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objeto de resposta que representa os dados de um administrador")
public class AdminResponseDTO {

    @Schema(description = "Email do administrador", example = "admin@empresa.com")
    private String email;

    @Schema(description = "Nome completo do administrador", example = "João Silva")
    private String nome;

    public AdminResponseDTO() {}

    public AdminResponseDTO(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
