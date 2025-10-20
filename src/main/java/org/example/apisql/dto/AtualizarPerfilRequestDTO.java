package org.example.apisql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Schema(description = "Objeto de requisição para atualizar o perfil do próprio funcionário")
public class AtualizarPerfilRequestDTO {

    @Size(min = 3, message = "Nome deve ter no mínimo 3 letras")
    @Schema(description = "Novo nome do funcionário", example = "Rafael Akira da Silva")
    private String nome;

    @Schema(description = "Novo sobrenome do funcionário", example = "da Silva")
    private String sobrenome;

    @Email(message = "O email deve ser válido")
    @Schema(description = "Novo email do funcionário", example = "rafael.akira.silva@empresa.com")
    private String email;

    @Size(min = 8, message = "A nova senha deve ter no mínimo 8 caracteres")
    @Schema(description = "Nova senha de acesso (mínimo 8 caracteres)", example = "novaSenhaSuperSegura456")
    private String senha;

    @Schema(description = "Novo identificador da localização do funcionário", example = "7")
    private Long id_localizacao;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public Long getId_localizacao() { return id_localizacao; }
    public void setId_localizacao(Long id_localizacao) { this.id_localizacao = id_localizacao; }
}