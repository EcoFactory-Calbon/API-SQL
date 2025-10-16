package org.example.apisql.service;

import org.example.apisql.dto.LoginAdminResponse;
import org.example.apisql.dto.LoginEmpresaResponse;
import org.example.apisql.repository.AdminRepository;
import org.example.apisql.repository.EmpresaRepository;
import org.example.apisql.security.JwtUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final EmpresaRepository empresaRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(EmpresaRepository empresaRepository, AdminRepository adminRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.empresaRepository = empresaRepository;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginEmpresaResponse autenticar(String cnpj, String senha) {
        var empresa = empresaRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new UsernameNotFoundException("Empresa não encontrada"));

        if (!passwordEncoder.matches(senha, empresa.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        String token = jwtUtil.generateToken(empresa);
        return new LoginEmpresaResponse(token, empresa);
    }

   public LoginAdminResponse autenticarAdmin(String email, String senha) {
        var admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Administrador não encontrado"));

        if (!passwordEncoder.matches(senha, admin.getSenha())) {
            throw new BadCredentialsException("Senha incorreta");        }

        String token = jwtUtil.generateToken(admin);
        return new LoginAdminResponse(token, admin.getNome(), admin.getEmail());
    }
}