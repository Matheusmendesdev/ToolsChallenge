package com.desafio.pagamento.exception;

public class TransacaoIdNaoEncontradoException extends RuntimeException{
    public TransacaoIdNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
