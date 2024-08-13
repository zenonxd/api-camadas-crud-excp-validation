# Resumo

Lembrar o que é API Rest e seus conceitos.

Instaurar padrão de camada (controller, service, repository)

1. [Repository](https://github.com/zenonxd/api-camadas-crud-excp-validation?tab=readme-ov-file#primeiro-teste-com-repository)
2. [Service](https://github.com/zenonxd/api-camadas-crud-excp-validation?tab=readme-ov-file#cria%C3%A7%C3%A3o-service)
3. [Controller](https://github.com/zenonxd/api-camadas-crud-excp-validation?tab=readme-ov-file#controller)

***

[DTO](https://github.com/zenonxd/api-camadas-crud-excp-validation?tab=readme-ov-file#criando-dto-e-estruturando-camadas)

Implementar DTO para busca de dados.

O Dto terá os dados que queremos utilizar, e criaremos um construtor com argumentos (com os dados inseridos).

***

### Realizando consultas postman



#### [Service](src/main/java/com/devsuperior/dscommerce/services/ProductService.java)



Será utilizado para gerenciar regras de negócio, como, por exemplo, encontrar um Produto por ID, inserir, atualizar, deletar, etc.

Confira os métodos clicando acima.

Se quiser fazer busca por páginas, utilizar [pageable](https://github.com/zenonxd/api-camadas-crud-excp-validation?tab=readme-ov-file#ok-e-para-realizar-a-busca-paginada-usaremos-pageable)

### Exceptions



❗Se o método for Optional, podemos tratar diretamente no [método](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/6c92b08cd4a9d86231ab6b3f0d074d1cbc8b647d/src/main/java/com/devsuperior/dscommerce/services/ProductService.java#L25).

[Tratando exceção para retorno customizado no Postman](https://github.com/zenonxd/api-camadas-crud-excp-validation?tab=readme-ov-file#implementando-outras-exce%C3%A7%C3%B5es-)

[Validação com Bean Validaton](https://github.com/zenonxd/api-camadas-crud-excp-validation?tab=readme-ov-file#valida%C3%A7%C3%A3o-com-bean-validation)
