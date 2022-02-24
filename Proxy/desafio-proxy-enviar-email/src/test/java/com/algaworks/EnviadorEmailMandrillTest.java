package com.algaworks;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EnviadorEmailMandrillTest {

    String mensagem = "Olá, seja bem-vindo!";

    @Test
    public void deveEnviarEmail() {
        List<String> emails = Arrays.asList(
                "abraao@gmail.com", "isaque@gmail.com", "jaco@gmail.com", "jose@gmail.com",
                "joao@gmail.com", "maria@gmail.com", "renato@gmail.com"
        );
        EnviadorEmail enviador = new EnviadorEmailMandrillProxy(emails);
        enviador.enviar(mensagem);
    }

}