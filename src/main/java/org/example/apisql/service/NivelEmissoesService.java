package org.example.apisql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.example.apisql.dto.NivelEmissoesRequestDTO;
import org.example.apisql.dto.NivelEmissoesResponseDTO;
import org.example.apisql.exception.NivelEmissaoNaoEncontradoException;
import org.example.apisql.model.NivelEmissoes;
import org.example.apisql.repository.NivelEmissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NivelEmissoesService {

    private final NivelEmissoesRepository nivelEmissoesRepository;

    public NivelEmissoesService(NivelEmissoesRepository nivelEmissoesRepository) {
        this.nivelEmissoesRepository = nivelEmissoesRepository;
    }

    private NivelEmissoes fromRequestDTO(NivelEmissoesRequestDTO dto) {
        NivelEmissoes nivel = new NivelEmissoes();
        nivel.setNivel_emissao(dto.getNivel_emissao());
        nivel.setValor_emissao(dto.getValor_emissao());
        nivel.setId_formulario(dto.getId_formulario());
        nivel.setNumero_cracha_funcionario(dto.getNumero_cracha_funcionario());
        return nivel;
    }

    private NivelEmissoesResponseDTO toResponseDTO(NivelEmissoes nivel) {
        return new NivelEmissoesResponseDTO(
                nivel.getId(),
                nivel.getNumero_cracha_funcionario(),
                nivel.getNivel_emissao(),
                nivel.getValor_emissao(),
                nivel.getId_formulario()
        );
    }

    public List<NivelEmissoesResponseDTO> listar() {
        return nivelEmissoesRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public NivelEmissoesResponseDTO inserirNivel(NivelEmissoesRequestDTO dto) {
        NivelEmissoes nivel = fromRequestDTO(dto);
        NivelEmissoes salvo = nivelEmissoesRepository.save(nivel);
        return toResponseDTO(salvo);
    }

    public void excluirNivel(Long id) {
        NivelEmissoes nivel = nivelEmissoesRepository.findById(id)
                .orElseThrow(() -> new NivelEmissaoNaoEncontradoException("Nível de emissão com ID " + id + " não encontrado"));
        nivelEmissoesRepository.delete(nivel);
    }

    public NivelEmissoesResponseDTO atualizarNivel(@Valid NivelEmissoesRequestDTO nivelAtualizado, Long id) {
        NivelEmissoes existente = nivelEmissoesRepository.findById(id)
                .orElseThrow(() -> new NivelEmissaoNaoEncontradoException("Nível de emissão com ID " + id + " não encontrado"));

        existente.setNivel_emissao(nivelAtualizado.getNivel_emissao());
        existente.setValor_emissao(nivelAtualizado.getValor_emissao());
        existente.setId_formulario(nivelAtualizado.getId_formulario());

        NivelEmissoes atualizado = nivelEmissoesRepository.save(existente);
        return toResponseDTO(atualizado);
    }

    public NivelEmissoesResponseDTO atualizarNivelParcialmente(Map<String, Object> updates, Long id) {
        NivelEmissoes existente = nivelEmissoesRepository.findById(id)
                .orElseThrow(() -> new NivelEmissaoNaoEncontradoException("Nível de emissão com ID " + id + " não encontrado"));

        if (updates.containsKey("nivel_emissao")) {
            existente.setNivel_emissao(updates.get("nivel_emissao").toString());
        }
        if (updates.containsKey("valor_emissao")) {
            existente.setValor_emissao(Double.parseDouble(updates.get("valor_emissao").toString()));
        }
        if (updates.containsKey("numero_cracha_funcionario")) {
            existente.setNumero_cracha_funcionario(Long.parseLong(updates.get("numero_cracha_funcionario").toString()));
        }
        if (updates.containsKey("id_formulario")) {
            existente.setId_formulario(Long.parseLong(updates.get("id_formulario").toString()));
        }

        NivelEmissoes atualizado = nivelEmissoesRepository.save(existente);
        return toResponseDTO(atualizado);
    }
}
