package com.desafio.pagamento.servico;

import java.util.*;

import com.desafio.pagamento.exception.TransacaoNaoEncontradaException;
import org.springframework.stereotype.Service;

import com.desafio.pagamento.dto.TransacaoDTO;
import com.desafio.pagamento.dto.enums.Status;
import com.desafio.pagamento.servico.util.GerarNsuCodAutorizacao;

@Service
public class TransacaoServico implements TransancaoServicoImp {
	
	
	List<TransacaoDTO> pagamentos = new ArrayList<>();
	@Override
	public TransacaoDTO processarPagamento(TransacaoDTO dto) {
		Map<String, String> nsucodaut = GerarNsuCodAutorizacao.ret();

		//Convertendo o atributo "valor" para Double e fazendo calculo para retornar o valor correto na resposta da requisição, conforme mostra nos exemplos do teste proposto.
		double valor = Double.parseDouble(dto.getDto().getDescricao().getValor()) * 0.9;

		dto.getDto().getDescricao().setValor(String.valueOf(valor));
		dto.getDto().getDescricao().setNsu(String.valueOf(nsucodaut.get("nsu")));
		dto.getDto().getDescricao().setCodigoAutorizacao(String.valueOf(nsucodaut.get("codAutorizacao")));
		dto.getDto().getDescricao().setStatus(Status.AUTORIZADO);

		pagamentos.add(dto);

		return dto;
	}
	@Override
	public TransacaoDTO processarEstorno(TransacaoDTO dto) {
		Map<String, String> nsucodaut = GerarNsuCodAutorizacao.ret();
		
		dto.getDto().getDescricao().setNsu(String.valueOf(nsucodaut.get("nsu")));
		dto.getDto().getDescricao().setCodigoAutorizacao(String.valueOf(nsucodaut.get("codAutorizacao")));
		dto.getDto().getDescricao().setStatus(Status.CANCELADO);

		pagamentos.add(dto);

		return dto;
	}

	@Override
	public List<TransacaoDTO> buscarTodasTransacoes() {
		return pagamentos;
	}

	@Override
	public TransacaoDTO buscarPorIdPagamento(String id) {
		for (TransacaoDTO pagamento : pagamentos){
			if (pagamento.getDto().getDescricao().getStatus().equals(Status.AUTORIZADO) && Objects.equals(pagamento.getDto().getId(), id)){
				return pagamento;
			}
		}
		throw new TransacaoNaoEncontradaException("Transação estorno não encontrada!");
	}

	@Override
	public TransacaoDTO buscarPorIdEstorno(String id) {
		for (TransacaoDTO pagamento : pagamentos){
			if (pagamento.getDto().getDescricao().getStatus().equals(Status.CANCELADO) && Objects.equals(pagamento.getDto().getId(), id)){
				return pagamento;
			}
		}
		throw new TransacaoNaoEncontradaException("Transação estorno não encontrada!");
	}
}
