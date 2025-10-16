package org.example.apisql.service;
import jakarta.validation.Valid;
import org.example.apisql.dto.EmpresaRequestDTO;
import org.example.apisql.dto.EmpresaResponseDTO;
import org.example.apisql.exception.EmpresaNaoEncontradaException;
import org.example.apisql.model.Empresa;
import org.example.apisql.repository.EmpresaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final PasswordEncoder passwordEncoder;


    public EmpresaService(EmpresaRepository empresaRepository, PasswordEncoder passwordEncoder) {
        this.empresaRepository = empresaRepository;
        this.passwordEncoder = passwordEncoder;
    }



    private Empresa fromRequestDTO(EmpresaRequestDTO dto){
        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setIdLocalizacao(dto.getIdLocalizacao());
        empresa.setIdCategoriaEmpresa(dto.getIdCategoriaEmpresa());

        // Adicionamos os dados de login
        empresa.setCnpj(dto.getCnpj());

        // Criptografamos a senha antes de atribuí-la à entidade!
        empresa.setSenha(passwordEncoder.encode(dto.getSenha()));

        return empresa;
    }


    private EmpresaResponseDTO toResponseDTO(Empresa empresa) {
        return new EmpresaResponseDTO(
                empresa.getId(),
                empresa.getNome(),
                empresa.getIdLocalizacao(),
                empresa.getIdCategoriaEmpresa(),
                empresa.getCnpj()
        );
    }

    public List<EmpresaResponseDTO> listar(){
        return empresaRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<EmpresaResponseDTO> buscarPorNome(String nome) {
        Optional<Empresa> empresas = empresaRepository.findByNome(nome);
        return empresas.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public List<EmpresaResponseDTO> buscarPorIdCategoria(Long idCategoria) {
        Optional<Empresa> empresas = empresaRepository.findByIdCategoria(idCategoria);
        return empresas.stream()
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
        existente.setIdLocalizacao(empresaAtualizado.getIdLocalizacao());
        existente.setIdCategoriaEmpresa(empresaAtualizado.getIdCategoriaEmpresa());

        Empresa atualizado = empresaRepository.save(existente);
        return toResponseDTO(atualizado);
    }

}
