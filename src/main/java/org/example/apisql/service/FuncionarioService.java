package org.example.apisql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.example.apisql.dto.FuncionarioRequestDTO;
import org.example.apisql.dto.FuncionarioResponseDTO;
import org.example.apisql.exception.FuncionarioNaoEncontradoException;
import org.example.apisql.model.Funcionario;
import org.example.apisql.repository.FuncionarioRepository;
import org.example.apisql.validation.FuncionarioPatchValidation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioPatchValidation funcionarioPatchValidation;


    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioPatchValidation funcionarioPatchValidation) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioPatchValidation = funcionarioPatchValidation;
    }

    private Funcionario fromRequestDTO(FuncionarioRequestDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setSobrenome(dto.getSobrenome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setNumero_cracha(dto.getNumero_cracha());
        funcionario.setId_cargo(dto.getId_cargo());
        funcionario.setIs_gestor(dto.getIs_gestor());
        return funcionario;
    }


    private FuncionarioResponseDTO toResponseDTO(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
                funcionario.getNome(),
                funcionario.getSobrenome(),
                funcionario.getEmail(),
                funcionario.getNumero_cracha(),
                funcionario.getIs_gestor()
        );
    }


    public List<FuncionarioResponseDTO> listar() {
        return funcionarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<FuncionarioResponseDTO> buscarPorCracha(Long numero_cracha) {
        Optional<Funcionario> funcionarios = funcionarioRepository.findById(numero_cracha);
        return funcionarios.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
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


    public FuncionarioResponseDTO atualizarFuncionarioParcialmente(Map<String, Object> updates, Long id) {
        Funcionario existente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionario com o id " + id + " não foi encontrado"));
        funcionarioPatchValidation.validar(updates);

        if (updates.containsKey("nome")) {
            existente.setNome(updates.get("nome").toString());
        }
        if (updates.containsKey("sobrenome")) {
            existente.setSobrenome(updates.get("sobrenome").toString());
        }
        if (updates.containsKey("email")) {
            existente.setEmail(updates.get("email").toString());
        }
        if (updates.containsKey("id_cargo")) {
            existente.setId_cargo(Long.parseLong(updates.get("id_cargo").toString()));
        }
        if (updates.containsKey("is_gestor")) {
            existente.setIs_gestor(Boolean.parseBoolean(updates.get("is_gestor").toString()));
        }
        Funcionario atualizado = funcionarioRepository.save(existente);
        return toResponseDTO(atualizado);
    }
}
