package com.algaworks.maladireta.xml;

import com.algaworks.contato.Contato;
import com.algaworks.contato.ContatoRepository;
import com.thoughtworks.xstream.XStream;

import java.net.URL;
import java.util.List;

public class ContatoRepositoryXML implements ContatoRepository {

    private String nomeArquivo;

    public ContatoRepositoryXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contato> gelAll() {
        XStream xstream = new XStream();
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        URL arquivo = this.getClass().getResource("/" + nomeArquivo);
        return (List<Contato>) xstream.fromXML(arquivo);
    }

}
