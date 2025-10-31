package org.example.apisql.controller;

import jakarta.validation.Valid;
import org.example.apisql.dto.AdminRequestDTO;
import org.example.apisql.dto.AdminResponseDTO;
import org.example.apisql.dto.CargoRequestDTO;
import org.example.apisql.dto.CargoResponseDTO;
import org.example.apisql.openapi.CargoOpenApi;
import org.example.apisql.service.AdminService;
import org.example.apisql.service.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController implements CargoOpenApi {
    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CargoResponseDTO>> listarCargo() {
        List<CargoResponseDTO> cargos = cargoService.listar();
        return ResponseEntity.ok(cargos);
    }

    @PostMapping("/inserir")
    public ResponseEntity<CargoResponseDTO> adicionarCargo(@RequestBody @Valid CargoRequestDTO dto) {
        CargoResponseDTO response = cargoService.inserirCargo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirCargo(@PathVariable Integer id) {
        cargoService.excluirCargo(id);
        return ResponseEntity.noContent().build();
    }
}
