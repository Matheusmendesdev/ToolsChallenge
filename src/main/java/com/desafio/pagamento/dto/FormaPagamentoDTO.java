package com.desafio.pagamento.dto;

import com.desafio.pagamento.dto.enums.Tipo;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class FormaPagamentoDTO {
	@JsonProperty("tipo")
	@NotEmpty
	private Tipo tipo;

	@JsonProperty("parcelas")
	@NotEmpty
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormaPagamentoDTO that = (FormaPagamentoDTO) o;
		return parcelas == that.parcelas && tipo == that.tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipo, parcelas);
	}
}
