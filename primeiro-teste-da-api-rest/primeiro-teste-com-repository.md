# Primeiro teste com Repository

Seria possível buscar um produto do banco de dados e imprimir o seu nome em um método Get? Vejamos!

Sabemos que o Repository é responsável por acessos os dados, então criaremos um!

1. Criação do pacote repositories
2. Criar uma interface ProductRepository

Veja tudo que foi feito: [ProductRepository](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/main)

* [ ] &#x20;Anotação @Repository
* [ ] &#x20;Extender CrudRepository, passando o nosso objeto a ser usado (Product) e o tipo do ID (Long).

Depois disso, o Repository precisa ser injetado na classe de Controle!

```
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
```

A partir disso, podemos usá-lo dentro dos métodos HTTP, possuindo um mundo de métodos disponíveis:

[![img\_2.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_2.png)](../img\_2.png)

Como a nossa proposta conforme dito acima é procurar um produto específico, utilizaremos o findById.

```
    @GetMapping
    public String toString() {
        Optional<Product> result = productRepository.findById(1L);

        //pegando o produto que está dentro do optional.
        Product product = result.get();
        
        //como o retorno do método é String, utilizaremos o return getName().
        return product.getName();
    }
```

Ao rodar o código, poderemos buscar no Postman, veja:

[![img\_3.png](https://github.com/zenonxd/api-camadas-crud-excp-validation/raw/main/img\_3.png)](../img\_3.png)

Beleza, perfeito e funcionou. Mas tá errado, correto? O ideal conforme vimos lá em cima é o Controller depender de um Service. Neste cenário acima, ele está dependendo de um Repository.

Outra coisa, se você observar no método, nós estamos passando a id desejada "1L", como parâmetro.

E por fim, o nosso endpoint não retornará somente uma String e sim o Objeto todo do Product.

Vamos arrumar isso. 👇
