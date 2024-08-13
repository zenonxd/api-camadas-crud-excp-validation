# Padrão camadas (controller, serviço, Acesso a dados)

Organizando a aplicação em camadas com responsabilidades definidas (uma forma de reestruturar o sistema), deixando o mesmo em um estado de fácil manutenção.

* Consiste em organizar os **COMPONENTES** do sistema em partes denominadas camadas;

Componentes entenda por SERVICE, ProductService, ClientService, objetos que fazem funções/operações. Entidades como Produto, Pedido não entram nesse quesito.

* Cada camada possui uma responsabilidade específica;

Na hora de realizar alguma manutenção, trocar qualquer coisa já sabemos onde aquilo estará pois fizemos a devidade separação das camadas;

* Componentes de uma camada só podem depender de componentes da mesma camada, ou da camada mais abaixo, veja:

<figure><img src="../.gitbook/assets/image (1).png" alt=""><figcaption></figcaption></figure>

Controladores conversam com a camada de Service através de DTO.

Por sua vez, camada de Service conversa com a camada de acesso a dados através de Entidades (Product, Category, User).

Portanto, resumindo a imagem:

1. Na camada de acesso a dados as entidades estarão devidamente mapeadas para conversar com a camada de Service.
2. Para a camada de serviço conversar com a de Controle, as entidades mapeadas serão convertidas em DTO.

TRANSAÇÃO

Tudo que for transação, ou seja, acesso a banco de dados sera resolvido na camada de serviço com acesso a dados.
