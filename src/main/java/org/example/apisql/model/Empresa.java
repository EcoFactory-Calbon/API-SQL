package org.example.apisql.model;
import jakarta.persistence.*;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name = "id_localizacao") // mantém o nome no banco
    private Long idLocalizacao;

    @Column(name = "id_categoria_empresa") // mantém o nome no banco
    private Long idCategoriaEmpresa;

    public Empresa() {}

    public Empresa(String nome, Long idLocalizacao, Long idCategoriaEmpresa) {
        this.nome = nome;
        this.idLocalizacao = idLocalizacao;
        this.idCategoriaEmpresa = idCategoriaEmpresa;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Long getIdLocalizacao() { return idLocalizacao; }
    public void setIdLocalizacao(Long idLocalizacao) { this.idLocalizacao = idLocalizacao; }

    public Long getIdCategoriaEmpresa() { return idCategoriaEmpresa; }
    public void setIdCategoriaEmpresa(Long idCategoriaEmpresa) { this.idCategoriaEmpresa = idCategoriaEmpresa; }
}
