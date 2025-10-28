package org.example.apisql.repository;

import org.example.apisql.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Integer> {

    List<Setor> findByNome(String nome);
}
