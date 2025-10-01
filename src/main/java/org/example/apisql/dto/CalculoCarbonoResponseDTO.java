package org.example.apisql.dto;

public class CalculoCarbonoResponseDTO {
    private Integer id_CategoriaPergunta;
    private Integer valor;
//    private String nivel_emissao;

    public CalculoCarbonoResponseDTO() {}

//    public CalculoCarbonoResponseDTO(Integer id_CategoriaPergunta, Integer valor, String nivel_emissao) {
//        this.id_CategoriaPergunta = id_CategoriaPergunta;
//        this.valor = valor;
////        this.nivel_emissao = nivel_emissao;
//    }

    public CalculoCarbonoResponseDTO(Integer id_CategoriaPergunta, Integer valor) {
        this.id_CategoriaPergunta = id_CategoriaPergunta;
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getId_CategoriaPergunta() {
        return id_CategoriaPergunta;
    }

    public void setId_CategoriaPergunta(Integer id_CategoriaPergunta) {
        this.id_CategoriaPergunta = id_CategoriaPergunta;
    }

//    public String getNivel_emissao() {
//        return nivel_emissao;
//    }
//
//    public void setNivel_emissao(String nivel_emissao) {
//        this.nivel_emissao = nivel_emissao;
//    }
}
