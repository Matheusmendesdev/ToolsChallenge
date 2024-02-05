package com.desafio.pagamento.servico.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GerarNsuCodAutorizacao {
	
	public static Map<String, String> ret(){
		Map<String, String> nsuCodAutMap = new HashMap<String, String>();
		
		Random random = new Random();
		int nsu = random.nextInt(Integer.MAX_VALUE);
		int codAutorizacao = random.nextInt(Integer.MAX_VALUE);
		
		nsuCodAutMap.put("nsu", String.valueOf(nsu));
		nsuCodAutMap.put("codAutorizacao", String.valueOf(codAutorizacao));
		
		return nsuCodAutMap;
	}
}
