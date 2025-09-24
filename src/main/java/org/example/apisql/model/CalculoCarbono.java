package org.example.apisql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CalculoCarbono {
    @Id
    private Long id;
    private Long numero_cracha_funcionario;
    private Long idFormulario;
    private Double pegadaTransporte;
    private Double pegadaEnergia;
    private Double pegadaGas;
    private Double media;
    private Double total;
    private String nivelEmissao; // baixo, médio, alto (ex: classificação)

    public CalculoCarbono() {}
    public CalculoCarbono(Long numero_cracha_funcionario, Long idFormulario,Double pegadaTransporte, Double pegadaEnergia, Double pegadaGas, Double media, Double total, String nivelEmissao) {
        this.numero_cracha_funcionario = numero_cracha_funcionario;
        this.idFormulario = idFormulario;
        this.pegadaTransporte = pegadaTransporte;
        this.pegadaEnergia = pegadaEnergia;
        this.pegadaGas = pegadaGas;
        this.media = media;
        this.total = total;
        this.nivelEmissao = nivelEmissao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public double getPegadaGas() {
        return pegadaGas;
    }

    public void setPegadaGas(Double pegadaGas) {
        this.pegadaGas = pegadaGas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getTotal() {
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
