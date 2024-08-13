# Create - Inserindo novo produto com POST

No service:

```
@Transactional
public ProductDto insert (ProductDto productDto) {
    //criando um Product para receber os dados do DTO
    Product entity = new Product();


    //salvando os dados do DTO no Product
    entity.setName(productDto.getName());
    entity.setDescription(productDto.getDescription());
    entity.setPrice(productDto.getPrice());
    entity.setImgUrl(productDto.getImgUrl());

    //salvando entidade no banco de dados
    entity = productRepository.save(entity);

    //reconvertendo para DTO
    return new ProductDto(entity);
}
```

No Controller

```
@PostMapping
public ProductDto insert(@RequestBody ProductDto productDto) {
    return productService.insert(productDto);
}
```

\
