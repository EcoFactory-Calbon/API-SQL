package org.example.apisql.exception;


import org.example.apisql.model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ManipuladorGlobalException {
    @ExceptionHandler(DadosInvalidosException.class)
    public ResponseEntity<String> manipulaDadosInvalidos(DadosInvalidosException ex)    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Dados inválidos: " + ex.getMessage());
    }

    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public ResponseEntity<String> manipuladorFuncionarioNaoEncontradoException(FuncionarioNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario não encontrado "+ex.getMessage());
    }
    @ExceptionHandler(AdminNaoEncotradoException.class)
    public ResponseEntity<String> manipuladorAdminNaoEncontradoException(AdminNaoEncotradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Admin não encontrado "+ex.getMessage());
    }

    @ExceptionHandler(EmpresaNaoEncontradaException.class)
    public ResponseEntity<String> manipuladorEmpresaNaoEncontradaException(EmpresaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Empresa não encontrada "+ex.getMessage());
    }

    @ExceptionHandler(NivelEmissaoNaoEncontradoException.class)
    public ResponseEntity<String> manipuladorNivelEmissaoNaoEncontradoException(NivelEmissaoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nivel_Emissao não encontrado "+ex.getMessage());
    }


    @ExceptionHandler(LocalizacaoNaoEncontradaException.class)
    public ResponseEntity<String> manipuladorLocalizacaoNaoEncontradaException(LocalizacaoNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Localização não encontrada "+ex.getMessage());
    }

    @ExceptionHandler(SetorNaoEncontradoException.class)
    public ResponseEntity<String> manipuladorSetorNaoEncontradaException(SetorNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Setor não encontrado "+ex.getMessage());
    }

    @ExceptionHandler(CargoNaoEncontradoException.class)
    public ResponseEntity<String> manipuladorCargoNaoEncontradaException(CargoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cargo não encontrado "+ex.getMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manipulaRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro de execução: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manipulaException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro inesperado: " + ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<Object, Object>> manipularMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        HashMap<Object, Object> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(erros);
    }





}
