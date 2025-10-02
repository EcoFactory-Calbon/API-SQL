package org.example.apisql.controller;

import jakarta.validation.Valid;
import org.example.apisql.dto.CategoriaPerguntaRequestDTO;
import org.example.apisql.dto.CategoriaPerguntaResponseDTO;
import org.example.apisql.dto.EmpresaRequestDTO;
import org.example.apisql.dto.EmpresaResponseDTO;
import org.example.apisql.openapi.CategoriaPerguntaOpenApi;
import org.example.apisql.service.CategoriaPerguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria-pergunta")
public class CategoriaPerguntaController implements CategoriaPerguntaOpenApi {

    private final CategoriaPerguntaService categoriaPerguntaService;

    public CategoriaPerguntaController(CategoriaPerguntaService categoriaPerguntaService) {
        this.categoriaPerguntaService = categoriaPerguntaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaPerguntaResponseDTO>> listarCategoria() {
        List<CategoriaPerguntaResponseDTO> categorias = categoriaPerguntaService.listar();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping("/inserir")
    public ResponseEntity<CategoriaPerguntaResponseDTO> adicionarCategoriaPergunta(@RequestBody @Valid CategoriaPerguntaRequestDTO dto) {
        CategoriaPerguntaResponseDTO response = categoriaPerguntaService.inserirCategoriaPergunta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirCategoriaPergunta(@PathVariable Integer id) {
        categoriaPerguntaService.excluirCategoriaEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
