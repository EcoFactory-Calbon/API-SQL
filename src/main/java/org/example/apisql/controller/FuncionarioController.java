package org.example.apisql.controller;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.example.apisql.dto.*;
import org.example.apisql.model.Funcionario;
import org.example.apisql.openapi.FuncionarioOpenApi;
import org.example.apisql.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<List<FuncionarioResponseDTO>> listarFuncionario() {
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/buscarCracha/{cracha}")
    public ResponseEntity<List<FuncionarioResponseDTO>> buscarCracha(@PathVariable Long cracha) {
        return ResponseEntity.ok(funcionarioService.buscarPorCracha(cracha));
    }

    @GetMapping("/buscarEmpresa/{cnpj}")
    public ResponseEntity<List<FuncionarioDetalhesDTO>> buscarEmpresa(@PathVariable String cnpj) {
        return ResponseEntity.ok(funcionarioService.buscarPorEmpresa(cnpj));
    }

    @PostMapping("/inserir")
    public ResponseEntity<FuncionarioResponseDTO> adicionarFuncionario(@RequestBody @Valid FuncionarioRequestDTO dto) {
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


    @PatchMapping("/AtualizarPerfil")
    public ResponseEntity<FuncionarioResponseDTO> atualizarPerfil(
            Authentication authentication,
            @RequestBody Map<String, Object> updates) {

        String numeroCracha = authentication.getName();

        FuncionarioResponseDTO response = funcionarioService.atualizarPerfil(numeroCracha, updates);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/AtualizarPorSite/{numeroCracha}")
    public ResponseEntity<FuncionarioResponseDTO> atualizarFuncionarioSite(@PathVariable Long numeroCracha,  @RequestBody FuncionarioRequestDTO produtoRequest){
        return ResponseEntity.ok(funcionarioService.atualizarFuncionarioSite(numeroCracha, produtoRequest));
    }

    @PostMapping("/primeiroAcesso")
    public ResponseEntity<FuncionarioResponseDTO> validarPrimeiroAcesso(@RequestBody @Valid PrimeiroAcessoRequestDTO dto) {
        FuncionarioResponseDTO response = funcionarioService.primeiroAcesso(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/primeiroAcesso/definirSenha/{numeroCracha}")
    public ResponseEntity<Void> definirSenha(@PathVariable Long numeroCracha, @RequestBody @Valid DefinirSenhaRequestDTO dto) {
        funcionarioService.definirSenha(numeroCracha, dto);
        return ResponseEntity.ok().build();
    }
}