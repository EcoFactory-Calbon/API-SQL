package org.example.apisql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.apisql.dto.CategoriaPerguntaRequestDTO;
import org.example.apisql.dto.CategoriaPerguntaResponseDTO;
import org.example.apisql.dto.FuncionarioResponseDTO;
import org.example.apisql.model.CategoriaPergunta;
import org.example.apisql.model.Funcionario;
import org.example.apisql.repository.CategoriaPerguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaPerguntaService {

    private final CategoriaPerguntaRepository categoriaPerguntaRepository;
    private final ObjectMapper objectMapper;

    public CategoriaPerguntaService(CategoriaPerguntaRepository categoriaPerguntaRepository, ObjectMapper objectMapper) {
        this.categoriaPerguntaRepository = categoriaPerguntaRepository;
        this.objectMapper = objectMapper;
    }


    private CategoriaPergunta fromRequestDTO(CategoriaPerguntaRequestDTO dto) {
        CategoriaPergunta categoria = new CategoriaPergunta();

        categoria.setCategoria(dto.getPergunta());
        return categoria;
    }

    private CategoriaPerguntaResponseDTO toResponseDTO(CategoriaPergunta categoria) {
        return new CategoriaPerguntaResponseDTO(
                categoria.getId(),
                categoria.getCategoria()
        );
    }


    public List<CategoriaPerguntaResponseDTO> listar() {
        return categoriaPerguntaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }




}
