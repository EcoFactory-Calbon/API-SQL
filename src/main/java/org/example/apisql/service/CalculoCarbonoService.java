package org.example.apisql.service;

import org.example.apisql.dto.CalculoCarbonoRequestDTO;
import org.example.apisql.dto.CalculoCarbonoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculoCarbonoService {

    public CalculoCarbonoResponseDTO calcular(CalculoCarbonoRequestDTO dto) {
        double emissaoCalculada;

        switch (dto.getId_CategoriaPergunta()) {
            case 1, 3, 4, 5, 6: // Categorias qualitativas (sem emissão)
                emissaoCalculada = 0.0;
                break;
            case 2:  // Energia elétrica
                emissaoCalculada = dto.getValor() * 0.08; // fator kg CO₂e / kWh
                break;
            case 7:  // Transporte
                emissaoCalculada = converterNivelParaKm(dto.getValor()) * 0.18; // fator kg CO₂e / km
                break;
            case 8:  // Alimentação
                emissaoCalculada = converterNivelParaRefeicoes(dto.getValor()) * 2.5; // fator kg CO₂e por refeição
                break;
            case 9:  // Compensação
                emissaoCalculada = dto.getValor() * -1.83; // fator kg CO₂e absorvido por árvore/mês
                break;
            case 10: // Tecnologia digital
                emissaoCalculada = converterNivelParaHoras(dto.getValor()) * 0.05; // fator kg CO₂e / hora
                break;
            default:
                emissaoCalculada = 0.0;
        }

        return new CalculoCarbonoResponseDTO(dto.getId_CategoriaPergunta(), dto.getValor() );
    }

    private double converterNivelParaKm(int nivel) {
        return switch (nivel) {
            case 0 -> 0.0;
            case 1 -> 60.0;
            case 2 -> 200.0;
            case 3 -> 480.0;
            case 4 -> 1000.0;
            case 5 -> 1600.0;
            default -> 0.0;
        };
    }

    private double converterNivelParaRefeicoes(int nivel) {
        return switch (nivel) {
            case 0 -> 0.0;
            case 1 -> 4.0;
            case 2 -> 8.0;
            case 3 -> 12.0;
            case 4 -> 16.0;
            case 5 -> 20.0;
            default -> 0.0;
        };
    }

    private double converterNivelParaHoras(int nivel) {
        return switch (nivel) {
            case 0 -> 0.0;
            case 1 -> 15.0;
            case 2 -> 30.0;
            case 3 -> 60.0;
            case 4 -> 90.0;
            case 5 -> 120.0;
            default -> 0.0;
        };
    }
}
