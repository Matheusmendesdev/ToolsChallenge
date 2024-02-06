package com.desafio.pagamento.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.desafio.pagamento.dto.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DescricaoDTO {
	@JsonProperty("valor")
	@NotBlank
	private String valor;
	
	@JsonProperty("dataHora")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@NotNull
	private LocalDateTime dataHora;
	
	@JsonProperty("estabelecimento")
	@NotBlank
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DescricaoDTO that = (DescricaoDTO) o;
		return Objects.equals(valor, that.valor) && Objects.equals(dataHora, that.dataHora) && Objects.equals(estabelecimento, that.estabelecimento) && Objects.equals(nsu, that.nsu) && Objects.equals(codigoAutorizacao, that.codigoAutorizacao) && status == that.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor, dataHora, estabelecimento, nsu, codigoAutorizacao, status);
	}
}
