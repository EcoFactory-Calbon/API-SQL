package org.example.apisql.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.example.apisql.dto.AdminRequestDTO;
import org.example.apisql.dto.AdminResponseDTO;
import org.example.apisql.dto.CargoRequestDTO;
import org.example.apisql.dto.CargoResponseDTO;
import org.example.apisql.exception.CargoNaoEncontradoException;
import org.example.apisql.exception.LocalizacaoNaoEncontradaException;
import org.example.apisql.model.Admin;
import org.example.apisql.model.Cargo;
import org.example.apisql.model.Localizacao;
import org.example.apisql.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    private Cargo fromRequestDTO(CargoRequestDTO dto){
        Cargo cargo = new Cargo();
        cargo.setNome(dto.getNome());
        cargo.setId_setor(dto.getId_setor());
        cargo.setNivel_cargo(dto.getNivel_cargo());
        return cargo;
    }

    private CargoResponseDTO toResponseDTO(Cargo cargo) {
        return new CargoResponseDTO(
                cargo.getId(),
                cargo.getNome(),
                cargo.getId_setor(),
                cargo.getNivel_cargo()
        );
    }

    public List<CargoResponseDTO> listar() {
        return cargoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CargoResponseDTO inserirCargo(CargoRequestDTO dto) {
        Cargo cargo = fromRequestDTO(dto);
        Cargo salvo = cargoRepository.save(cargo);
        return toResponseDTO(salvo);
    }

    public void excluirCargo(Integer id){
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow( () -> new CargoNaoEncontradoException("Cargo com id: " + id + " não foi encontrada"));
        cargoRepository.delete(cargo);

    }

}
