package com.desafio.pagamento.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.desafio.pagamento.dto.TransacaoDTO;
import com.desafio.pagamento.dto.enums.Status;
import com.desafio.pagamento.servico.util.GerarNsuCodAutorizacao;

@Service
public class TransacaoServico {
	
	
	List<TransacaoDTO> pagamentos = new ArrayList<>();
	
	public TransacaoDTO processarPagamento(TransacaoDTO dto) {
		Map<String, String> nsucodaut = GerarNsuCodAutorizacao.ret();
		
		dto.getDto().getDescricao().setNsu(String.valueOf(nsucodaut.get("nsu")));
		dto.getDto().getDescricao().setCodigoAutorizacao(String.valueOf(nsucodaut.get("codAutorizacao")));
		dto.getDto().getDescricao().setStatus(Status.AUTORIZADO);

		pagamentos.add(dto);

		return dto;
	}
	
	public TransacaoDTO processarEstorno(TransacaoDTO dto) {
		Map<String, String> nsucodaut = GerarNsuCodAutorizacao.ret();
		
		dto.getDto().getDescricao().setNsu(String.valueOf(nsucodaut.get("nsu")));
		dto.getDto().getDescricao().setCodigoAutorizacao(String.valueOf(nsucodaut.get("codAutorizacao")));
		dto.getDto().getDescricao().setStatus(Status.CANCELADO);
		
		return dto;
	}
}
