package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apisql.dto.CargoRequestDTO;
import org.example.apisql.dto.CargoResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Cargo", description = "Endpoints para gerenciamento de cargos")
public interface CargoOpenApi {

    @Operation(summary = "Lista todos os cargos",
            description = "Retorna uma lista de todos os cargos cadastrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de cargos retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = CargoResponseDTO.class))))
    ResponseEntity<List<CargoResponseDTO>> listarCargo();


    @Operation(summary = "Adiciona um novo cargo",
            description = "Cadastra um novo cargo no sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cargo criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CargoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos (ex: nome nulo)",
                    content = @Content)
    })
    ResponseEntity<CargoResponseDTO> adicionarCargo(
            @RequestBody(description = "Dados do novo cargo a ser criado", required = true,
                    content = @Content(schema = @Schema(implementation = CargoRequestDTO.class)))
            CargoRequestDTO dto);


    @Operation(summary = "Exclui um cargo",
            description = "Remove um cargo do sistema pelo seu ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cargo excluído com sucesso",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado com o ID informado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro de integridade (ex: cargo está em uso por um funcionário)",
                    content = @Content)
    })
    ResponseEntity<Void> excluirCargo(
            @Parameter(description = "ID do cargo a ser excluído", required = true, example = "1")
            Integer id);
}