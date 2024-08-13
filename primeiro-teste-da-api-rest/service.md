# Service

Veja a classe criada [aqui](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/main).

1. Criar pacote services
2. Criar classe ProductService
3. Passar anotação @Service
4. Injetar Repository para aí sim o service depender da camada de acesso a dados

Agora sim implementaremos a busca no banco da dados, veja o método:

#### findById



```
import org.springframework.transaction.annotation.Transactional;

//como o service devolve um DTO para o controller,
//a função retornará um DTO
@Transactional(readOnly = true)
public ProductDto findById(Long id) {
    //busca no banco de dados
    Optional<Product> result = productRepository.findById(id);

    //pegamos o objeto de cima
    Product product = result.get();

    //lembrar que no DTO foi criado um construtor
    //específico para receber um Product
    ProductDto dto = new ProductDto(product);

    return dto;
}
```

Agora no Controller, tiramos o Repository e injetamos o Service :)

Método do Controller:

```
    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }
```

\
