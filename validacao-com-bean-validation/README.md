# Validação com Bean Validation

Nas variantes de inserir e atualizar dados, nós precisamos INFORMAR dados para salvar no banco.

Mas essa inserção de dados, pode causar uma exceção de dados inválidos.

Então temos 2 exceções: **uma de inserir e outra de atualizar.**

Nós sabemos que temos 3 validações de dados:

1. Nome: deve ter entre 3 e 80 caracteres;
2. Preço: deve ser positivo;
3. Descrição: não pode ter menos que 10 caracteres.

Essa [ApiDocs](https://jakarta.ee/specifications/bean-validation/3.0/apidocs/) possui todas as anotações possiveis de validação para ser utilizada!

Exemplos: @Email, @NotNull, @Positive, etc...
