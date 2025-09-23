package org.example.apisql.controller;


import org.example.apisql.dto.FuncionarioResponseDTO;
import org.example.apisql.dto.NivelEmissoesResponseDTO;
import org.example.apisql.service.FuncionarioService;
import org.example.apisql.service.NivelEmissoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nivelEmissao")
public class NivelEmissaoController {

    private final NivelEmissoesService nivelEmissoesService;

    public NivelEmissaoController( NivelEmissoesService nivelEmissoesService) {
        this.nivelEmissoesService = nivelEmissoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NivelEmissoesResponseDTO>> listarAdmin() {
        List<NivelEmissoesResponseDTO> nivelEmissoes = nivelEmissoesService.listar();
        return ResponseEntity.ok(nivelEmissoes);
    }


}
