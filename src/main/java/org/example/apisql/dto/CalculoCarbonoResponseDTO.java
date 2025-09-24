package org.example.apisql.dto;

public class CalculoCarbonoResponseDTO {
    private Long idFuncionario;
    private Long idFormulario;
    private Double pegadaTransporte;
    private Double pegadaEnergia;
    private Double pegadaGas;
    private Double media;
    private Double total;
    private String nivelEmissao;

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Long idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Double getPegadaTransporte() {
        return pegadaTransporte;
    }

    public void setPegadaTransporte(Double pegadaTransporte) {
        this.pegadaTransporte = pegadaTransporte;
    }

    public Double getPegadaEnergia() {
        return pegadaEnergia;
    }

    public void setPegadaEnergia(Double pegadaEnergia) {
        this.pegadaEnergia = pegadaEnergia;
    }

    public Double getPegadaGas() {
        return pegadaGas;
    }

    public void setPegadaGas(Double pegadaGas) {
        this.pegadaGas = pegadaGas;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNivelEmissao() {
        return nivelEmissao;
    }

    public void setNivelEmissao(String nivelEmissao) {
        this.nivelEmissao = nivelEmissao;
    }
}
