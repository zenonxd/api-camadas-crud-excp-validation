# findAll - Busca paginada de produtos

Primeiro, faremos um método para buscar todos os itens, veja:

No Service:

```
@Transactional(readOnly = true)
public List<ProductDto> findAll() {
    List<Product> products = (List<Product>) productRepository.findAll();
    
    return products.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
}
```

No Controller:

```
@GetMapping
public List<ProductDto> findAll() {
    return productService.findAll();
}
```

#### Ok, e para realizar a busca paginada? Usaremos Pageable.



É muito simples. Dentro do método do Controller, podemnos passar um parametro chamado "Pageable".

Passaremos esse pageable dentro do findAll, veja:

```
@GetMapping
public Page<ProductDto> findAll(Pageable pageable) {
    return productService.findAll(pageable);
}
```

Mas o nosso service também receberá esse pageable!

```
@Transactional(readOnly = true)
public Page<ProductDto> findAll(Pageable pageable) {
    Page<Product> products = productRepository.findAll(pageable);

    //pode fazer .map direto pois Page já é uma stream
    return products.map(x -> new ProductDto(x));
}
```

Por padrão, o Pageable retorna 20 elementos

#### Customizando resultados com Pageable



**Resultado de página por tamanho**



E se quiséssemos 12 resultados ao invés de 20? Colocaremos um "QueryParam" no postman, veja:

[![img\_4.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_4.png)](../img\_4.png)

**Órdem alfabética**



[![img\_5.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_5.png)](../img\_5.png)
