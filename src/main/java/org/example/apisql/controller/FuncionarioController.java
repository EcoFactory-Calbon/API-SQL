package org.example.apisql.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.apisql.dto.*;
import org.example.apisql.model.Funcionario;
import org.example.apisql.openapi.FuncionarioOpenApi;
import org.example.apisql.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController implements FuncionarioOpenApi {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }


    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioResponseDTO>> listarAdmin() {
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping("/inserir")
    public ResponseEntity<FuncionarioResponseDTO> adicionarAdmin(@RequestBody @Valid FuncionarioRequestDTO dto) {
        FuncionarioResponseDTO response = funcionarioService.inserirFuncionario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Funcionario> excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizarFuncionario(@PathVariable Long id, @RequestBody @Valid FuncionarioRequestDTO dto) {
        FuncionarioResponseDTO response = funcionarioService.atualizarFuncionario(dto, id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizarParcialmenteFuncionario(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        FuncionarioResponseDTO response = funcionarioService.atualizarFuncionarioParcialmente(updates, id);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Primeiro acesso", description = "Verifica se o funcionário existe pelo email, número do crachá e código da empresa.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Verificação realizada com sucesso",
                    content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado",
                    content = @Content)
    })
    @PostMapping("/primeiro-acesso")
    public ResponseEntity<Boolean> primeiroAcesso(@RequestBody @Valid PrimeiroAcessoRequestDTO dto) {
        boolean valido = funcionarioService.primeiroAcesso(dto.getEmail(), dto.getNumeroCracha(), dto.getCodigoEmpresa());
        return ResponseEntity.ok(valido);
    }

    @Operation(summary = "Registrar senha", description = "Permite ao funcionário cadastrar sua senha pela primeira vez.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Senha registrada com sucesso",
                    content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado",
                    content = @Content)
    })
    @PostMapping("/registrar-senha")
    public ResponseEntity<Boolean> registrarSenha(@RequestBody @Valid RegistrarSenhaRequestDTO dto) {
        boolean sucesso = funcionarioService.registrarSenha(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(sucesso);
    }

    @Operation(summary = "Login", description = "Autentica o funcionário com base no email e senha cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso",
                    content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas",
                    content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody @Valid LoginRequestDTO dto) {
        boolean autenticado = funcionarioService.login(dto.getEmail(), dto.getSenha());
        return ResponseEntity.ok(autenticado);
    }
}
