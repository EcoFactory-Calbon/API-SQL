package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.apisql.dto.CategoriaPerguntaRequestDTO;
import org.example.apisql.dto.CategoriaPerguntaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Categoria Pergunta", description = "Endpoints para gerenciamento de Categorias de Perguntas")
public interface CategoriaPerguntaOpenApi {

    @Operation(
            summary = "Lista todas as categorias de perguntas",
            description = "Retorna todas as categorias de perguntas cadastradas no sistema."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de categorias retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = CategoriaPerguntaResponseDTO.class)))
    )
    ResponseEntity<List<CategoriaPerguntaResponseDTO>> listarCategoria();

    @Operation(
            summary = "Adiciona uma nova categoria de pergunta",
            description = "Cadastra uma nova categoria de pergunta no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoriaPerguntaResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos", content = @Content)
    })
    ResponseEntity<CategoriaPerguntaResponseDTO> adicionarCategoriaPergunta(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados para a criação da nova categoria de pergunta",
                    required = true,
                    content = @Content(schema = @Schema(implementation = CategoriaPerguntaRequestDTO.class))
            )
            @RequestBody @Valid CategoriaPerguntaRequestDTO dto);

    @Operation(
            summary = "Exclui uma categoria de pergunta",
            description = "Remove uma categoria de pergunta do sistema pelo seu ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoria excluída com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada", content = @Content)
    })
    ResponseEntity<Void> excluirCategoriaPergunta(
            @Parameter(description = "ID da categoria de pergunta a ser excluída", required = true, example = "1")
            @PathVariable Integer id);
}