package org.example.apisql.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
            summary = "Busca empresas pelo nome",
            description = "Retorna uma lista de empresas que contenham o nome informado."
    )
    @ApiResponse(responseCode = "200", description = "Empresas encontradas com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponseDTO.class)))
    ResponseEntity<List<EmpresaResponseDTO>> buscarPorNome(
            @Parameter(description = "Nome da empresa") String nome);

    @Operation(
            summary = "Busca empresas por categoria",
            description = "Retorna uma lista de empresas que pertençam à categoria informada."
    )
    @ApiResponse(responseCode = "200", description = "Empresas encontradas com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponseDTO.class)))
    ResponseEntity<List<EmpresaResponseDTO>> buscarPorIdCategoria(
            @Parameter(description = "ID da categoria") Long idCategoria);

    @Operation(
            summary = "Cria uma nova empresa",
            description = "Insere uma nova empresa no sistema com os dados fornecidos."
    )
    @ApiResponse(responseCode = "201", description = "Empresa criada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponseDTO.class)))
    ResponseEntity<EmpresaResponseDTO> adicionarEmpresa(
            @Parameter(description = "Dados da nova empresa") EmpresaRequestDTO dto);

    @Operation(
            summary = "Exclui uma empresa",
            description = "Remove a empresa correspondente ao ID informado."
    )
    @ApiResponse(responseCode = "204", description = "Empresa excluída com sucesso")
    ResponseEntity<Void> excluirEmpresa(
            @Parameter(description = "ID da empresa a ser excluída") Long id);

    @Operation(
            summary = "Atualiza uma empresa",
            description = "Atualiza os dados da empresa com base no ID informado."
    )
    @ApiResponse(responseCode = "200", description = "Empresa atualizada com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponseDTO.class)))
    ResponseEntity<EmpresaResponseDTO> atualizarEmpresa(
            @Parameter(description = "ID da empresa a ser atualizada") Long id,
            @Parameter(description = "Novos dados da empresa") EmpresaRequestDTO dto);
}
