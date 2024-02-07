package com.desafio.pagamento.servico;

import java.util.*;

import com.desafio.pagamento.entidade.Transacao;
import com.desafio.pagamento.exception.TransacaoIdNaoEncontradoException;
import com.desafio.pagamento.exception.TransacaoNaoEncontradaException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.pagamento.dto.TransacaoDTO;
import com.desafio.pagamento.dto.enums.Status;
import com.desafio.pagamento.servico.util.ServicoProcessamentoDados;

@Service
public class TransacaoServico implements TransancaoServicoImp {

	//Suporte para ModelMapper para converter DTO em Entity e vice-versa
	@Autowired
	private ModelMapper modelMapper;

	public TransacaoDTO converterParaDTO(Transacao transacao) {
		return modelMapper.map(transacao, TransacaoDTO.class);
	}
	public Transacao convertParaEntity(TransacaoDTO transacaoDTO) {
		return modelMapper.map(transacaoDTO, Transacao.class);
	}

	List<TransacaoDTO> pagamentos = new ArrayList<>();
	@Override
	public TransacaoDTO processarPagamento(TransacaoDTO dto) {
		boolean idExiste = pagamentos.stream().anyMatch(transacao -> transacao.getDto().getId().equals(dto.getDto().getId())
		&& transacao.getDto().getDescricao().getStatus() == Status.AUTORIZADO);

		if (idExiste){
			throw new TransacaoIdNaoEncontradoException("Já existe uma transição de PAGAMENTO processado com esse ID.");
		}

		ServicoProcessamentoDados.setDadosDetalheNsuCodAutoStatusTransacao(dto, Status.AUTORIZADO);

		pagamentos.add(dto);

		return dto;
	}
	@Override
	public TransacaoDTO processarEstorno(TransacaoDTO dto) {
		boolean idExiste = pagamentos.stream().anyMatch(transacao -> transacao.getDto().getId().equals(dto.getDto().getId())
				&& transacao.getDto().getDescricao().getStatus() == Status.CANCELADO);

		if (idExiste){
			throw new TransacaoIdNaoEncontradoException("Já existe uma transição de ESTORNO processado com esse ID.");
		}

		ServicoProcessamentoDados.setDadosDetalheNsuCodAutoStatusTransacao(dto, Status.CANCELADO);

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
		throw new TransacaoNaoEncontradaException("Transação pagamento não encontrada!");
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
