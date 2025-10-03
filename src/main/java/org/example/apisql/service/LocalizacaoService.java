package org.example.apisql.service;

import org.example.apisql.dto.AdminResponseDTO;
import org.example.apisql.dto.LocalizacaoRequestDTO;
import org.example.apisql.dto.LocalizacaoResponseDTO;
import org.example.apisql.exception.LocalizacaoNaoEncontradaException;
import org.example.apisql.model.Admin;
import org.example.apisql.model.Localizacao;
import org.example.apisql.repository.LocalizacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    private Localizacao fromRequestDTO(LocalizacaoRequestDTO dto){
        Localizacao localizacao = new Localizacao();
        localizacao.setEstado(dto.getEstado());
        localizacao.setCidade(dto.getCidade());
        return localizacao;
    }


    private LocalizacaoResponseDTO toResponseDTO(Localizacao localizacao){
        return new LocalizacaoResponseDTO(
                localizacao.getId(),
                localizacao.getEstado(),
                localizacao.getCidade()
        );
    }


    public List<LocalizacaoResponseDTO> listar(){
        return localizacaoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }


    public List<LocalizacaoResponseDTO> buscarPorEstado(String estado) {
        Optional<Localizacao> localizacoes = localizacaoRepository.findByEstado(estado);
        return localizacoes.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public LocalizacaoResponseDTO inserirLocalizacao(LocalizacaoRequestDTO dto){
        Localizacao localizacao = fromRequestDTO(dto);
        Localizacao salvo = localizacaoRepository.save(localizacao);
        return toResponseDTO(salvo);
    }

    public void excluirLocalizacao(Integer id){
        Localizacao localizacao = localizacaoRepository.findById(id)
                .orElseThrow( () -> new LocalizacaoNaoEncontradaException("Localização com id: " + id + " não foi encontrada"));
        localizacaoRepository.delete(localizacao);

    }


    public LocalizacaoResponseDTO atualizarParcialmenteLocalizacao(Map<String, Object> updates, Integer id){
        Localizacao existente = localizacaoRepository.findById(id)
                .orElseThrow(() -> new LocalizacaoNaoEncontradaException("Localização com o id: "+id+" não foi encontrado"));
        if (updates.containsKey("estado")) {
            existente.setEstado(updates.get("estado").toString());
        }
        if (updates.containsKey("cidade")) {
            existente.setCidade(updates.get("cidade").toString());
        }
        Localizacao atualizado = localizacaoRepository.save(existente);
        return toResponseDTO(atualizado);

    }
}
