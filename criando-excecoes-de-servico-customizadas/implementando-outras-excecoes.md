# Implementando outras exceções

Ok, conforme visto acima, nós implementamos uma exceção customizada. Agora, precisamos tratar esse erro, capturando essa exceção, devolvendo uma resposta customizada no Postman.

Criaremos no pacote DTO uma classe chamada CustomError, contendo todos os atributos que é retornando em JSON no postman.

[![img\_8.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_8.png)](../img\_8.png)

Veja a classe [CustomError](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/6c92b08cd4a9d86231ab6b3f0d074d1cbc8b647d/src/main/java/com/devsuperior/dscommerce/dto/CustomError.java#L5)

Agora, usaremos a classe ControllerAdvice! Essa classe, podemos definir tratamentos globais para exceções específicas, sem precisar ficar usando vários try-catch em diversas partes do código.

Criamos um subpacote em controllers chamado handlers.

Criaremos a classe [ControllerExceptionHandler](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/6c92b08cd4a9d86231ab6b3f0d074d1cbc8b647d/src/main/java/com/devsuperior/dscommerce/controllers/handlers/ControllerExceptionHandler.java#L18).

Exemplo de um método de tratamento da exceção ^ da classe acima:

```
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;

    //instanciando a CustomError
    //status.value() pois estamos convertando um ENUM
    //e.getMessage() = pegando a mensagem do parâmetro "e" ali em cima
    //request.getRequestURI() pegando o endereço da requisição que foi feita
    CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

    return ResponseEntity.status(status).body(err);
}
```

Controller depois da alteração:

```
@GetMapping(value = "/{id}")
public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
    ProductDto dto = productService.findById(id);

    return ResponseEntity.ok(dto);
}
```

Ao rodar a aplicação no Postman:

[![img\_9.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_9.png)](../img\_9.png)
