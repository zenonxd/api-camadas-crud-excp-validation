# Customizando resposta com ResponseEntity

No nosso Controller, ao invés de retornarmos só DTOS ou Pages, retornaremos também ResponseEntity, veja:

```
@GetMapping(value = "/{id}")
public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
    ProductDto dto = productService.findById(id);

    return ResponseEntity.status(HttpStatus.OK).body(dto);
}
```

Você pode conferir outros exemplos das alterações com ResponseEntity [aqui](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/main)

#### ❗❗IMPORTANTE.



Em método de criação (insert) o ".CREATED", precisa receber uma URI como parametro, então fazemos dessa forma:

```
@PostMapping
public ResponseEntity<ProductDto> insert(@RequestBody ProductDto dto) {
    dto = productService.insert(dto);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();

    return ResponseEntity.created(uri).body(dto);
}
```

Desta maneira, ao realizar a inserção de dados no postman e consultar o item inserido, ele terá uma URI personalizada, veja:

[![img\_6.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_6.png)](../img\_6.png)
