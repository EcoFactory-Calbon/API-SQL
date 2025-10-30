package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apisql.dto.*;
import org.example.apisql.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;

@Tag(name = "Funcionario", description = "Endpoints para gerenciamento de Funcionários")
@SecurityRequirement(name = "bearerAuth") // Aplica o cadeado a todos os endpoints desta tag
public interface FuncionarioOpenApi {

    @Operation(
            summary = "Lista todos os funcionários (Admin)",
            description = "Retorna todos os funcionários cadastrados no sistema. Requer permissão de ADMIN."
    )
    ResponseEntity<List<FuncionarioResponseDTO>> listarFuncionario();


    @Operation(
            summary = "Busca funcionário pelo crachá",
            description = "Retorna um funcionário pelo seu número do crachá. Permite ADMIN, EMPRESA, ou o próprio FUNCIONÁRIO."
    )
    ResponseEntity<List<FuncionarioResponseDTO>> buscarCracha(
            @Parameter(description = "Número do crachá do funcionário a ser buscado", required = true)
            Long cracha);


    @Operation(
            summary = "Buscar funcionários por CNPJ da empresa (Admin/Empresa)",
            description = "Retorna uma lista detalhada de funcionários que pertencem à empresa especificada pelo CNPJ."
    )
    ResponseEntity<List<FuncionarioDetalhesDTO>> buscarEmpresa(
            @Parameter(description = "CNPJ da empresa", required = true)
            String cnpj);


    @Operation(
            summary = "Adiciona um novo funcionário (Admin/Empresa)",
            description = "Cadastra um novo funcionário no sistema."
    )
    ResponseEntity<FuncionarioResponseDTO> adicionarFuncionario(
            @RequestBody(description = "Dados para criação de um novo funcionário", required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class)))
            FuncionarioRequestDTO dto);


    @Operation(
            summary = "Exclui um funcionário (Admin/Empresa)",
            description = "Remove um funcionário do sistema pelo seu número do crachá."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Funcionário removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    ResponseEntity<Funcionario> excluirFuncionario(
            @Parameter(description = "Número do crachá do funcionário a ser excluído", required = true)
            Long id);


    @Operation(
            summary = "Atualiza um funcionário (PUT - Admin/Empresa)",
            description = "Atualiza todas as informações de um funcionário existente pelo seu crachá. Envia o corpo completo."
    )
    ResponseEntity<FuncionarioResponseDTO> atualizarFuncionario(
            @Parameter(description = "Número do crachá do funcionário a ser atualizado", required = true)
            Long id,
            @RequestBody(description = "Dados completos do funcionário para atualização", required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class)))
            FuncionarioRequestDTO dto);


    @Operation(
            summary = "Atualiza o perfil do PRÓPRIO funcionário (PATCH - Funcionário logado)",
            description = "Permite que um funcionário logado atualize um ou mais campos do seu perfil. O usuário é identificado pelo token JWT. Envia apenas os campos a serem alterados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class)))
    })
    ResponseEntity<FuncionarioResponseDTO> atualizarPerfil(
            @Parameter(hidden = true) Authentication authentication,
            @RequestBody(description = "Objeto JSON com os campos a serem atualizados. Ex: {\"nome\": \"Novo Nome\", \"senha\": \"nova123\"}", required = true)
            Map<String, Object> updates);


    @Operation(
            summary = "Atualiza um funcionário pelo site (PATCH - Admin/Empresa)",
            description = "Atualiza parcialmente um funcionário pelo seu crachá. Este método é usado pelo admin/empresa. Envia um DTO, e apenas os campos não nulos serão atualizados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class)))
    })
    ResponseEntity<FuncionarioResponseDTO> atualizarFuncionarioSite(
            @Parameter(description = "Número do crachá do funcionário a ser atualizado", required = true)
            Long numeroCracha,

            @RequestBody(
                    description = "DTO com os campos a serem atualizados. Campos nulos serão ignorados.",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = FuncionarioRequestDTO.class),
                            examples = @ExampleObject(
                                    name = "Exemplo de Atualização Parcial",
                                    summary = "Atualizando apenas nome e cargo",
                                    value = """
                                            {
                                              "numero_cracha":123456,
                                              "nome": "Novo Nome do Funcionario",
                                              "id_cargo": 3
                                            }
                                            """
                            )
                    )
            )
            FuncionarioRequestDTO produtoRequest);


    @Operation(
            summary = "Validação de Primeiro Acesso (Público)",
            description = "Verifica se os dados (email, crachá) correspondem a um funcionário pré-cadastrado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Validação bem-sucedida. Retorna os dados do funcionário.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado com os dados fornecidos."),
            @ApiResponse(responseCode = "400", description = "Funcionário já completou o primeiro acesso.")
    })
    ResponseEntity<FuncionarioResponseDTO> validarPrimeiroAcesso(
            @RequestBody(description = "Dados para validação do primeiro acesso.", required = true,
                    content = @Content(schema = @Schema(implementation = PrimeiroAcessoRequestDTO.class)))
            PrimeiroAcessoRequestDTO dto);

    @Operation(
            summary = "Define a Senha do Primeiro Acesso (Público)",
            description = "Permite que um funcionário, após ser validado, defina sua senha pela primeira vez."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Senha definida e cadastro finalizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado com o número do crachá informado."),
            @ApiResponse(responseCode = "400", description = "Senha inválida (ex: muito curta).")
    })
    ResponseEntity<Void> definirSenha(
            @Parameter(description = "Número do crachá do funcionário", required = true)
            Long numeroCracha,
            @RequestBody(description = "Objeto contendo a nova senha", required = true,
                    content = @Content(schema = @Schema(implementation = DefinirSenhaRequestDTO.class)))
            DefinirSenhaRequestDTO dto);
}