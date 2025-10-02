package org.example.apisql.service;

import org.example.apisql.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final FuncionarioRepository funcionarioRepository;
    public AuthService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


}
