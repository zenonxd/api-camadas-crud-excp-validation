# Criando DTO e estruturando camadas

Conforme destacado acima, pontuamos que possuimos diversas coisas a serem melhoradas, vamos lá!

#### Primeiro, vamos entender uma coisa, o que seria DTO?



**DTO** - Data Transfer Object é um objeto simples para transferirmos dados.

Ele não é gerenciado por uma lib de ORM (JPA) / acesso a dados.

Além disso, pode conter outros DTO's aninhados.

❗**NUNCA ANINHE UMA ENTITY DENTRO DE UM DTO**

#### Pra quê usar DTO?



Diversos motivos, veja:

* Projeção de Dados (projetar somente os dados que você precisa). O Product tem diversos atributos mas você pode, por exemplo, querer uma busca de dados mais simples com dados básicos (id e nome), e isso pode ser feito. Nós não precisamos expor a senha de um User ao criar um DTO.
  * Segurança
  * Economia de Tráfego
  * Flexibilidade: permite que a API trafegue mais de uma representação dos dados. Ou seja, uma entidade pode ter outros DTOS.
    * Para preencher um combobox: {id: number, nome: string}
    * Para um relatório detalhado: {id: number, nome: string, salario: number, email: string, telefones: string\[] }
* Separação de responsabilidades
  * Service e repository: transação e monitoramento ORM
  * Controller: tráfego simples de dados

Na prática:

Veja o DTO criado [aqui](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/main).

1. Criaremos um pacote chamado dto
2. Dentro dele, um ProductDto do tipo Record
3. Pegaremos os dados básicos que iremos utilizar
4. Criar construtor (com e sem argumentos)
5. Gerar Getters. Setters não precisa, pois não faz sentido alterarmos esses dados.
