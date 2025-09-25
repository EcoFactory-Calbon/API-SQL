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
import org.example.apisql.dto.AdminRequestDTO;
import org.example.apisql.dto.AdminResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Tag(name = "Admin", description = "Endpoints para gerenciamento de administradores")
public interface AdminOpenApi {

    @Operation(summary = "Lista todos os administradores", description = "Retorna uma lista com todos os administradores cadastrados.")
    @ApiResponse(responseCode = "200", description = "Operação bem-sucedida",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = AdminResponseDTO.class))))
    ResponseEntity<List<AdminResponseDTO>> listarAdmin();

    @Operation(summary = "Cria um novo administrador", description = "Cadastra um novo administrador no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Administrador criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdminResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos", content = @Content)
    })
    ResponseEntity<AdminResponseDTO> adicionarAdmin(@RequestBody @Valid AdminRequestDTO dto);

    @Operation(summary = "Exclui um administrador", description = "Remove um administrador do sistema a partir do seu e-mail.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Administrador excluído com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content)
    })
    ResponseEntity<Void> excluirAdmin(
            @Parameter(description = "E-mail do administrador a ser excluído", required = true, example = "admin@example.com")
            @PathVariable String email);

    @Operation(summary = "Atualiza um administrador", description = "Atualiza todos os dados de um administrador existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdminResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content)
    })
    ResponseEntity<AdminResponseDTO> atualizarAdmin(
            @Parameter(description = "E-mail do administrador a ser atualizado", required = true, example = "admin@example.com")
            @PathVariable String email,
            @RequestBody @Valid AdminRequestDTO dto);

    @Operation(summary = "Atualiza parcialmente um administrador", description = "Atualiza um ou mais campos de um administrador existente (Patch).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrador atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdminResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Administrador não encontrado", content = @Content)
    })
    ResponseEntity<AdminResponseDTO> patchAdmin(
            @Parameter(description = "E-mail do administrador a ser atualizado", required = true, example = "admin@example.com")
            @PathVariable String email,
            @RequestBody Map<String, Object> updates);
}