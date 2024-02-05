package com.desafio.pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransacaoDTO {
	@JsonProperty("transacao")
	private DescricaoTransacaoDTO dto;
	
	public TransacaoDTO() {}

	public DescricaoTransacaoDTO getDto() {
		return dto;
	}

	public void setDto(DescricaoTransacaoDTO dto) {
		this.dto = dto;
	}

}
