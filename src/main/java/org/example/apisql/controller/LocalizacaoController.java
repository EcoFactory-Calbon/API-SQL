package org.example.apisql.controller;

import org.example.apisql.dto.AdminResponseDTO;
import org.example.apisql.dto.LocalizacaoRequestDTO;
import org.example.apisql.dto.LocalizacaoResponseDTO;
import org.example.apisql.model.Localizacao;
import org.example.apisql.openapi.LocalizacaoOpenApi;
import org.example.apisql.service.LocalizacaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController implements LocalizacaoOpenApi {

    private final LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LocalizacaoResponseDTO>> listarLocalizacao() {
        List<LocalizacaoResponseDTO> localizacoes = localizacaoService.listar();
        return ResponseEntity.ok(localizacoes);
    }

    @GetMapping("/buscar/{estado}")
    public ResponseEntity<List<LocalizacaoResponseDTO>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(localizacaoService.buscarPorEstado(estado));
    }


    @PostMapping("/inserir")
    public ResponseEntity<LocalizacaoResponseDTO> inserirLocalizacao(@RequestBody @Valid LocalizacaoRequestDTO dto) {
        LocalizacaoResponseDTO response = localizacaoService.inserirLocalizacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirLocalizacao(@PathVariable Integer id) {
        localizacaoService.excluirLocalizacao(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> atualizarParcialmenteLocalizacao(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        LocalizacaoResponseDTO response = localizacaoService.atualizarParcialmenteLocalizacao(updates, id);
        return ResponseEntity.ok(response);
    }


}

