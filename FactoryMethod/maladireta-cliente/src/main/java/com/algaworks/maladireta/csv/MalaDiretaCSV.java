package com.algaworks.maladireta.csv;

import com.algaworks.contato.ContatoRepository;
import com.algaworks.maladireta.MalaDireta;

public class MalaDiretaCSV extends MalaDireta {

    private String nomeArquivo;

    public MalaDiretaCSV(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    // Cria contatos a partir da implementacao de ContatoRepository
    @Override
    protected ContatoRepository contatoRepository() {
        return new ContatoRepositoryCSV(nomeArquivo);
    }

}
