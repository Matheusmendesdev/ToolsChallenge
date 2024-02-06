package com.desafio.pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TransacaoDTO {
	@JsonProperty("transacao")
	@Valid
	private DescricaoTransacaoDTO dto;
	
	public TransacaoDTO() {}

	public DescricaoTransacaoDTO getDto() {
		return dto;
	}

	public void setDto(DescricaoTransacaoDTO dto) {
		this.dto = dto;
	}

}
