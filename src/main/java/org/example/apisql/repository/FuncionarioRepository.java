package org.example.apisql.repository;

import org.example.apisql.dto.FuncionarioDetalhesDTO;
import org.example.apisql.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(value = "SELECT numero_cracha, nome, sobrenome, email, cargo, setor FROM fn_listar_funcionarios_empresa(:idEmpresa)",
            nativeQuery = true)
    List<FuncionarioDetalhesDTO> findFuncionariosByEmpresaId(@Param("idEmpresa") Integer idEmpresa);

    Optional<Funcionario> findByEmail(String email);

    Optional<Funcionario> findByNumeroCracha(Long numeroCracha);

    @Query("SELECT f FROM Funcionario f WHERE f.email = :email AND f.numeroCracha = :numeroCracha")
    Optional<Funcionario> findForPrimeiroAcesso(
            @Param("email") String email,
            @Param("numeroCracha") Long numeroCracha
    );
}

