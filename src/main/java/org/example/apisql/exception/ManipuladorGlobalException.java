package org.example.apisql.exception;


import org.example.apisql.model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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


    @ExceptionHandler(CategoriaPerguntaNaoEncontradaException.class)
    public ResponseEntity<String> manipuladorCategoriaPerguntaNaoEncontradaException(CategoriaPerguntaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoria de Pergunta não encontrada "+ex.getMessage());
    }




}
