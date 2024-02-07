package com.desafio.pagamento.mocks;
import com.desafio.pagamento.dto.enums.Status;
import com.desafio.pagamento.dto.enums.Tipo;
import com.desafio.pagamento.entidade.Descricao;
import com.desafio.pagamento.entidade.DescricaoTransacao;
import com.desafio.pagamento.entidade.FormaPagamento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MocksDadosTransacao {

    public static Map<String, String> gerarNsuCodAutorizacaoMock(){
        Map<String, String> nsuCodAutorizacao = new HashMap<>();
        nsuCodAutorizacao.put("nsu", "123456");
        nsuCodAutorizacao.put("codAutorizacao", "789");
        return nsuCodAutorizacao;
    }

    public static List<DescricaoTransacao> transacaoMock(int i){
        List<DescricaoTransacao> lista = new ArrayList<>();

        for (i = 0; i < 5; i++){
            Descricao descricaoMock = mock(Descricao.class);
            when(descricaoMock.getValor()).thenReturn("100.00" + i);
            when(descricaoMock.getDataHora()).thenReturn(LocalDateTime.of(2021, 5, 1, 18, 30, 0));
            when(descricaoMock.getEstabelecimento()).thenReturn("Teste" + i);
            when(descricaoMock.getNsu()).thenReturn("123456" + i);
            when(descricaoMock.getStatus()).thenReturn(Status.AUTORIZADO);
            when(descricaoMock.getStatus()).thenReturn(Status.CANCELADO);

            FormaPagamento formaPagamentoMock = mock(FormaPagamento.class);
            when(formaPagamentoMock.getTipo()).thenReturn(Tipo.AVISTA);
            when(formaPagamentoMock.getTipo()).thenReturn(Tipo.PARCELADO_LOJA);
            when(formaPagamentoMock.getTipo()).thenReturn(Tipo.PARCELADO_EMISSOR);
            when(formaPagamentoMock.getParcelas()).thenReturn(1);

            DescricaoTransacao descricaoTransacaoMock = mock(DescricaoTransacao.class);
            when(descricaoTransacaoMock.getId()).thenReturn("132546" + i);
            when(descricaoTransacaoMock.getCartao()).thenReturn("132546" + i);
            when(descricaoTransacaoMock.getDescricao()).thenReturn(descricaoMock);
            when(descricaoTransacaoMock.getFormaPagamento()).thenReturn(formaPagamentoMock);

            lista.add(descricaoTransacaoMock);
        }
        return lista;
    }
}
