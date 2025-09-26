package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.apisql.dto.CategoriaPerguntaResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaPerguntaOpenApi {

    @Operation(
            summary = "Lista todas as categorias de perguntas",
            description = "Retorna todas as categorias de perguntas cadastradas no sistema."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de categorias retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CategoriaPerguntaResponseDTO.class))
    )
    ResponseEntity<List<CategoriaPerguntaResponseDTO>> listarCategoria();
}
