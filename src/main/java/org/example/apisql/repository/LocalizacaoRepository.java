package org.example.apisql.repository;

import org.example.apisql.model.Admin;
import org.example.apisql.model.Funcionario;
import org.example.apisql.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {
    Optional<Localizacao> findByEstado(String estado);
}
