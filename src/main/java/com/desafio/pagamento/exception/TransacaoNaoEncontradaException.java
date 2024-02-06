package com.desafio.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransacaoNaoEncontradaException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public TransacaoNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
