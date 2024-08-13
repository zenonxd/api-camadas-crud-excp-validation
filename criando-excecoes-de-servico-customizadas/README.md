# Criando exceções de serviço customizadas

Primeira coisa é criar um subpacote exceptions na camada que vamos trabalhar. O service pode ter, controller também, etc.

Trataremos as exceções utilizando ControllerAdvice.

Devolveremos algum código de erro na faixa do 400, veja:

[![img\_7.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_7.png)](../img\_7.png)

Para tratar a exceção nos métodos, usaremos um try-catch. No entanto, alguns métodos (como findById), o Optional tem um método que já lança uma exceção, chamado "orElseThrow()":

Service:

```
//como o service devolve um DTO para o controller,
//a função retornará um DTO
@Transactional(readOnly = true)
public ProductDto findById(Long id) {

    //busca no banco de dados, caso não ache, lançará uma exceção
    Product product = productRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Recurso não encontrado."));


    //lembrar que no DTO foi criado um construtor
  //específico para receber um Product
  return new ProductDto(product);
}
```

\
