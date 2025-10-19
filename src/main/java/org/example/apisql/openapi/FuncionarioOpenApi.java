package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apisql.dto.AtualizarPerfilRequestDTO;
import org.example.apisql.dto.FuncionarioDetalhesDTO;
import org.example.apisql.dto.FuncionarioRequestDTO;
import org.example.apisql.dto.FuncionarioResponseDTO;
import org.example.apisql.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;

@Tag(name = "Funcionario", description = "Endpoints para gerenciamento de Funcionários")
public interface FuncionarioOpenApi {

    @Operation(
            summary = "Lista todos os funcionários",
            description = "Retorna todos os funcionários cadastrados no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionários listados com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class)))
    })
    ResponseEntity<List<FuncionarioResponseDTO>> listarFuncionario();


    @Operation(
            summary = "Busca funcionário(s) pelo crachá",
            description = "Retorna uma lista de funcionários que correspondem ao número do crachá fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum funcionário encontrado com o crachá informado",
                    content = @Content)
    })
    ResponseEntity<List<FuncionarioResponseDTO>> buscarCracha(
            @Parameter(description = "Número do crachá do funcionário a ser buscado", required = true, example = "12345")
            Long cracha);


    @Operation(
            summary = "Buscar funcionários por empresa",
            description = "Retorna uma lista detalhada de funcionários que pertencem à empresa especificada pelo ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionários encontrados com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioDetalhesDTO.class))),
            @ApiResponse(responseCode = "404", description = "Nenhum funcionário encontrado para o ID informado",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "ID da empresa inválido",
                    content = @Content)
    })
    ResponseEntity<List<FuncionarioDetalhesDTO>> buscarEmpresa(
            @Parameter(description = "ID da empresa a ser buscada", required = true, example = "10")
            Integer id);


    @Operation(
            summary = "Adiciona um novo funcionário",
            description = "Cadastra um novo funcionário no sistema com base nas informações fornecidas."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    ResponseEntity<FuncionarioResponseDTO> adicionarFuncionario(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados para criação de um novo funcionário",
                    required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class))
            )
            FuncionarioRequestDTO dto);


    @Operation(
            summary = "Exclui um funcionário",
            description = "Remove um funcionário do sistema pelo seu ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Funcionário removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    ResponseEntity<Funcionario> excluirFuncionario(
            @Parameter(description = "ID do funcionário a ser excluído", required = true, example = "1")
            Long id);


    @Operation(
            summary = "Atualiza um funcionário",
            description = "Atualiza todas as informações de um funcionário existente."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    ResponseEntity<FuncionarioResponseDTO> atualizarFuncionario(
            @Parameter(description = "ID do funcionário a ser atualizado", required = true, example = "1")
            Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados completos do funcionário para atualização",
                    required = true,
                    content = @Content(schema = @Schema(implementation = FuncionarioRequestDTO.class))
            )
            FuncionarioRequestDTO dto);


    @Operation(
            summary = "Atualiza parcialmente um funcionário",
            description = "Atualiza apenas alguns campos de um funcionário existente."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado parcialmente com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    ResponseEntity<FuncionarioResponseDTO> atualizarParcialmenteFuncionario(
            @Parameter(description = "ID do funcionário a ser atualizado parcialmente", required = true, example = "1")
            Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Campos e valores a serem atualizados",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Map.class))
            )
            Map<String, Object> updates);



    @Operation(
            summary = "Atualiza parcialmente o perfil do funcionário autenticado",
            description = "Permite que um funcionário logado atualize um ou mais campos do seu perfil, como nome ou senha. Apenas os campos enviados no corpo da requisição serão alterados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Perfil atualizado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FuncionarioResponseDTO.class)))
    })
    ResponseEntity<FuncionarioResponseDTO> atualizarPerfil(
            @Parameter(hidden = true) Authentication authentication,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Um objeto JSON contendo apenas os campos a serem atualizados.",
                    required = true
            )
            Map<String, Object> updates);
}
