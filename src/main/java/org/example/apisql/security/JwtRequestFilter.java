package org.example.apisql.security;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.apisql.service.FuncionarioDetailsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService adminDetailsService;
    private final UserDetailsService empresaDetailsService;
    private final FuncionarioDetailsService funcionarioDetailsService;

    public JwtRequestFilter(JwtUtil jwtUtil,
                            @Qualifier("adminDetailsService") UserDetailsService adminDetailsService,
                            @Qualifier("empresaDetailsService") UserDetailsService empresaDetailsService, FuncionarioDetailsService funcionarioDetailsService) {
        this.jwtUtil = jwtUtil;
        this.adminDetailsService = adminDetailsService;
        this.empresaDetailsService = empresaDetailsService;
        this.funcionarioDetailsService = funcionarioDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;
        String userType = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
            userType = jwtUtil.extractClaim(jwt, claims -> claims.get("type", String.class));
        }

        if (username != null && userType != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = null;

            if ("ADMIN".equalsIgnoreCase(userType)) {
                userDetails = adminDetailsService.loadUserByUsername(username);
            } else if ("EMPRESA".equalsIgnoreCase(userType)) {
                userDetails = empresaDetailsService.loadUserByUsername(username);
            } else if ("FUNCIONARIO".equalsIgnoreCase(userType)) {
                userDetails = funcionarioDetailsService.loadUserByUsername(username);
            }

            if (userDetails != null && jwtUtil.isTokenValido(jwt)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);
    }
}