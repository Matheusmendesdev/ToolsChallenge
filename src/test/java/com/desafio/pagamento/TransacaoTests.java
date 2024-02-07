package com.desafio.pagamento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.desafio.pagamento.mocks.MocksDadosTransacao;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.pagamento.dto.enums.Status;
import com.desafio.pagamento.dto.enums.Tipo;
import com.desafio.pagamento.entidade.Descricao;
import com.desafio.pagamento.entidade.DescricaoTransacao;
import com.desafio.pagamento.entidade.FormaPagamento;

@SpringBootTest
public class TransacaoTests {
    @Test
    public void testCriarTransacao() throws Exception {

        Descricao descricaoMock = mock(Descricao.class);
        when(descricaoMock.getValor()).thenReturn("100.00");
        when(descricaoMock.getDataHora()).thenReturn(LocalDateTime.of(2021, 5, 1, 18, 30, 0));
        when(descricaoMock.getEstabelecimento()).thenReturn("Teste");
        when(descricaoMock.getNsu()).thenReturn("123456");
        when(descricaoMock.getStatus()).thenReturn(Status.AUTORIZADO);
        when(descricaoMock.getStatus()).thenReturn(Status.CANCELADO);

        FormaPagamento formaPagamentoMock = mock(FormaPagamento.class);
        when(formaPagamentoMock.getTipo()).thenReturn(Tipo.AVISTA);
        when(formaPagamentoMock.getTipo()).thenReturn(Tipo.PARCELADO_LOJA);
        when(formaPagamentoMock.getTipo()).thenReturn(Tipo.PARCELADO_EMISSOR);
        when(formaPagamentoMock.getParcelas()).thenReturn(1);

        DescricaoTransacao descricaoTransacaoMock = mock(DescricaoTransacao.class);
        when(descricaoTransacaoMock.getId()).thenReturn("132546");
        when(descricaoTransacaoMock.getCartao()).thenReturn("132546");
        when(descricaoTransacaoMock.getDescricao()).thenReturn(descricaoMock);
        when(descricaoTransacaoMock.getFormaPagamento()).thenReturn(formaPagamentoMock);

        assertNotNull(descricaoTransacaoMock);
        assertEquals("132546", descricaoTransacaoMock.getId());
        assertEquals("132546", descricaoTransacaoMock.getCartao());
        assertEquals(descricaoMock, descricaoTransacaoMock.getDescricao());
        assertEquals(formaPagamentoMock, descricaoTransacaoMock.getFormaPagamento());
    }

    @Test
    public void testGeradorNsuCodAutorizacao(){
        Map<String, String> gerarNsuCodAutorizacao = MocksDadosTransacao.gerarNsuCodAutorizacaoMock();
        assertNotNull(gerarNsuCodAutorizacao);
        assertEquals(gerarNsuCodAutorizacao.get("nsu"), "123456");
        assertEquals(gerarNsuCodAutorizacao.get("codAutorizacao"), "789");
    }

    @Test
    public void testListaTransacoes(){
        List<DescricaoTransacao> lista = MocksDadosTransacao.transacaoMock(5);
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
        assertEquals(5, lista.size());
    }

}