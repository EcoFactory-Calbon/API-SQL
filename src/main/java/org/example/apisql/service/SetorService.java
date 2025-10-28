package org.example.apisql.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.example.apisql.dto.SetorRequestDTO;
import org.example.apisql.dto.SetorResponseDTO;
import org.example.apisql.exception.EmpresaNaoEncontradaException;
import org.example.apisql.exception.SetorNaoEncontradoException;
import org.example.apisql.model.Empresa; // Ensure this is imported
import org.example.apisql.model.Setor;
import org.example.apisql.repository.EmpresaRepository; // Ensure this is imported
import org.example.apisql.repository.SetorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {
    private final SetorRepository setorRepository;
    private final EmpresaRepository empresaRepository; // Needed to fetch Empresa

    public SetorService(SetorRepository setorRepository, EmpresaRepository empresaRepository) {
        this.setorRepository = setorRepository;
        this.empresaRepository = empresaRepository;
    }


    private Setor fromRequestDTO(@Valid SetorRequestDTO dto) {
        Setor setor = new Setor();
        setor.setNome(dto.getNome());
        setor.setId_empresa(dto.getId_empresa());
        return setor;
    }

    private SetorResponseDTO toResponseDTO(Setor setor) {
        return new SetorResponseDTO(
                setor.getId(),
                setor.getNome(),
                setor.getId_empresa()
        );
    }


    @Transactional(readOnly = true)
    public List<SetorResponseDTO> listar() {
        return setorRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SetorResponseDTO> buscarPorNome(String nome) {
        List<Setor> setores = setorRepository.findByNome(nome);
        return setores.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public SetorResponseDTO inserirSetor(@Valid SetorRequestDTO dto) {
        Setor setor = fromRequestDTO(dto);
        Setor salvo = setorRepository.save(setor);
        return toResponseDTO(salvo);
    }

    @Transactional
    public void excluirSetor(Integer id) {
        if (!setorRepository.existsById(id)) {
            throw new SetorNaoEncontradoException("Setor com id: "+ id +" não foi encontrado");
        }
        setorRepository.deleteById(id);
    }
}