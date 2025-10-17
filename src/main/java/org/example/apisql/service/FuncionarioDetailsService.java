package org.example.apisql.service;

import org.example.apisql.repository.FuncionarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioDetailsService implements UserDetailsService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioDetailsService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long numeroCracha;
        try {
            numeroCracha = Long.parseLong(username);
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("Número do crachá inválido: " + username);
        }
        return funcionarioRepository.findById(numeroCracha)
                .orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado com o crachá: " + numeroCracha));
    }
}