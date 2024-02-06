package com.desafio.pagamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.desafio.pagamento.dto.enums.Status;
import com.desafio.pagamento.dto.enums.Tipo;
import com.desafio.pagamento.entidade.Descricao;
import com.desafio.pagamento.entidade.DescricaoTransacao;
import com.desafio.pagamento.entidade.FormaPagamento;
import com.desafio.pagamento.servico.TransacaoServico;

@SpringBootTest
public class TransacaoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransacaoServico transacaoServico;

    @Test
    public void testCriarTransacao() throws Exception {

        Descricao descricaoMock = mock(Descricao.class);
        when(descricaoMock.getValor()).thenReturn("100.00");
        when(descricaoMock.getDataHora()).thenReturn(LocalDateTime.of(2021, 5, 1, 18, 30, 0));
        when(descricaoMock.getEstabelecimento()).thenReturn("Teste");
        when(descricaoMock.getNsu()).thenReturn("123456");
        when(descricaoMock.getStatus()).thenReturn(Status.AUTORIZADO);

        FormaPagamento formaPagamentoMock = mock(FormaPagamento.class);
        when(formaPagamentoMock.getTipo()).thenReturn(Tipo.AVISTA);
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
}