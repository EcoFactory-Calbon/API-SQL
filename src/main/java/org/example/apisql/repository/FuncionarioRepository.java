package org.example.apisql.repository;

import org.example.apisql.dto.FuncionarioDetalhesDTO;
import org.example.apisql.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query(value = "SELECT numero_cracha, nome, sobrenome, email, cargo, setor FROM fn_listar_funcionarios_empresa(:idEmpresa)",
            nativeQuery = true)
    List<FuncionarioDetalhesDTO> findFuncionariosByEmpresaId(@Param("idEmpresa") Integer idEmpresa);


}