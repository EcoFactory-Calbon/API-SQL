package org.example.apisql.controller;

import org.example.apisql.dto.CategoriaPerguntaResponseDTO;
import org.example.apisql.dto.EmpresaResponseDTO;
import org.example.apisql.service.CategoriaPerguntaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria-pergunta")
public class CategoriaPerguntaController {

    private final CategoriaPerguntaService categoriaPerguntaService;

    public CategoriaPerguntaController(CategoriaPerguntaService categoriaPerguntaService) {
        this.categoriaPerguntaService = categoriaPerguntaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaPerguntaResponseDTO>> listarCategoria() {
        List<CategoriaPerguntaResponseDTO> categorias = categoriaPerguntaService.listar();
        return ResponseEntity.ok(categorias);
    }
}
