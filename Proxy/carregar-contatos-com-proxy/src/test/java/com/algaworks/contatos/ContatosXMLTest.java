package com.algaworks.contatos;

import com.algaworks.repository.ContatosRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContatosXMLTest {

    @Test
    public void deveRetornarContato() {
        ContatosRepository contatos = new ContatosXMLProxy("contatos1.xml", "contatos2.xml");
        String nome = contatos.buscarPor("jose@email.com");
        assertEquals("José Santos", nome);
    }

}