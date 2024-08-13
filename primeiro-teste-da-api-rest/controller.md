# Controller

1. Criação do pacote controllers
2. Criar uma classe ProductController

Nela, será onde disponibilazaremos os recursos (GET, POST...), implementando-os.

**Configuração da Classe**



Veja tudo que foi feito: [ProductController](https://github.com/zenonxd/api-camadas-crud-excp-validation/blob/main)

* [ ] &#x20;Anotação @RestController
* [ ] &#x20;Anotação RequestMapping (passando a rota a ser utilizada)
* [ ] &#x20;Implementação do método desejado (GET, POST, DELETE...), exemplo:

```
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @GetMapping
    public String toString() {
        return "Olá, mundo!";
    }
}
```

A partir disso, ao rodar o programa, poderemos utilizar o Postman para fazer as requisições :)
