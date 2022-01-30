package com.algaworks.maladireta.csv;

import au.com.bytecode.opencsv.CSVReader;
import com.algaworks.contato.Contato;
import com.algaworks.contato.ContatoRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

// Recupera contatos a partir de arquivo CSV
public class ContatoRepositoryCSV implements ContatoRepository {

    private String nomeArquivo;

    public ContatoRepositoryCSV(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public List<Contato> gelAll() {
        List<Contato> contatos = new ArrayList<>();
        CSVReader csvReader = null;

        try {
            URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();

            File arquivoCsv = new File(uri);
            FileReader fileReader = new FileReader(arquivoCsv);
            csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contatos.add(new Contato(nextLine[0].trim(), nextLine[1].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro lendo arquivo csv", e);

        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Erro Csv", e);
            }
        }

        return contatos;
    }

}
