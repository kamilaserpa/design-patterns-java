package com.algaworks.notafiscalfactory;

import com.algaworks.builder.NotaFiscalBuilder;
import com.algaworks.builder.ProdutoBuilder;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class NotaFiscalTest {

    @Test
    public void deveCalcularNotaFiscalParaPessoaFisica() {
        NotaFiscal notaFiscal = new NotaFiscalBuilder()
                .pessoaFisica()
                .itemProduto("Bolsa",1,"10")
                .itemProduto(new ProdutoBuilder().nome("Relógio").quantidade(1).valor("10").construir())
                .numero("1234")
                .construir();

        BigDecimal valorTotal = notaFiscal.getValorTotalComImposto();

        assertEquals(new BigDecimal("20.8").doubleValue(),	valorTotal.doubleValue(), 0.0001);
    }

    @Test
    public void deveCalcularNotaFiscalParaPessoaJuridica() {
        NotaFiscal notaFiscal = new NotaFiscalBuilder()
                .pessoaJuridica()
                .itemProduto("Bolsa",1,"1")
                .itemProduto(new ProdutoBuilder().nome("Relógio").quantidade(1).valor("1").construir())
                .numero("1234")
                .construir();

        BigDecimal valorTotal = notaFiscal.getValorTotalComImposto();

        assertEquals(new BigDecimal("2.14").doubleValue(),	valorTotal.doubleValue(), 0.0001);
    }

}