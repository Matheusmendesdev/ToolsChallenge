package com.desafio.pagamento.exception;

import java.io.Serializable;

public class NsuInvalidoException extends IllegalArgumentException implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public NsuInvalidoException (String mensagem) {
		super(mensagem);
	}

}
