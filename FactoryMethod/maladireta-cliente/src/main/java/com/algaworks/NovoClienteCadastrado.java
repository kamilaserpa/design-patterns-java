package com.algaworks;

import com.algaworks.maladireta.MalaDireta;
import com.algaworks.maladireta.csv.MalaDiretaCSV;
import com.algaworks.maladireta.xml.MalaDiretaXML;

import javax.swing.*;

public class NovoClienteCadastrado {

    /**
     * Envia e-mails para contatos extraídos de arquivo XML
     */
    public static void main(String[] args) {
        MalaDireta malaDiretaXML = new MalaDiretaXML("contatos.xml");

        String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem para novo cliente: ");

        boolean status = malaDiretaXML.enviarEmail(mensagem);

        JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);
    }
}
