package org.example.apisql.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    public SecurityConfig(CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

    @Bean
    // O PasswordEncoder continua sendo fundamental para criptografar e comparar as senhas
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilitar CSRF é comum para APIs REST
                .authorizeHttpRequests(auth -> auth
                        // Permitir acesso ao endpoint de criação de admin sem autenticação
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/funcionario/**").hasRole("ADMIN")
                        .requestMatchers("/localizacao/**").hasRole("ADMIN")
                        .requestMatchers("/empresa/**").hasRole("ADMIN")
                        .requestMatchers("/categoria-pergunta/**").hasRole("ADMIN")
                        .requestMatchers("/nivelEmissao/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(customAccessDeniedHandler)
                )
                .formLogin(Customizer.withDefaults()); // Mantém o formulário de login padrão
        return http.build();
    }
}