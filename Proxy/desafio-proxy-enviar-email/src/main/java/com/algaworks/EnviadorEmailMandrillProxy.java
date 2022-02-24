package com.algaworks;

import com.algaworks.model.Contato;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnviadorEmailMandrillProxy implements EnviadorEmail {

    private EnviadorEmailMandrill enviador;
    private List<String> emails;

    public EnviadorEmailMandrillProxy(List<String> emails) {
        this.emails = new ArrayList<>(emails);
    }

    @Override
    public void enviar(String mensagem) {
        XStream xstream = new XStream();
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        System.out.println("Carregando arquivo de contatos");
        List<Contato> contatosCarregados = (List<Contato>) xstream.fromXML(this.getClass().getResource("/emails-bloqueados.xml"));
        List<String> emails_bloqueados = contatosCarregados.stream()
                .map(c -> c.getEmail()).collect(Collectors.toList());

        emails.removeAll(emails_bloqueados);


        this.enviador = new EnviadorEmailMandrill(emails);
        this.enviador.enviar(mensagem);
    }

}
