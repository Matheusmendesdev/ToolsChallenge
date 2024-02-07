package com.desafio.pagamento.servico.util;

import com.desafio.pagamento.dto.TransacaoDTO;
import com.desafio.pagamento.dto.enums.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ServicoProcessamentoDados {
	
	public static Map<String, String> gerador(){
		Map<String, String> nsuCodAutMap = new HashMap<String, String>();
		
		Random random = new Random();
		int nsu = random.nextInt(Integer.MAX_VALUE);
		int codAutorizacao = random.nextInt(Integer.MAX_VALUE);
		
		nsuCodAutMap.put("nsu", String.valueOf(nsu));
		nsuCodAutMap.put("codAutorizacao", String.valueOf(codAutorizacao));
		
		return nsuCodAutMap;
	}

	public static void setDadosDetalheNsuCodAutoStatusTransacao(TransacaoDTO dto, Status status){
		Map<String, String> nsucodaut = ServicoProcessamentoDados.gerador();

		double valor = Double.parseDouble(dto.getDto().getDescricao().getValor()) * 0.9;

		dto.getDto().getDescricao().setValor(String.valueOf(valor));
		dto.getDto().getDescricao().setNsu(String.valueOf(nsucodaut.get("nsu")));
		dto.getDto().getDescricao().setCodigoAutorizacao(String.valueOf(nsucodaut.get("codAutorizacao")));
		dto.getDto().getDescricao().setStatus(status);
	}
}
