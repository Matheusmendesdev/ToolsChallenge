package com.desafio.pagamento.dto;

import com.desafio.pagamento.dto.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FormaPagamentoDTO {
	@JsonProperty("tipo")
	private Tipo tipo;

	@JsonProperty("parcelas")
	private int parcelas;

	public FormaPagamentoDTO() {
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
