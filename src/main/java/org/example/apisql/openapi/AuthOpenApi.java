package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apisql.dto.LoginAdminRequest;     // <-- Importar o DTO correto
import org.example.apisql.dto.LoginAdminResponse;    // <-- Importar o DTO correto
import org.example.apisql.dto.LoginEmpresaRequest;
import org.example.apisql.dto.LoginEmpresaResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(name = "Autenticação", description = "Endpoints para o processo de autenticação de usuários")
public interface AuthOpenApi {

    @Operation(summary = "Autentica uma Empresa",
            description = "Valida as credenciais (CNPJ e senha) de uma empresa e, em caso de sucesso, gera um token de acesso JWT.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login da empresa realizado com sucesso",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = LoginEmpresaResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos ou mal formatados",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado. CNPJ ou senha inválidos",
                    content = @Content)
    })
    ResponseEntity<LoginEmpresaResponse> loginEmpresa(
            @RequestBody(description = "Credenciais da empresa para realizar a autenticação", required = true,
                    content = @Content(schema = @Schema(implementation = LoginEmpresaRequest.class)))
            LoginEmpresaRequest loginEmpresaRequest);


    @Operation(summary = "Autentica um Administrador",
            description = "Valida as credenciais (Email e senha) de um administrador e, em caso de sucesso, gera um token de acesso JWT.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login do administrador realizado com sucesso",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = LoginAdminResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos ou mal formatados",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado. Email ou senha inválidos",
                    content = @Content)
    })
    ResponseEntity<LoginAdminResponse> loginAdmin (
                                                   @RequestBody(description = "Credenciais do administrador para realizar a autenticação", required = true,
                                                           content = @Content(schema = @Schema(implementation = LoginAdminRequest.class))) // <-- Corrigido aqui
                                                   LoginAdminRequest loginRequest);

}