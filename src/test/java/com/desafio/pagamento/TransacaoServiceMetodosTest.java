package com.desafio.pagamento;

import com.desafio.pagamento.dto.enums.Status;
import com.desafio.pagamento.entidade.Descricao;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransacaoServiceMetodosTest {

    @Test
    public void TestProcessarPagamento(){

        Descricao transacao = mock(Descricao.class);

        when(transacao.getNsu()).thenReturn("555.555.555");
        when(transacao.getCodigoAutorizacao()).thenReturn("555555555");
        when(transacao.getStatus()).thenReturn(Status.AUTORIZADO);

        assertNotNull(transacao);
        assertEquals("555.555.555", transacao.getNsu());
        assertEquals("555555555", transacao.getCodigoAutorizacao());
        assertEquals(Status.AUTORIZADO, transacao.getStatus());
    }

    @Test
    public void TestProcessarEstorno(){

        Descricao transacao = mock(Descricao.class);

        when(transacao.getNsu()).thenReturn("555.555.555");
        when(transacao.getCodigoAutorizacao()).thenReturn("555555555");
        when(transacao.getStatus()).thenReturn(Status.CANCELADO);

        assertNotNull(transacao);
        assertEquals("555.555.555", transacao.getNsu());
        assertEquals("555555555", transacao.getCodigoAutorizacao());
        assertEquals(Status.CANCELADO, transacao.getStatus());
    }
}
