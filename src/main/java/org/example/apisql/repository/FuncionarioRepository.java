package org.example.apisql.repository;

import org.example.apisql.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT f FROM Funcionario f where f.numeroCracha =: cracha ")
    List<Funcionario> findByCracha(@Param("cracha") Long cracha);



}
