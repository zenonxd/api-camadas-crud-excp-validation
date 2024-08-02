<p align="center">
  <img src="https://img.shields.io/static/v1?label=SpringProfessional - Dev Superior&message=API REST, camadas, CRUD, exception, validation&color=8257E5&labelColor=000000" alt="Testes automatizados na prática com Spring Boot" />
</p>

# Objetivo

Aprenderemos funcionalidades que a nossa aplicação irá utilizar, por exemplo:

1. CRUD - Seria a tela de cadastro de produtos, onde podemos:
   - Inserir;
   - Atualizar;
   - Deletar;
   - Consultar.


2. As funcionalidades do CRUD serão por meio da web (API via web).

## Requisitos projeto

Todas as premissas e o sumário com o que deve ser feito está no "Documento de Requesitos DSCommerce.pdf".
Como é algo específico do curso, não colocarei o link, mas você pode adquirir no site [devsuperior]().

## UML

![img.png](img.png)

## API REST - Conceitos

Primeiramente, precisamos saber o que é uma API. Uma API é um conjunto de funcionalidades que são expostas por uma
aplicação/módulo.

Pode ser considerada também como um **contrato** entre um provedor e um consumidor de funcionalidades.

### API WEB

API disponibilizada via web. Suas funcionalidades são acessadas via endpoints web (o endereço que colocamos no navegador
com aquela "/"), exemplo: host, porta, rota, parâmetros, corpo(payload), de cabeçalhos, **usando um protocolo HTTP**.

### API REST

É uma API Web que está e conformidade com as restrições do padrão REST.

#### Padrão REST - Regras
- Cliente/servidor com HTTP;
  - Uma aplicação frontend pode acessar a API via HTTP, por exemplo.
- Comunicação stateless;
  - Cada requisição será independente e isolada.
- Cache;
  - Armazenar dados em memória para melhor aproveitamento. 
- Interface uniforme, formato padronizado;
  - Rotas (especificações de como acessar a API) padronizado.
- Sistema em camadas;
- Código sob demanda (opcional)

[Veja mais](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api)

## Recursos, URL, parâmetros de consulta e de rota

As funcionalidades e informações de um sistema web são organizadas na forma de **RECURSOS**.

Cada recurso corresponde a alguma entidade do nosso negócio (ou conjunto de informações), veja, por exemplo, o recurso
Product:

URL - Universal Resource Locator

A URL deve acessar os recursos pelo nome:

- GET:host:port/products - (obtém os produtos)
- GET:host:port/products?page=3 - (obter produtos página 3)
- GET:host:port/products/1 - (obter produto id 1)
- GET:host:port/products1/categories - (obter categorias do produto id 1)

## Padrões de URL, verbos HTTP, códigos de resposta

Quando definimos a nossa rota, ela precisa ter um formato padronizado.

A ação que desejamos fazer deve ser expressa pelo verbo HTTP e não por sua rota.

<p style="color: red">ERRADO: Não é correto colocar o verbo da ação (insert) na rota</p>

- GET:host:port/insertProduct
- GET:host:port/listProduct

<p style="color: green">CERTO: Usar os verbos HTPP (post) pra inserir, (get) para obter, etc.</p>

- POST:host:port/products
- GET:host:port/products

### Verbos HTTP mais utilizados

- GET - obter recurso;
- POST - criar novo recurso;
- PUT - salvar recurso de forma idempotente;
- DELETE - deletar recurso

❗Operação idempotente = não causa novos efeitos se executada mais de uma vez.

### Códigos de resposta HTTP

- Respostas de informação (100-199);
- Respostas de sucesso (200-299);
- Redirecionamentos (300-399);
- Erros do cliente (400-499);
- Erros do Servidor (500-599).

## Padrão camadas

Organizando a aplicação em camadas com responsabilidades definidas (uma forma de reestruturar o sistema), deixando o
mesmo em um estado de fácil manutenção.

- Consiste em organizar os **COMPONENTES** do sistema em partes denominadas camadas;
<p style="background-color: red">
Componentes entenda por SERVICE, ProductService, ClientService, objetos que fazem
funções/operações. Entidades como Produto, Pedido não entram nesse quesito.
</p>

- Cada camada possui uma responsabilidade específica;

Na hora de realizar alguma manutenção, trocar qualquer coisa já sabemos onde aquilo estará pois fizemos a devidade
separação das camadas;

- Componentes de uma camada só podem depender de componentes da mesma camada, ou da camada mais abaixo, veja:

![img_1.png](img_1.png)

Controladores conversam com a camada de Service através de DTO.

Por sua vez, camada de Service conversa com a camada de acesso a dados através de Entidades (Product, Category, User).

<p style="color: red; font-weight: bold">Portanto, resumindo a imagem:</p>

1. Na camada de acesso a dados as entidades estarão devidamente mapeadas para conversar com a camada de Service.
2. Para a camada de serviço conversar com a de Controle, as entidades mapeadas serão convertidas em DTO.

<p style="color: red; font-weight: bold">TRANSAÇÃO</p>

Tudo que for transação, ou seja, acesso a banco de dados sera resolvido na camada de serviço com acesso a dados.

### Responsabilidades das camadas

- Controlador: responder interações do usuário.

No caso de uma API REST, essas "interações" são as **REQUISIÇÕES**.

- Service: realizar operações de negócio:

Um método da camada Service, deve ter um SIGNIFICADO relacionado ao negócio. Podendo executar várias operações.
Exemplo: registrarPedido, somente este método terá dentro dele: [verificar estoque, salvar pedido, baixar estoque, 
enviar email].

- Repository: realizará operações "individuais" de acesso ao banco de dados.

Métodos findAll, findById, consulta SQL, inserção/atualização/deleção de registros, etc...

## Primeiro teste da API REST

### Criação do primeiro end point

1. Criação do pacote controllers

2. Criar uma classe ProductController

Nela, será onde disponibilazaremos os recursos (GET, POST...), implementando-os.

#### Configuração da Classe

Veja tudo que foi feito: [ProductController]()

- [ ] Anotação @RestController
- [ ] Anotação RequestMapping (passando a rota a ser utilizada)
- [ ] Implementação do método desejado (GET, POST, DELETE...), exemplo:

```java
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

## Primeiro teste com Repository

Seria possível buscar um produto do banco de dados e imprimir o seu nome em um método Get? Vejamos!

Sabemos que o Repository é responsável por acessos os dados, então criaremos um!

1. Criação do pacote repositories

2. Criar uma interface ProductRepository

Veja tudo que foi feito: [ProductRepository]()

- [ ] Anotação @Repository
- [ ] Extender CrudRepository, passando o nosso objeto a ser usado (Product) e o tipo do ID (Long).

Depois disso, o Repository precisa ser injetado na classe de Controle!
```java
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
```

A partir disso, podemos usá-lo dentro dos métodos HTTP, possuindo um mundo de métodos disponíveis:

![img_2.png](img_2.png)

Como a nossa proposta conforme dito acima é procurar um produto específico, utilizaremos o findById.
```java
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

![img_3.png](img_3.png)

Beleza, perfeito e funcionou. Mas tá errado, correto? O ideal conforme vimos lá em cima é o Controller depender de um
Service. Neste cenário acima, ele está dependendo de um Repository.

Outra coisa, se você observar no método, nós estamos passando a id desejada "1L", como parâmetro.

E por fim, o nosso endpoint não retornará somente uma String e sim o Objeto todo do Product.

Vamos arruamar isso. 👇

## Criando DTO e estruturando camadas

Conforme destacado acima, pontuamos que possuimos diversas coisas a serem melhoradas, vamos lá!

### Primeiro, vamos entender uma coisa, o que seria DTO?

**DTO** - Data Transfer Object é um objeto simples para transferirmos dados.

Ele não é gerenciado por uma lib de ORM (JPA) / acesso a dados.

Além disso, pode conter outros DTO's aninhados.

❗**NUNCA ANINHE UMA ENTITY DENTRO DE UM DTO**

### Pra quê usar DTO?

Diversos motivos, veja:

- Projeção de Dados (projetar somente os dados que você precisa). O Product tem diversos atributos
mas você pode, por exemplo, querer uma busca de dados mais simples com dados básicos (id e nome), e
isso pode ser feito. Nós não precisamos expor a senha de um User ao criar um DTO.
  - Segurança
  - Economia de Tráfego
  - Flexibilidade: permite que a API trafegue mais de uma representação dos dados. Ou seja, uma entidade
  pode ter outros DTOS.
    - Para preencher um combobox: {id: number, nome: string}
    - Para um relatório detalhado: {id: number, nome: string, salario: number, email: string,
    telefones: string[] }


- Separação de responsabilidades
  - Service e repository: transação e monitoramento ORM
  - Controller: tráfego simples de dados

Na prática:

Veja o DTO criado [aqui]().

1. Criaremos um pacote chamado dto
2. Dentro dele, um ProductDto do tipo Record
3. Pegaremos os dados básicos que iremos utilizar
4. Criar construtor (com e sem argumentos)
5. Gerar Getters. Setters não precisa, pois não faz sentido alterarmos esses dados.

<hr>

Bom, como sabemos, o Controller não pode depender do Repository. Vamos organizar as camadas.

## Criação Service

Veja a classe criada [aqui]().

1. Criar pacote services
2. Criar classe ProductService
3. Passar anotação @Service
4. Injetar Repository para aí sim o service depender da camada de acesso a dados

Agora sim implementaremos a busca no banco da dados, veja o método:

```java
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

```java
    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }
```




## Dica da bilioteca ModelMapper para DTO

## CRUD

## Busca paginada de produtos

## Inserindo novo produto com POST

## Customizando resposta com ResponseEntity

## Atualizando produto com PUT

## Deletando produto com DELETE

## Criando exceções de serviço customizadas

## Implementando outras exceções 

## Validação com Bean Validation

## Customizando a resposta da validação

## DESAFIO CRUD de clientes