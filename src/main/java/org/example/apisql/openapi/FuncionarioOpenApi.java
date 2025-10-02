package org.example.apisql.openapi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apisql.dto.FuncionarioRequestDTO;
import org.example.apisql.dto.FuncionarioResponseDTO;
import org.example.apisql.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Tag(name = "Funcionario", description = "Endpoints para gerenciamento de Funcionario")
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
    ResponseEntity<List<FuncionarioResponseDTO>> listarAdmin();



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
            @PathVariable Long cracha);



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
    ResponseEntity<FuncionarioResponseDTO> adicionarAdmin(
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
            @Parameter(description = "ID do funcionário a ser excluído") Long id);

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
            @Parameter(description = "ID do funcionário a ser atualizado") Long id,
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
            @Parameter(description = "ID do funcionário a ser atualizado parcialmente") Long id,
            Map<String, Object> updates);
}
