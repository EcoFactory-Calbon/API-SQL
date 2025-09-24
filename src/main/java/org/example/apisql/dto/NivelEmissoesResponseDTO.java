package org.example.apisql.dto;

public class NivelEmissoesResponseDTO {
    private Long id;
    private Long numero_cracha_funcionario;
    private String nivel_emissao;
    private Double valor_emissao;
    private Long id_formulario;

    public NivelEmissoesResponseDTO(){}
    public NivelEmissoesResponseDTO(Long id,Long numero_cracha_funcionario, String nivel_emissao, Double valor_emissao, Long id_formulario) {
        this.id = id;
        this.numero_cracha_funcionario = numero_cracha_funcionario;
        this.nivel_emissao = nivel_emissao;
        this.valor_emissao = valor_emissao;
        this.id_formulario = id_formulario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero_cracha_funcionario() {
        return numero_cracha_funcionario;
    }

    public void setNumero_cracha_funcionario(Long numero_cracha_funcionario) {
        this.numero_cracha_funcionario = numero_cracha_funcionario;
    }

    public String getNivel_emissao() {
        return nivel_emissao;
    }

    public void setNivel_emissao(String nivel_emissao) {
        this.nivel_emissao = nivel_emissao;
    }

    public Double getValor_emissao() {
        return valor_emissao;
    }

    public void setValor_emissao(Double valor_emissao) {
        this.valor_emissao = valor_emissao;
    }

    public Long getId_formulario() {
        return id_formulario;
    }

    public void setId_formulario(Long id_formulario) {
        this.id_formulario = id_formulario;
    }
}
