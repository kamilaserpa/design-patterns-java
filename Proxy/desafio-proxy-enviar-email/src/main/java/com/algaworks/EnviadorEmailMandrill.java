package com.algaworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnviadorEmailMandrill implements EnviadorEmail {

    private List<String> emails;

    public EnviadorEmailMandrill(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void enviar(String mensagem) {
        for (String e : emails) {
            System.out.println("Email enviado para: " + e);
        }
    }

}
