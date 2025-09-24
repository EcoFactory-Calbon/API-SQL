package org.example.apisql.service;

import org.example.apisql.dto.CalculoCarbonoRequestDTO;
import org.example.apisql.dto.CalculoCarbonoResponseDTO;
import org.example.apisql.model.NivelEmissoes;
import org.example.apisql.repository.NivelEmissoesRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculoCarbonoService {

    private final NivelEmissoesRepository nivelEmissoesRepository;

    public CalculoCarbonoService(NivelEmissoesRepository nivelEmissoesRepository) {
        this.nivelEmissoesRepository = nivelEmissoesRepository;
    }

    public CalculoCarbonoResponseDTO calcular(CalculoCarbonoRequestDTO request) {
        // --- Transporte ---
        double fatorEmissao = getFatorCombustivel(request.getTipoCombustivel());
        double pegadaTransporte = (request.getDistancia() / request.getConsumoVeiculo()) * fatorEmissao;

        // --- Energia ---
        double fatorEnergia = 0.05; // fator médio Brasil (kg CO2 por kWh)
        double pegadaEnergia = request.getConsumoKwh() * fatorEnergia;

        // --- Gás ---
        double fatorGas = 2.98; // kg CO2 por kg de gás
        double pegadaGas = request.getConsumoGasKg() * fatorGas;

        // --- Média e Total ---
        double total = pegadaTransporte + pegadaEnergia + pegadaGas;
        double media = total / 3;

        // --- Classificação ---
        String nivelEmissao;
        if (total < 100) {
            nivelEmissao = "Baixo";
        } else if (total < 300) {
            nivelEmissao = "Médio";
        } else {
            nivelEmissao = "Alto";
        }

        // --- Salvar no banco ---
        NivelEmissoes entity = new NivelEmissoes();
        entity.setNivel_emissao(nivelEmissao);
        entity.setValor_emissao(total);
        entity.setNumero_cracha_funcionario(request.getNumero_cracha_funcionario());
        entity.setId_formulario(request.getIdFormulario());

        nivelEmissoesRepository.save(entity);

        // --- Preencher resposta ---
        CalculoCarbonoResponseDTO response = new CalculoCarbonoResponseDTO();
        response.setIdFuncionario(request.getNumero_cracha_funcionario());
        response.setIdFormulario(request.getIdFormulario());
        response.setPegadaTransporte(pegadaTransporte);
        response.setPegadaEnergia(pegadaEnergia);
        response.setPegadaGas(pegadaGas);
        response.setTotal(total);
        response.setMedia(media);
        response.setNivelEmissao(nivelEmissao);

        return response;
    }

    private double getFatorCombustivel(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "gasolina" -> 2.31;
            case "diesel" -> 2.68;
            case "etanol" -> 1.50;
            default -> throw new IllegalArgumentException("Tipo de combustível inválido: " + tipo);
        };
    }
}
