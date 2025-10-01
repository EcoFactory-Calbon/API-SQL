package org.example.apisql.service;

import org.example.apisql.dto.CategoriaPerguntaResponseDTO;
import org.example.apisql.exception.CategoriaPerguntaNaoEncontradaException;
import org.example.apisql.model.CategoriaPergunta;
import org.example.apisql.repository.CategoriaPerguntaRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaPerguntaService {

    private final CategoriaPerguntaRepository repository;

    public CategoriaPerguntaService(CategoriaPerguntaRepository repository) {
        this.repository = repository;
    }

    public List<CategoriaPerguntaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CategoriaPerguntaResponseDTO buscarPorId(Integer id) {
        CategoriaPergunta categoria = repository.findById(id)
                .orElseThrow(() -> new CategoriaPerguntaNaoEncontradaException("Categoria com ID " + id + " não encontrada."));
        return toResponseDTO(categoria);
    }

    private CategoriaPerguntaResponseDTO toResponseDTO(CategoriaPergunta entity) {
        CategoriaPerguntaResponseDTO dto = new CategoriaPerguntaResponseDTO();
        dto.setId(entity.getId());
        dto.setCategoria(entity.getCategoria());
        return dto;
    }
}