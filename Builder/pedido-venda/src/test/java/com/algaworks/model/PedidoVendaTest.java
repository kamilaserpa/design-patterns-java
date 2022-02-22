package com.algaworks.model;

import com.algaworks.model.builder.PedidoVendaBuilder;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PedidoVendaTest {

    @Test
    public void deveCalcularValorTotalPedidoParaClienteVip() {
        PedidoVenda pedidoVenda = new PedidoVendaBuilder()
                .comClienteVip("")
                .comItem("Calculadora", 2, "200")
                .comItem("Mochila", 1, "200")
                .comNumero("02893") // Regra pedido para ser válido deve ter número
                .construir();

        BigDecimal valorTotal = pedidoVenda.getValorTotal();

        assertEquals(new BigDecimal("576").doubleValue(),
                valorTotal.doubleValue(),
                0.0001);
    }

}