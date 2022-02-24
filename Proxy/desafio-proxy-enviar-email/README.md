# Desafio: Proxy

Este desafio pode ficar interessante tanto quanto você queria deixá-lo mais real. Pois a ideia é enviar e-mails para clientes, e você pode realmente fazê-lo, de uma forma extremamente simples, uando um serviço na internet, como o Mandrill.

Se quiser apenas simular o envio de e-mails, fique a vontade. Adicione uma mensagem de log apenas para ver o comportamento esperado, ok?

Como adiantei, o exercício é baseado na ideia de enviar e-mails a clientes. O que queremos fazer é, colocar um proxy que irá controlar o acesso ao objeto que faz o envio do e-mail de fato.

Portanto você precisa pensar que terá uma classe chamada EnviadorEmailMandrill que implementa uma interface EnviadorEmail com o método abaixo:

> public void enviar(String mensagem);

No construtor da classe EnviadorEmailMandrill você irá receber uma lista de strings (e-mails).

Queremos controlar o acesso a esse objeto, adicionando os pontos abaixo:

Existe um arquivo xml com uma lista negra de e-mails, ou seja, que NÃO devem ser usados
Devemos antes de chamar o enviador de e-mails, remover esses e-mails da lista passada
Resumindo, gostaríamos de um proxy que remove todos os e-mails da lista nigra da lista original antes de passar para o enviador de e-mails de fato.

Sua tarefa é criar todo esse sistema e também o diagrama de classes.

.
Bom trabalho.