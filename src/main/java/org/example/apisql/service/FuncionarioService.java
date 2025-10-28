package org.example.apisql.service;

import jakarta.validation.Valid;
import org.example.apisql.dto.*;
import org.example.apisql.exception.FuncionarioNaoEncontradoException;
import org.example.apisql.model.Funcionario;
import org.example.apisql.repository.FuncionarioRepository;
import org.example.apisql.validation.FuncionarioPatchValidation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final FuncionarioPatchValidation funcionarioPatchValidation;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, PasswordEncoder passwordEncoder, FuncionarioPatchValidation funcionarioPatchValidation) {
        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.funcionarioPatchValidation = funcionarioPatchValidation;
    }


    private Funcionario fromRequestDTO(FuncionarioRequestDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNumeroCracha(dto.getNumeroCracha());
        funcionario.setNome(dto.getNome());
        funcionario.setSobrenome(dto.getSobrenome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setSenha(passwordEncoder.encode(dto.getSenha()));
        funcionario.setId_cargo(dto.getId_cargo());
        funcionario.setIs_gestor(dto.getIs_gestor());
        funcionario.setId_localizacao(dto.getId_localizacao());
        funcionario.setPrimeiro_acesso(dto.getPrimeiro_acesso());
        return funcionario;
    }


    private FuncionarioResponseDTO toResponseDTO(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
                funcionario.getNumeroCracha(),
                funcionario.getNome(),
                funcionario.getSobrenome(),
                funcionario.getEmail(),
                funcionario.getIs_gestor() ,
                funcionario.getId_localizacao(),
                funcionario.getId_cargo()
        );
    }


    public List<FuncionarioResponseDTO> listar() {
        return funcionarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<FuncionarioResponseDTO> buscarPorCracha(Long numero_cracha) {
        Optional<Funcionario> funcionarios = funcionarioRepository.findByNumeroCracha(numero_cracha);
        return funcionarios.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<FuncionarioDetalhesDTO> buscarPorEmpresa(String cnpj){
        return funcionarioRepository.findFuncionarioByCnpj(cnpj);
    }

    public FuncionarioResponseDTO inserirFuncionario(FuncionarioRequestDTO dto) {
        Funcionario funcionario = fromRequestDTO(dto);
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return toResponseDTO(salvo);
    }

    public void excluirFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado com ID " + id + " não foi encontrado"));
        funcionarioRepository.delete(funcionario);
    }


    public FuncionarioResponseDTO atualizarFuncionario(@Valid FuncionarioRequestDTO funcionarioAtualizado, Long numero_cracha) {
        Funcionario existente = funcionarioRepository.findById(numero_cracha)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionario com o cracha " + numero_cracha + " não encontrado"));
        existente.setNome(funcionarioAtualizado.getNome());
        existente.setSobrenome(funcionarioAtualizado.getSobrenome());
        existente.setEmail(funcionarioAtualizado.getEmail());
        existente.setId_cargo(funcionarioAtualizado.getId_cargo());
        existente.setIs_gestor(funcionarioAtualizado.getIs_gestor());

        Funcionario atualizado = funcionarioRepository.save(existente);
        return toResponseDTO(atualizado);
    }

    public FuncionarioResponseDTO atualizarPerfil(String email, Map<String, Object> updates) {
        Funcionario existente = funcionarioRepository.findByEmail(email)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário autenticado não encontrado com o email: " + email));

        if (updates.containsKey("nome")) {
            existente.setNome(updates.get("nome").toString());
        }
        if (updates.containsKey("sobrenome")) {
            existente.setSobrenome(updates.get("sobrenome").toString());
        }
        if (updates.containsKey("email")) {
            existente.setEmail(updates.get("email").toString());
        }
        if (updates.containsKey("id_localizacao")) {
            existente.setId_localizacao(Long.parseLong(updates.get("id_localizacao").toString()));
        }
        if (updates.containsKey("senha")) {
            existente.setSenha(passwordEncoder.encode(updates.get("senha").toString()));
        }

        Funcionario atualizado = funcionarioRepository.save(existente);
        return toResponseDTO(atualizado);
    }


    public FuncionarioResponseDTO primeiroAcesso(PrimeiroAcessoRequestDTO dto) {
        Funcionario funcionario = funcionarioRepository.findForPrimeiroAcesso(
                        dto.getEmail(), dto.getNumeroCracha())
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Dados de funcionário não encontrados ou inconsistentes."));

        if (funcionario.getPrimeiro_acesso() == null || !funcionario.getPrimeiro_acesso()) {
            throw new IllegalStateException("Este funcionário já completou o primeiro acesso.");
        }

        return toResponseDTO(funcionario);
    }


    public void definirSenha(Long numeroCracha, DefinirSenhaRequestDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(numeroCracha)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário não encontrado."));

        if (funcionario.getPrimeiro_acesso() == null || !funcionario.getPrimeiro_acesso()) {
            throw new IllegalStateException("Operação não permitida. O primeiro acesso já foi concluído.");
        }

        funcionario.setSenha(passwordEncoder.encode(dto.getSenha()));
        funcionario.setPrimeiro_acesso(false);
        funcionarioRepository.save(funcionario);
    }
}