package org.example.apisql.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.example.apisql.dto.EmpresaRequestDTO;
import org.example.apisql.dto.EmpresaResponseDTO;
import org.example.apisql.exception.EmpresaNaoEncontradaException;
import org.example.apisql.model.Empresa;
import org.example.apisql.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final ObjectMapper objectMapper;

    public EmpresaService(EmpresaRepository empresaRepository, ObjectMapper objectMapper) {
        this.empresaRepository = empresaRepository;
        this.objectMapper = objectMapper;
    }


    private Empresa fromRequestDTO(EmpresaRequestDTO dto){
        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setId_localizacao(dto.getId_localizacao());
        empresa.setId_categoria_empresa(dto.getId_categoria_empresa());
        return empresa;
    }


    private EmpresaResponseDTO toResponseDTO(Empresa empresa) {
        return new EmpresaResponseDTO(
                empresa.getId(),
                empresa.getNome(),
                empresa.getId_localizacao(),
                empresa.getId_categoria_empresa()
        );
    }

    public List<EmpresaResponseDTO> listar(){
        return empresaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public EmpresaResponseDTO inserirEmpresa(EmpresaRequestDTO dto) {
        Empresa empresa = fromRequestDTO(dto);
        Empresa salvo = empresaRepository.save(empresa);
        return toResponseDTO(salvo);
    }

    public void excluirEmpresa(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNaoEncontradaException("Empresa com id: "+ id +" não foi encontrado"));
        empresaRepository.delete(empresa);
    }

    public EmpresaResponseDTO atualizarEmpresa(@Valid EmpresaRequestDTO empresaAtualizado, Long id) {
        Empresa existente = empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNaoEncontradaException("Empresa com o id: " + id + " não encontrado"));
        existente.setNome(empresaAtualizado.getNome());
        existente.setId_localizacao(empresaAtualizado.getId_localizacao());
        existente.setId_categoria_empresa(empresaAtualizado.getId_categoria_empresa());

        Empresa atualizado = empresaRepository.save(existente);
        return toResponseDTO(atualizado);
    }

}
