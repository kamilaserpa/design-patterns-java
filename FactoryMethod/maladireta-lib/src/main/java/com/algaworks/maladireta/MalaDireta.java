package com.algaworks.maladireta;

import com.algaworks.contato.Contato;
import com.algaworks.contato.ContatoRepository;

import java.util.List;

// Abstração, recebe lista de contatos
public abstract class MalaDireta {

    /**
     * O modificador protected torna o membro acessível às classes do mesmo pacote ou através de herança.
     * Subclasses extendem e executam o método criarContatos() com suas particularidades.
     */
    protected abstract ContatoRepository contatoRepository();


    public boolean enviarEmail(String mensagem) {

        List<Contato> contatos = contatoRepository().gelAll();

        System.out.println("Conectando no servidor SMTP...");
        System.out.println("Mensagem a ser enviada: " + mensagem);
        System.out.println();

        for (Contato contato : contatos) {
            System.out.println("From: <contato@algaworks.com>");
            System.out.printf("To: [%s] <%s>\n", contato.getNome(), contato.getEmail());
            System.out.println(mensagem);
            System.out.println();
        }

        return true;
    }

}
