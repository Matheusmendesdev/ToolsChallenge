package com.desafio.pagamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.desafio.pagamento.dto.TransacaoDTO;
import com.desafio.pagamento.servico.TransacaoServico;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PagamentoController {

	@Autowired
	private TransacaoServico transacaoServico;

	@PostMapping("pagamento")
	public ResponseEntity<TransacaoDTO> realizarPagamento(@Valid @RequestBody TransacaoDTO dto) {
		return new ResponseEntity<TransacaoDTO>(transacaoServico.processarPagamento(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("estorno")
	public ResponseEntity<TransacaoDTO> realizarEstorno(@Valid @RequestBody TransacaoDTO dto) {
		return new ResponseEntity<TransacaoDTO>(transacaoServico.processarEstorno(dto), HttpStatus.CREATED);
	}

	@GetMapping("transacoes")
	public List<TransacaoDTO> buscarTodasTransacoes(){
		return transacaoServico.buscarTodasTransacoes();
	}
	@GetMapping("transacao/{id}")
	public TransacaoDTO buscarPorIdTransacaoPagamento(@PathVariable(value = "id") String id){
		return transacaoServico.buscarPorIdPagamento(id);
	}

}
