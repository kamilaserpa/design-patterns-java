package com.algaworks.venda;

import com.algaworks.Produto;
import com.algaworks.venda.factory.ModuloVendaFactory;
import com.algaworks.venda.factory.VendaLojaAFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class VendaLojaATest {

    private Venda venda;

    @Before
    public void init() {
        ModuloVendaFactory lojaA = new VendaLojaAFactory();
        venda = new Venda(lojaA);
    }

    @Test
    public void deveRealizarVenda() {
        Produto produto = new Produto();
        produto.setNome("Oculos");
        produto.setQuantidade("1");
        produto.setValorUnitario(new BigDecimal("100.00"));

        BigDecimal valorTotal = venda.realizarVenda(produto);
        assertEquals(valorTotal.doubleValue(), new BigDecimal("125.00").doubleValue(), 0.0001);
    }

    @Test
    public void deveRealizarVendaDoisProdutos() {
        Produto produto = new Produto();
        produto.setNome("Garrafa Térmica");
        produto.setQuantidade("2");
        produto.setValorUnitario(new BigDecimal("100.00"));

        BigDecimal valorTotal = venda.realizarVenda(produto);
        assertEquals(valorTotal.doubleValue(), new BigDecimal("250.00").doubleValue(), 0.0001);
    }

    @Test
    public void deveRealizarVendaTresProdutos() {
        Produto produto = new Produto();
        produto.setNome("Tênis");
        produto.setQuantidade("3");
        produto.setValorUnitario(new BigDecimal("150.00"));

        BigDecimal valorTotal = venda.realizarVenda(produto);
        assertEquals(valorTotal.doubleValue(), new BigDecimal("562.50").doubleValue(), 0.0001);
    }

}