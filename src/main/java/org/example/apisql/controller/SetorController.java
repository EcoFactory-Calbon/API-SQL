package org.example.apisql.controller;

import org.example.apisql.dto.NivelEmissoesResponseDTO;
import org.example.apisql.dto.SetorResponseDTO;
import org.example.apisql.service.SetorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setor")
public class SetorController {

    private final SetorService setorService;
    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<SetorResponseDTO>> listarNivel() {
        List<SetorResponseDTO> setores = setorService.listar();
        return ResponseEntity.ok(setores);
    }
}
