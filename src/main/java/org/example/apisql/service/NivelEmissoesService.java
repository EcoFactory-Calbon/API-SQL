package org.example.apisql.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.apisql.dto.NivelEmissoesRequestDTO;
import org.example.apisql.dto.NivelEmissoesResponseDTO;
import org.example.apisql.model.NivelEmissoes;
import org.example.apisql.repository.NivelEmissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NivelEmissoesService {
    private final NivelEmissoesRepository nivelEmissoesRepository;
    private final ObjectMapper objectMapper;

    public NivelEmissoesService(NivelEmissoesRepository nivelEmissoesRepository, ObjectMapper objectMapper) {
        this.nivelEmissoesRepository = nivelEmissoesRepository;
        this.objectMapper = objectMapper;
    }

    private NivelEmissoes fromRequestDTO(NivelEmissoesRequestDTO dto){
        NivelEmissoes nivel = new NivelEmissoes();
        nivel.setId(dto.getId());
        nivel.setNivel_emissao(dto.getNivel_emissao());
        nivel.setValor_emissao(dto.getValor_emissao());
        nivel.setQuantidade_emissao(dto.getQuantidade_emissao());
        nivel.setId_formulario(dto.getId_formulario());
        return nivel;
    }

    private NivelEmissoesResponseDTO toResponseDTO(NivelEmissoes nivel){
        return new NivelEmissoesResponseDTO(
                nivel.getId(),
                nivel.getNivel_emissao(),
                nivel.getValor_emissao(),
                nivel.getQuantidade_emissao(),
                nivel.getId_formulario()
        );
    }


    public List<NivelEmissoesResponseDTO> listar(){
        return nivelEmissoesRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }





}
