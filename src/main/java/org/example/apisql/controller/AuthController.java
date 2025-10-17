package org.example.apisql.controller;

import jakarta.validation.Valid;
import org.example.apisql.dto.*;
import org.example.apisql.openapi.AuthOpenApi;
import org.example.apisql.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthOpenApi{

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/empresa/login")
    public ResponseEntity<LoginEmpresaResponse> loginEmpresa(@RequestBody LoginEmpresaRequest loginEmpresaRequest) {
        LoginEmpresaResponse response = authService.autenticarEmpresa(loginEmpresaRequest.getCnpj(), loginEmpresaRequest.getSenha());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<LoginAdminResponse> loginAdmin(@RequestBody LoginAdminRequest loginRequest) {
        LoginAdminResponse response = authService.autenticarAdmin(loginRequest.getEmail(), loginRequest.getSenha());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/funcionario/login")
    public ResponseEntity<LoginFuncionarioResponse> loginFuncionario(@RequestBody @Valid LoginFuncionarioRequest loginRequest) {
        LoginFuncionarioResponse response = authService.autenticarFuncionario(loginRequest.getNumeroCracha(), loginRequest.getSenha());
        return ResponseEntity.ok(response);
    }
}