package org.example.apisql.repository;

import org.example.apisql.model.Admin;
import org.example.apisql.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByNome(String nome);

    Optional<Empresa> findById_categoria_empresa(Long id_categoria);


}
