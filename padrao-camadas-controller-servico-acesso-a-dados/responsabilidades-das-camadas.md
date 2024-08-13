# Responsabilidades das camadas

* Controlador: responder interações do usuário.

No caso de uma API REST, essas "interações" são as **REQUISIÇÕES**.

* Service: realizar operações de negócio:

Um método da camada Service, deve ter um SIGNIFICADO relacionado ao negócio. Podendo executar várias operações. Exemplo: registrarPedido, somente este método terá dentro dele: \[verificar estoque, salvar pedido, baixar estoque, enviar email].

* Repository: realizará operações "individuais" de acesso ao banco de dados.

Métodos findAll, findById, consulta SQL, inserção/atualização/deleção de registros, etc...
