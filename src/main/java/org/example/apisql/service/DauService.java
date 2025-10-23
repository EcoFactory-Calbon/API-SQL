package org.example.apisql.service;

import org.example.apisql.dto.DauRequestDTO;
import org.example.apisql.dto.DauResponseDTO;
import org.example.apisql.model.Dau;
import org.example.apisql.repository.DauRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DauService {
    private final DauRepository dauRepository;

    public DauService(DauRepository dauRepository) {
        this.dauRepository = dauRepository;
    }

    private Dau fromRequestDTO(DauRequestDTO dto) {
        Dau dau = new Dau();
        dau.setEmail(dto.getEmail());
        dau.setDate(new java.sql.Date(System.currentTimeMillis()));
        return dau;
    }

    private DauResponseDTO toResponseDTO(Dau dau) {
        return new DauResponseDTO(
                dau.getId(),
                dau.getEmail(),
                dau.getDate()
        );
    }

    public List<DauResponseDTO> listar() {
        return dauRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public DauResponseDTO inserir(DauRequestDTO dto) {
        Dau dau = fromRequestDTO(dto);
        Dau salvo = dauRepository.save(dau);
        return toResponseDTO(salvo);
    }
}
