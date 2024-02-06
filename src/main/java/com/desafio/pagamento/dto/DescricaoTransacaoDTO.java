package com.desafio.pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class DescricaoTransacaoDTO {
	
	@JsonProperty("cartao")
	@NotNull
	private String cartao;
	
	@JsonProperty("id")
	@NotNull
	private String id;
	
	@JsonProperty("descricao")
	@NotNull
	private DescricaoDTO descricao;
	
	@JsonProperty("formaPagamento")
	@NotNull
	private FormaPagamentoDTO formaPagamento;
	
	public DescricaoTransacaoDTO() {}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DescricaoDTO getDescricao() {
		return descricao;
	}

	public void setDescricao(DescricaoDTO descricao) {
		this.descricao = descricao;
	}

	public FormaPagamentoDTO getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoDTO formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "TransacaoDTO [cartao=" + cartao + ", id=" + id + ", descricao=" + descricao + ", formaPagamento="
				+ formaPagamento + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DescricaoTransacaoDTO that = (DescricaoTransacaoDTO) o;
		return Objects.equals(cartao, that.cartao) && Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(formaPagamento, that.formaPagamento);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartao, id, descricao, formaPagamento);
	}
}
