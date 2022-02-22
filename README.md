# Principais Design Patterns Aplicados com Java

Estudo dos principais Design Patterns Aplicados com Java em acompanhamento ao curso da Algaworks.

## Factory Method

"O Padrão **Factory Method** define uma interface para criar um objeto, mas permite que as classes que implementam a interface decidam qual classe instanciar.
O Factory Method permite uma classe delegar a instanciação a subclasse." (Gang Of Four)

O diagrama abaixo representa o padrão Factory Method. A classe *Creator* tem contato apenas com a *interface Product*, não sabe como cria um produto concreto. A subclasse de Creator é que conhece como criar um objeto através da implementação da interface *Product*.
![Diagrama Factory Method](FactoryMethod/factory-method-diagrama.png)

No nosso exemplo implementamos em MalaDiretaLib a classe abstrata [MalaDireta](maladireta-lib/src/main/java/com/algaworks/maladireta/MalaDireta.java) como abstração para o *Creator* e a interface [ContatoRepository](maladireta-lib/src/main/java/com/algaworks/contato/ContatoRepository.java)/Contatos como abstração para *Product* no diagrama anterior. 
As subclasses [MalaDiretaCSV](maladireta-cliente/src/main/java/com/algaworks/maladireta/csv/MalaDiretaCSV.java) e [MalaDiretaXML](maladireta-cliente/src/main/java/com/algaworks/maladireta/xml/MalaDiretaXML.java) ficam responsáveis por importar uma implementação e instanciação de um ContatoRepository.  

As subclasses de Contatos (ContatoRepository) ficam com a responsabilidade de criação da lista de objetos Contatos. 

![Diagrama do exemplo](FactoryMethod/diagrama-mala-direta-lib.png) 

<b>Classe Abstrata *vs* Interface</b>
Basicamente, além de outras diferenças: a classe abstrata pode conter implementações e a interface apenas definições.
Uma classe pode implementar múltiplas interfaces, mas estender apenas uma classe abstrata.
A classe abstrata é uma calsse, não traz relação "*é um*". Classe abstrata pode conter construtor, a interface não.

## Builder
"O <b>Padrão</b> Builder é um parão que permite a criação passo-a-passo de objetos complexos usando uma sequencia de ações. A construção é controlada por objeto diretor que apenas precisa conter o tipo do objetos que deve ser criado." (*Design Patterns: Elements od Reusable Object-Oriented from the Gang Of Four*).

![Diagrama Builder](Builder/diagrama-builder.png)

## Abstract Factory

"O <b>Padrão Abstract Factory</b> fornece uma interface para criar famílias de objetos relacionados ou dependentes sem especificar suas classes concretas." *Head First Design Patterns*

No projeto exemplo o [Pagamento](AbstractFactory/modulo-pagamento-abstract-factory/src/main/java/com/algaworks/pagamento/Pagamento.java) depende de uma implementação abstrata de [ModuloPagamentoFactory](AbstractFactory/modulo-pagamento-abstract-factory/src/main/java/com/algaworks/pagamento/factory/ModuloPagamentoFactory.java) para criar um Gestor de Risco e uma Operadora para então realizar pagamento.

![Diagrama de classes Abstract Factory](AbstractFactory/diagrama-classes-abstract-factory.png)

#### Exemplo de estrutura de bilioteca e implementação expansível

![Exemplo de estrutura 'fixa' (biblioteca) e expansível](AbstractFactory/biblioteca-abstract-factory.png)

## Proxy

Padrão de desenvolvimento com algumas variações, como criaçao de proxy remoto, controlando acesso a objetos que estão em outra JVM; proxy virtual, controla acesso a um recurso cuja criação pode ser onerosa/demorada; proxy de proteção, que controla acesso a algum recurso baseado em permissões; entre outras variações. O foco será o **proxy virtual**.

"O <b>Padrão Proxy</b> fornece um substituto ou representante de outro objeto para controlar o acesso a ele." *Head First Design Patterns*
![Diagrama proxy do eprojeto exemplo](Proxy/diagrama-proxy.png)

### Notes
Para adicionar um projeto local como dependência em outro projeto no Intellij siga os passos descritos em https://www.jetbrains.com/help/idea/working-with-module-dependencies.html#add-a-new-dependency.
