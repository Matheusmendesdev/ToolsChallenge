package com.desafio.pagamento.servico.util;

import com.desafio.pagamento.dto.TransacaoDTO;

import java.util.List;

public interface TransancaoServicoImp {

    TransacaoDTO processarPagamento(TransacaoDTO dto);

    TransacaoDTO processarEstorno(TransacaoDTO dto);

    List<TransacaoDTO> buscarTodasTransacoes(List<TransacaoDTO> dto);

    TransacaoDTO buscarPorIdTransacao(List<TransacaoDTO> dto);

}
