package org.example.apisql.exception;

public class CargoNaoEncontradoException extends RuntimeException {
    public CargoNaoEncontradoException(String message) {
        super(message);
    }
}
