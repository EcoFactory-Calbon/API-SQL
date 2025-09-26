package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.apisql.dto.EmpresaRequestDTO;
import org.example.apisql.dto.EmpresaResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Empresa", description = "Endpoints para gerenciamento de Empresas")
public interface EmpresaOpenApi {

    @Operation(
            summary = "Lista todas as empresas",
            description = "Retorna todas as empresas cadastradas no sistema."
    )
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponseDTO.class)))
    ResponseEntity<List<EmpresaResponseDTO>> listarEmpresa();

    @Operation(
            summary = "Cria uma nova empresa",
            description = "Insere uma nova empresa no sistema com os dados fornecidos."
    )
    @ApiResponse(responseCode = "201", description = "Empresa criada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponseDTO.class)))
    ResponseEntity<EmpresaResponseDTO> adicionarEmpresa(EmpresaRequestDTO dto);

    @Operation(
            summary = "Exclui uma empresa",
            description = "Remove a empresa correspondente ao ID informado."
    )
    @ApiResponse(responseCode = "204", description = "Empresa excluída com sucesso")
    ResponseEntity<Void> excluirEmpresa(Long id);

    @Operation(
            summary = "Atualiza uma empresa",
            description = "Atualiza os dados da empresa com base no ID informado."
    )
    @ApiResponse(responseCode = "200", description = "Empresa atualizada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponseDTO.class)))
    ResponseEntity<EmpresaResponseDTO> atualizarEmpresa(Long id, EmpresaRequestDTO dto);
}
