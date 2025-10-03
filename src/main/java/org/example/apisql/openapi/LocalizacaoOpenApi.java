package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apisql.dto.LocalizacaoRequestDTO;
import org.example.apisql.dto.LocalizacaoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Tag(name = "Localização", description = "Endpoints para gerenciamento de Localizações")
public interface LocalizacaoOpenApi {

    @Operation(summary = "Listar todas as localizações", description = "Retorna uma lista com todas as localizações cadastradas.")
    @ApiResponse(responseCode = "200", description = "Lista de localizações retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = LocalizacaoResponseDTO.class))))
    ResponseEntity<List<LocalizacaoResponseDTO>> listarLocalizacao();


    @Operation(summary = "Buscar localizações por estado", description = "Retorna uma lista de localizações filtradas pela sigla do estado.")
    @ApiResponse(responseCode = "200", description = "Busca concluída com sucesso (pode retornar uma lista vazia)",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = LocalizacaoResponseDTO.class))))
    ResponseEntity<List<LocalizacaoResponseDTO>> buscarPorEstado(
            @Parameter(description = "Sigla do estado para busca (ex: SP)", required = true)
            @PathVariable String estado);


    @Operation(summary = "Inserir uma nova localização", description = "Cadastra uma nova localização no sistema.")
    @ApiResponse(responseCode = "201", description = "Localização criada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LocalizacaoResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos (ex: estado fora do padrão de 2 caracteres)", content = @Content)
    ResponseEntity<LocalizacaoResponseDTO> inserirLocalizacao(
            @RequestBody(description = "Objeto de localização para ser criado", required = true,
                    content = @Content(schema = @Schema(implementation = LocalizacaoRequestDTO.class)))
            LocalizacaoRequestDTO dto);


    @Operation(summary = "Excluir uma localização", description = "Remove uma localização do sistema pelo seu ID.")
    @ApiResponse(responseCode = "204", description = "Localização excluída com sucesso", content = @Content)
    @ApiResponse(responseCode = "404", description = "Localização não encontrada", content = @Content)
    ResponseEntity<Void> excluirLocalizacao(
            @Parameter(description = "ID da localização a ser excluída", required = true)
            @PathVariable Integer id);


    @Operation(summary = "Atualizar parcialmente uma localização", description = "Atualiza um ou mais campos de uma localização existente.")
    @ApiResponse(responseCode = "200", description = "Localização atualizada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LocalizacaoResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Corpo da requisição inválido (ex: campo inexistente)", content = @Content)
    @ApiResponse(responseCode = "404", description = "Localização não encontrada", content = @Content)
    ResponseEntity<LocalizacaoResponseDTO> atualizarParcialmenteLocalizacao(
            @Parameter(description = "ID da localização a ser atualizada", required = true)
            @PathVariable Integer id,
            @RequestBody(description = "Objeto JSON com os campos a serem atualizados. Ex: {\"cidade\": \"Rio de Janeiro\"}", required = true)
            Map<String, Object> updates);
}