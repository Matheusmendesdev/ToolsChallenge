package com.desafio.pagamento.entidade;

import com.desafio.pagamento.dto.enums.Tipo;

public class FormaPagamento {
	private Tipo tipo;
	
	private int parcelas;

	public FormaPagamento() {
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
}
