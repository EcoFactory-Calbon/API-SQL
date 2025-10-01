package org.example.apisql.controller;


import org.example.apisql.dto.CalculoCarbonoRequestDTO;
import org.example.apisql.dto.CalculoCarbonoResponseDTO;
import org.example.apisql.service.CalculoCarbonoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emissoes")
public class CalculoCarbonoController {

    private final CalculoCarbonoService service;

    public CalculoCarbonoController(CalculoCarbonoService service) {
        this.service = service;
    }


    @PostMapping("/calcular")
    public CalculoCarbonoResponseDTO calcular(CalculoCarbonoRequestDTO dto) {
        return service.calcular(dto);
    }
}

