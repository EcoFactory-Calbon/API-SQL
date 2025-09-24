package org.example.apisql.dto;

public class CalculoCarbonoRequestDTO {
    private Long numero_cracha_funcionario;
    private Long idFormulario;

    // Dados do formulário
    private Double distancia;        // km percorridos
    private Double consumoVeiculo;   // km/L
    private String tipoCombustivel;  // gasolina, diesel, etanol
    private Double consumoKwh;       // energia elétrica
    private Double consumoGasKg;     // gás em kg

    public Long getNumero_cracha_funcionario() {
        return numero_cracha_funcionario;
    }

    public void setNumero_cracha_funcionario(Long numero_cracha_funcionario) {
        this.numero_cracha_funcionario = numero_cracha_funcionario;
    }

    public Long getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Long idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getConsumoVeiculo() {
        return consumoVeiculo;
    }

    public void setConsumoVeiculo(Double consumoVeiculo) {
        this.consumoVeiculo = consumoVeiculo;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Double getConsumoKwh() {
        return consumoKwh;
    }

    public void setConsumoKwh(Double consumoKwh) {
        this.consumoKwh = consumoKwh;
    }

    public Double getConsumoGasKg() {
        return consumoGasKg;
    }

    public void setConsumoGasKg(Double consumoGasKg) {
        this.consumoGasKg = consumoGasKg;
    }
}
