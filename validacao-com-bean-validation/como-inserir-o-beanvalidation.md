# Como inserir o BeanValidation?

Precisamos inserir as dependências do maven! Hibernate e Jakarta.

Assim, com as anotações, **ele verificará se os dados do JSON estão corretos.**

Veja como ficarão os nossos atributos da classe ProductDTO com as anotações:

```
public class ProductDto {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Size(min = 10, message = "No minimo 10 caracteres")
    private String description;

    @Positive(message = "O preço deve ser positivo")
    private Double price;
    private String imgUrl;
}
```

Agora, para que isso seja considerado na hora de receber a requisição, no nosso controlador, mais precisamente no nosso Post e Update, colocaremos um @Valid no parâmetro.

Isso executará uma preparação, para que sempre que o nosso Controller receber uma requisição de um Dto, ele passaa pelas verificações que fizemos com as anotações acima.

Com essas implementações, ao realiar uma pesquisa no Postman, teremos os retornos de código corretamente, mas sem a mensagem.

Para que tenhamos uma mensagem customizada, veja abaixo 👇

\
