package org.example.apisql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.apisql.dto.*;
import org.example.apisql.exception.CategoriaPerguntaNaoEncontradaException;
import org.example.apisql.exception.EmpresaNaoEncontradaException;
import org.example.apisql.model.CategoriaPergunta;
import org.example.apisql.model.Empresa;
import org.example.apisql.model.Funcionario;
import org.example.apisql.repository.CategoriaPerguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaPerguntaService {

    private final CategoriaPerguntaRepository categoriaPerguntaRepository;

    public CategoriaPerguntaService(CategoriaPerguntaRepository categoriaPerguntaRepository) {
        this.categoriaPerguntaRepository = categoriaPerguntaRepository;
    }


    private CategoriaPergunta fromRequestDTO(CategoriaPerguntaRequestDTO dto) {
        CategoriaPergunta categoria = new CategoriaPergunta();

        categoria.setCategoria(dto.getCategoria());
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

    public CategoriaPerguntaResponseDTO inserirCategoriaPergunta(CategoriaPerguntaRequestDTO dto) {
        CategoriaPergunta categoriaPergunta = fromRequestDTO(dto);
        CategoriaPergunta salvo = categoriaPerguntaRepository.save(categoriaPergunta);
        return toResponseDTO(salvo);
    }

    public void excluirCategoriaEmpresa(Integer id) {
        CategoriaPergunta categoriaPergunta = categoriaPerguntaRepository.findById(id)
                .orElseThrow(() -> new CategoriaPerguntaNaoEncontradaException("Categoria com id: "+ id +" não foi encontrado"));
        categoriaPerguntaRepository.delete(categoriaPergunta);
    }




}
