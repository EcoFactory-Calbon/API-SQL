package org.example.apisql.service;


import jakarta.validation.Valid;
import org.example.apisql.dto.AdminRequestDTO;
import org.example.apisql.dto.AdminResponseDTO;
import org.example.apisql.exception.AdminNaoEncotradoException;
import org.example.apisql.model.Admin;
import org.example.apisql.repository.AdminRepository;
import org.example.apisql.validation.AdminPatchValidation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminPatchValidation adminPatchValidation;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, AdminPatchValidation adminPatchValidation, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.adminPatchValidation = adminPatchValidation;
        this.passwordEncoder = passwordEncoder; // Atribuir o encoder
    }

    private Admin fromRequestDTO(AdminRequestDTO dto){
        Admin admin = new Admin();
        admin.setEmail(dto.getEmail());
        admin.setNome(dto.getNome());
        return admin;
    }

    private AdminResponseDTO toResponseDTO(Admin admin) {
        return new AdminResponseDTO(
                admin.getEmail(),
                admin.getNome()
        );
    }

    public List<AdminResponseDTO> listar() {
        return adminRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public List<AdminResponseDTO> buscarPorEmail(String email) {
        Optional<Admin> admins = adminRepository.findByEmail(email);
        return admins.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public AdminResponseDTO inserirAdmin(AdminRequestDTO dto) {
        Admin admin = fromRequestDTO(dto);
        admin.setSenha(passwordEncoder.encode(dto.getSenha()));
        Admin salvo = adminRepository.save(admin);
        return toResponseDTO(salvo);
    }

    public void excluirAdmin(String email) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new AdminNaoEncotradoException("Admin "+ email +" não encontrado"));
        adminRepository.delete(admin);
    }

    public AdminResponseDTO atualizarAdmin(@Valid AdminRequestDTO adminAtualizado, String email) {
        Admin existente = adminRepository.findByEmail(email)
                .orElseThrow(() -> new AdminNaoEncotradoException("Admin com o Email " + email + " não encontrado"));

        existente.setEmail(adminAtualizado.getEmail());
        existente.setNome(adminAtualizado.getNome());
        existente.setSenha(passwordEncoder.encode(adminAtualizado.getSenha()));

        Admin atualizado = adminRepository.save(existente);
        return toResponseDTO(atualizado);
    }

    public AdminResponseDTO atualizarAdminParcialmente(Map<String, Object> updates, String email) {
        Admin existente = adminRepository.findByEmail(email)
                .orElseThrow(() -> new AdminNaoEncotradoException("Admin com o Email " + email+ " não foi encontrado"));
        adminPatchValidation.validar(updates);

        if(updates.containsKey("email")){
            existente.setEmail(updates.get("email").toString());
        }
        if (updates.containsKey("nome")) {
            existente.setNome(updates.get("nome").toString());
        }
        if (updates.containsKey("senha")) {
            String senhaPlana = updates.get("senha").toString();
            existente.setSenha(passwordEncoder.encode(senhaPlana));
        }

        Admin atualizado = adminRepository.save(existente);
        return toResponseDTO(atualizado);
    }
}