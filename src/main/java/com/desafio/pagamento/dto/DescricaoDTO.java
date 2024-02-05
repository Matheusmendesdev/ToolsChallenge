package com.desafio.pagamento.dto;

import java.time.LocalDateTime;

import com.desafio.pagamento.dto.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DescricaoDTO {
	@JsonProperty("valor")
	private String valor;
	
	@JsonProperty("dataHora")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHora;
	
	@JsonProperty("estabelecimento")
	private String estabelecimento;
	
	@JsonProperty("nsu")
	private String nsu;
	
	@JsonProperty("codigoAutorizacao")
	private String codigoAutorizacao;
	
	@JsonProperty("status")
	private Status status;
	
	public DescricaoDTO() {}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getNsu() {
		return nsu;
	}

	public void setNsu(String nsu) {
		this.nsu = nsu;
	}

	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}

	public void setCodigoAutorizacao(String codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
