package com.algaworks.contatos;

import com.algaworks.repository.ContatosRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ContatosXMLProxy implements ContatosRepository {

    private ContatosXML contatosXML;
    private List<String> nomesArquivos;

    public ContatosXMLProxy(String... nomesArquivos) {
        this.nomesArquivos = new ArrayList<>(Arrays.asList(nomesArquivos));
    }

    @Override
    public String buscarPor(String email) {
        String nome = null;
        Random random = new Random();

        int quantidadeDeArquivos = nomesArquivos.size();
        for (int i = 0; i < quantidadeDeArquivos; i++) {
            // Gerando números aleatórios dentro da faixa de índices
            int indiceParaPesquisa = random.nextInt(nomesArquivos.size());

            String nomeArquivo = nomesArquivos.remove(indiceParaPesquisa);

            this.contatosXML = new ContatosXML(nomeArquivo);
            nome = this.contatosXML.buscarPor(email);
            if (nome != null) break;
        }

        return nome;
    }

}
