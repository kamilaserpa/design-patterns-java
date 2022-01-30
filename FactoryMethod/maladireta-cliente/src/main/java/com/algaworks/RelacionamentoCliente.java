package com.algaworks;

import com.algaworks.maladireta.MalaDireta;
import com.algaworks.maladireta.csv.MalaDiretaCSV;

import javax.swing.*;

public class RelacionamentoCliente {

    /**
     * Envia e-mails para contatos extraídos de arquivo CSV
     */
    public static void main(String[] args) {
        MalaDireta malaDiretaCSV = new MalaDiretaCSV("contatos.csv");

        String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");

        boolean status = malaDiretaCSV.enviarEmail(mensagem);

        JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);
    }
}
