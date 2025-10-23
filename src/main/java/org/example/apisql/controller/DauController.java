package org.example.apisql.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.example.apisql.dto.DauRequestDTO;
import org.example.apisql.dto.DauResponseDTO;
import org.example.apisql.dto.EmpresaResponseDTO;
import org.example.apisql.openapi.DauOpenApi;
import org.example.apisql.service.DauService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dau")
public class DauController implements DauOpenApi {

    private final DauService dauService;

    public DauController(DauService dauService) {
        this.dauService = dauService;
    }
    @GetMapping("/listar")
    public ResponseEntity<List<DauResponseDTO>> listarEmpresa() {
        return ResponseEntity.ok(dauService.listar());
    }


    @PostMapping("/inserir")
    public ResponseEntity<DauResponseDTO> inserir(@RequestBody @Valid DauRequestDTO dto) {
        DauResponseDTO response = dauService.inserir(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
