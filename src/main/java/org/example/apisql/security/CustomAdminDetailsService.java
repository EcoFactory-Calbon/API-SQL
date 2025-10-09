package org.example.apisql.security;

import org.example.apisql.repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomAdminDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public CustomAdminDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // O "username" que o Spring passa aqui é, na verdade, o email que o usuário digitou no login
        return adminRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin não encontrado com o email: " + username));
    }
}
