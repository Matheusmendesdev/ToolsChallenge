package com.desafio.pagamento.servico;

import com.desafio.pagamento.dto.TransacaoDTO;

import java.util.List;

public interface TransancaoServicoImp {

    TransacaoDTO processarPagamento(TransacaoDTO dto);

    TransacaoDTO processarEstorno(TransacaoDTO dto);

    List<TransacaoDTO> buscarTodasTransacoes();

    TransacaoDTO buscarPorIdPagamento(String id);

}
