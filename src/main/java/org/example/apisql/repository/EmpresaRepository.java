package org.example.apisql.repository;

import org.example.apisql.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByNome(String nome);

    Optional<Empresa> findByIdCategoria(Long idCategoria);

    Optional<Empresa> findByCnpj(String cnpj);


}
