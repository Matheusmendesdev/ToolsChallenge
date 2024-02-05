package com.desafio.pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DescricaoTransacaoDTO {
	
	@JsonProperty("cartao")
	private String cartao;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("descricao")
	private DescricaoDTO descricao;
	
	@JsonProperty("formaPagamento")
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
	

}
