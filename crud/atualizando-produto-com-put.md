# Atualizando produto com PUT

No postman, será um PUT. Na URI passaremos o id a ser alterado juntamente com o corpo dos itens a serem alterados, veja:

A diferença para o insert é aqui precisamos instanciar o objeto como referência (getReferenceById).

Service:

```
@Transactional //passando um Id como parâmetro pois é o que vai ser passado no postman
public ProductDto update(Long id, ProductDto dto) {

    //instanciando um produto pela ID do banco de dados
    //o produto só será instanciado com a referência que passamos (id)
    Product entity = productRepository.getReferenceById(id);

    //settando novos valores num produto já existente
    copyDtoToEntity(dto, entity);
  
    //salvando no banco
    entity = productRepository.save(entity);
  
    //reconvertendo para DTO
    return new ProductDto(entity);
}
```

Controller:

```
@PutMapping(value = "/{id}")
public ResponseEntity<ProductDto> update(@PathVariable Long id,
                                         @RequestBody ProductDto dto) {

    dto = productService.update(id, dto);

    return ResponseEntity.status(HttpStatus.OK).body(dto);
}
```

\
