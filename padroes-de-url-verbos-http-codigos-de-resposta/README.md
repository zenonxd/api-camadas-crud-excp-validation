# Padrões de URL, verbos HTTP, códigos de resposta

Quando definimos a nossa rota, ela precisa ter um formato padronizado.

A ação que desejamos fazer deve ser expressa pelo verbo HTTP e não por sua rota.

ERRADO: Não é correto colocar o verbo da ação (insert) na rota

* GET:host:port/insertProduct
* GET:host:port/listProduct

CERTO: Usar os verbos HTPP (post) pra inserir, (get) para obter, etc.

* POST:host:port/products
* GET:host:port/products
