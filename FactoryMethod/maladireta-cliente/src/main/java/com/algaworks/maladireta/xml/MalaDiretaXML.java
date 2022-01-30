package com.algaworks.maladireta.xml;

import com.algaworks.contato.ContatoRepository;
import com.algaworks.maladireta.MalaDireta;

public class MalaDiretaXML extends MalaDireta {

    private String nomeArquivo;

    public MalaDiretaXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    // Delega a criação de contatos a partir da implementacao selecionada de ContatoRepository
    @Override
    protected ContatoRepository contatoRepository() {
        return new ContatoRepositoryXML(nomeArquivo);
    }
}
