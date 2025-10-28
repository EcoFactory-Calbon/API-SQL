package org.example.apisql.service;

import jakarta.validation.Valid;
import org.example.apisql.dto.SetorRequestDTO;
import org.example.apisql.dto.SetorResponseDTO;
import org.example.apisql.exception.SetorNaoEncontradoException;
import org.example.apisql.model.Setor;
import org.example.apisql.repository.SetorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {
    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
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

    public List<SetorResponseDTO> buscarPorNome(String nome) {
        List<Setor> setores = setorRepository.findByNome(nome);
        return setores.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public SetorResponseDTO inserirSetor(@Valid SetorRequestDTO dto) {
        Setor setor = fromRequestDTO(dto);
        Setor salvo = setorRepository.save(setor);
        return toResponseDTO(salvo);
    }

    public void excluirSetor(Integer id) {
        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new SetorNaoEncontradoException("Setor não encontrado com ID " + id + " não foi encontrado"));
        setorRepository.delete(setor);
    }

}