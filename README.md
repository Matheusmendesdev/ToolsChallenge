# Desafio ToolsChallenge-API

API de pagamento/estorno que realiza processamento de solicitaçoes de compra/estorno, á vista, parcelado em loja e parcelado pelo emissor. 
Para o processamento é necessário enviar os dados do cartão, descrição do produto e forma de pagamento.
A API verifica se o endpoint para pagamento é válido, verifica se o id já existe no sistema, caso já existam ela retorna uma exception.
A API permite consultar os dados do pagamento enviado para processamento.

## Tecnologias Utilizadas
O projeto foi criado com Spring Boot na linguagem de programação Java versão 11 com BD em memória, ModelMapper (apenas suporte para uma eventual implementação do banco de dados) e realizado testes unitários com JUnit.

## Arquitetura 
O projeto está divido nas seguintes camadas:

*main:*
1. Entidade  
2. Repositório
3. Serviço
4. Controle
5. DTO
6. Converte
7. Exceção
8. Testes Unitários

*test:*
1. Serviço
2. Entidade

## Como executar
1. Clonar o projeto
4. Executar no terminal o comando: ``mvn spring-boot:run``
5. Realizar uma transação de pagamento/estorno de um Cliente em memória

## Como testar 
O sistema possui 5 endpoint: 

1. **``POST api/v1/pagamento``** **``POST api/v1/estorno``**: Requisita o processamento do pagamento/estorno que está enviando no corpo da solicitação.
*Exemplo do corpo da requisição para ambos:*
```javascript
{
    "transacao": {
        "cartao": "123456789010",
        "id": "123444",
        "descricao": {
            "valor": "5000.00",
            "dataHora": "05/02/2024 19:00:00",
            "estabelecimento": "Mecanica"
        },
        "formaPagamento": {
            "tipo": "AVISTA",
            "parcelas": 1
        }
    }
}
```

2. **``GET api/v1/pagamento/{id}``** **``GET api/v1/estorno/{id}``**: Requisita os dados do pagamento/estorno do id informado na URL

3. **``GET api/v1/transacoes``**: Requisita todos os dados do pagamento/estorno
