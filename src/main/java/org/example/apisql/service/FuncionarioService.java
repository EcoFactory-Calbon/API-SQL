package org.example.apisql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.example.apisql.dto.FuncionarioRequestDTO;
import org.example.apisql.dto.FuncionarioResponseDTO;
import org.example.apisql.exception.FuncionarioNaoEncontradoException;
import org.example.apisql.model.Funcionario;
import org.example.apisql.repository.FuncionarioRepository;
import org.example.apisql.validation.FuncionarioPatchValidation;
import org.springframework.security.crypto.password.PasswordEncoder; // IMPORTADO
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ObjectMapper objectMapper;
    private final FuncionarioPatchValidation funcionarioPatchValidation;
    private final PasswordEncoder passwordEncoder; // ADICIONADO

    // CONSTRUTOR ATUALIZADO
    public FuncionarioService(FuncionarioRepository funcionarioRepository, ObjectMapper objectMapper,
                              FuncionarioPatchValidation funcionarioPatchValidation, PasswordEncoder passwordEncoder) {
        this.funcionarioRepository = funcionarioRepository;
        this.objectMapper = objectMapper;
        this.funcionarioPatchValidation = funcionarioPatchValidation;
        this.passwordEncoder = passwordEncoder; // ADICIONADO
    }

    private Funcionario fromRequestDTO(FuncionarioRequestDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setSobrenome(dto.getSobrenome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setNumeroCracha(dto.getNumeroCracha());
        funcionario.setId_cargo(dto.getId_cargo());
        funcionario.setIs_gestor(dto.getIs_gestor());
        funcionario.setId_localizacao(dto.getId_localizacao());
        funcionario.setSenha(dto.getSenha());
        return funcionario;
    }

    private FuncionarioResponseDTO toResponseDTO(Funcionario funcionario) {
        return new FuncionarioResponseDTO(
                funcionario.getNumeroCracha(),
                funcionario.getNome(),
                funcionario.getSobrenome(),
                funcionario.getEmail(),
                funcionario.getIs_gestor()
        );
    }


    public List<FuncionarioResponseDTO> listar() {
        return funcionarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public FuncionarioResponseDTO inserirFuncionario(FuncionarioRequestDTO dto) {
        Funcionario funcionario = fromRequestDTO(dto);
        // Criptografa a senha antes de salvar
        funcionario.setSenha(passwordEncoder.encode(dto.getSenha()));
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return toResponseDTO(salvo);
    }

    public void excluirFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com ID " + id + " não encontrado"));
        funcionarioRepository.delete(funcionario);
    }

    public FuncionarioResponseDTO atualizarFuncionario(@Valid FuncionarioRequestDTO funcionarioAtualizado, Long numero_cracha) {
        Funcionario existente = funcionarioRepository.findById(numero_cracha)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com crachá " + numero_cracha + " não encontrado"));
        existente.setNome(funcionarioAtualizado.getNome());
        existente.setSobrenome(funcionarioAtualizado.getSobrenome());
        existente.setEmail(funcionarioAtualizado.getEmail());
        existente.setId_cargo(funcionarioAtualizado.getId_cargo());
        existente.setIs_gestor(funcionarioAtualizado.getIs_gestor());
        existente.setId_localizacao(funcionarioAtualizado.getId_localizacao());
        Funcionario atualizado = funcionarioRepository.save(existente);
        return toResponseDTO(atualizado);
    }

    public FuncionarioResponseDTO atualizarFuncionarioParcialmente(Map<String, Object> updates, Long id) {
        Funcionario existente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com ID " + id + " não encontrado"));

        funcionarioPatchValidation.validar(updates);

        if (updates.containsKey("nome")) existente.setNome(updates.get("nome").toString());
        if (updates.containsKey("sobrenome")) existente.setSobrenome(updates.get("sobrenome").toString());
        if (updates.containsKey("email")) existente.setEmail(updates.get("email").toString());
        if (updates.containsKey("id_cargo")) existente.setId_cargo(Long.parseLong(updates.get("id_cargo").toString()));
        if (updates.containsKey("is_gestor")) existente.setIs_gestor(Boolean.parseBoolean(updates.get("is_gestor").toString()));

        Funcionario atualizado = funcionarioRepository.save(existente);
        return toResponseDTO(atualizado);
    }


    public boolean primeiroAcesso(String email, Long cracha, Long idEmpresa) {
        return funcionarioRepository.findById(cracha)
                .filter(f -> f.getEmail().equalsIgnoreCase(email) && f.getId_localizacao().equals(idEmpresa))
                .isPresent();
    }

    public boolean registrarSenha(String email, String senha) {
        Funcionario funcionario = funcionarioRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com email " + email + " não encontrado"));

        // Criptografa a senha com BCrypt
        funcionario.setSenha(passwordEncoder.encode(senha));
        funcionarioRepository.save(funcionario);
        return true;
    }

    public boolean login(String email, String senha) {
        return funcionarioRepository.findByEmailIgnoreCase(email)
                // Compara a senha bruta (vinda do login) com a senha criptografada (do banco)
                .filter(f -> f.getSenha() != null && passwordEncoder.matches(senha, f.getSenha()))
                .isPresent();
    }
}