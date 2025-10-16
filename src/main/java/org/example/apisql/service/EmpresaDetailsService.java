package org.example.apisql.service;

import org.example.apisql.repository.EmpresaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmpresaDetailsService implements UserDetailsService {
    private final EmpresaRepository empresaRepository;
    public EmpresaDetailsService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String cnpj) throws UsernameNotFoundException {
        return empresaRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new UsernameNotFoundException("Empresa não encontrada com o CNPJ: " + cnpj));
    }
}
