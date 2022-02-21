package com.algaworks.venda;

import com.algaworks.Produto;
import com.algaworks.boleto.Boleto;
import com.algaworks.notafiscal.NotaFiscal;
import com.algaworks.venda.factory.ModuloVendaFactory;

import java.math.BigDecimal;

public class Venda {

    private NotaFiscal notaFiscal;
    private Boleto boleto;

    public Venda(ModuloVendaFactory documentosFactory) {
        this.notaFiscal = documentosFactory.buildNotaFiscal();
        this.boleto = documentosFactory.buildBoleto();
    }

    public BigDecimal realizarVenda(Produto produto) {
        BigDecimal imposto = this.notaFiscal.emitirNotaImposto(produto);
        this.boleto.emitirBoleto(produto, imposto);
        return produto.getValorTotalComImposto(imposto);
    }
}
