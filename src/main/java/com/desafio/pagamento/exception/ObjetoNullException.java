package com.desafio.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjetoNullException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjetoNullException() {
        super("It is not allowed to persist a null object!");
    }
    public ObjetoNullException(String ex) {
        super(ex);
    }
}
