package org.example.apisql.controller;


import jakarta.validation.Valid;
import org.example.apisql.dto.AdminRequestDTO;
import org.example.apisql.dto.AdminResponseDTO;
import org.example.apisql.openapi.AdminOpenApi;
import org.example.apisql.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController implements AdminOpenApi {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AdminResponseDTO>> listarAdmin() {
        List<AdminResponseDTO> admins = adminService.listar();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/buscarEmail/{email}")
    public ResponseEntity<List<AdminResponseDTO>> buscarPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(adminService.buscarPorEmail(email));
    }

    @PostMapping("/inserir")
    public ResponseEntity<AdminResponseDTO> adicionarAdmin(@RequestBody @Valid AdminRequestDTO dto) {
        AdminResponseDTO response = adminService.inserirAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/excluir/{email}")
    public ResponseEntity<Void> excluirAdmin(@PathVariable String email) {
        adminService.excluirAdmin(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{email}")
    public ResponseEntity<AdminResponseDTO> atualizarAdmin(@PathVariable String email, @RequestBody @Valid AdminRequestDTO dto) {
        AdminResponseDTO response = adminService.atualizarAdmin(dto, email);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/atualizar/{email}")
    public ResponseEntity<AdminResponseDTO> patchAdmin(@PathVariable String email, @RequestBody Map<String, Object> updates) {
        AdminResponseDTO response = adminService.atualizarAdminParcialmente(updates, email);
        return ResponseEntity.ok(response);
    }
}

