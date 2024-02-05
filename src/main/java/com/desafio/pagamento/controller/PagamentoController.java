package com.desafio.pagamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.pagamento.dto.TransacaoDTO;
import com.desafio.pagamento.servico.TransacaoServico;

@RestController
@RequestMapping("api/v1/")
public class PagamentoController {

	@Autowired
	private TransacaoServico pagamentoServico;

	@PostMapping("pagamento")
	public ResponseEntity<TransacaoDTO> realizarPagamento(@Valid @RequestBody TransacaoDTO dto) {
		return new ResponseEntity<TransacaoDTO>(pagamentoServico.processarPagamento(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("estorno")
	public ResponseEntity<TransacaoDTO> realizarEstorno(@Valid @RequestBody TransacaoDTO dto) {
		return new ResponseEntity<TransacaoDTO>(pagamentoServico.processarEstorno(dto), HttpStatus.CREATED);
	}

}
