package com.desafio.pagamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	public ResponseEntity<TransacaoDTO> realizarPagamento(@Validated @RequestBody TransacaoDTO dto) {
		return new ResponseEntity<TransacaoDTO>(transacaoServico.processarPagamento(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("estorno")
	public ResponseEntity<TransacaoDTO> realizarEstorno(@Validated @RequestBody TransacaoDTO dto) {
		return new ResponseEntity<TransacaoDTO>(transacaoServico.processarEstorno(dto), HttpStatus.CREATED);
	}

	@GetMapping("transacoes")
	public ResponseEntity<List<TransacaoDTO>> buscarTodasTransacoes(){
		return ResponseEntity.ok(transacaoServico.buscarTodasTransacoes());
	}

	@GetMapping("transacao/{id}")
	public ResponseEntity<TransacaoDTO> buscarPorIdTransacaoPagamento(@PathVariable(value = "id") String id){
		return ResponseEntity.ok(transacaoServico.buscarPorIdPagamento(id));
	}

	@GetMapping("estorno/{id}")
	public ResponseEntity<TransacaoDTO> buscarPorIdTransacaoEstorno(@PathVariable(value = "id") String id){
		return ResponseEntity.ok(transacaoServico.buscarPorIdEstorno(id));
	}
}
