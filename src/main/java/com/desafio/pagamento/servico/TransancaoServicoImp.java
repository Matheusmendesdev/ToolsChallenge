package com.desafio.pagamento.servico;

import com.desafio.pagamento.dto.TransacaoDTO;
import com.desafio.pagamento.exception.TransacaoNaoEncontradaException;

import java.util.List;

public interface TransancaoServicoImp {

    TransacaoDTO processarPagamento(TransacaoDTO dto);

    TransacaoDTO processarEstorno(TransacaoDTO dto);

    List<TransacaoDTO> buscarTodasTransacoes();

    TransacaoDTO buscarPorIdPagamento(String id);

    TransacaoDTO buscarPorIdEstorno(String id);

}
