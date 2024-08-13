# Deletando produto com DELETE

Service:

```
@Transactional
public void delete(Long id) {
    productRepository.deleteById(id);
}
```

Controller:

```
@DeleteMapping(value = "/{id}")
public ResponseEntity<String> delete(@PathVariable Long id) {

    productService.delete(id);

    return ResponseEntity.status(HttpStatus.OK).body("Deleted sucessfully.");
}
```
