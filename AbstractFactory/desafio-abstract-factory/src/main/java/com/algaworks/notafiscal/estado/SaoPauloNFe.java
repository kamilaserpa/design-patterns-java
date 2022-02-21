package com.algaworks.notafiscal.estado;

import com.algaworks.Produto;
import com.algaworks.notafiscal.NotaFiscal;

import java.math.BigDecimal;

public class SaoPauloNFe implements NotaFiscal {

    @Override
    public BigDecimal emitirNotaImposto(Produto produto) {

        BigDecimal totalSemImposto = produto.getValorTotalSemImposto();
        BigDecimal imposto = calculaValorImposto(produto);
        BigDecimal totalComImposto = produto.getValorTotalComImposto(imposto);
        BigDecimal valorUnitário = produto.getValorUnitario();

        System.out.println("------- Nota Fiscal Eletrônica - SP -------");
        System.out.println(produto.getNome() + " -> " + produto.getQuantidade() + " x " + valorUnitário + " = " + totalSemImposto);
        System.out.println("Imposto = " + imposto);
        System.out.println("Valor Total = " + totalComImposto);

        return imposto;
    }

    @Override
    public BigDecimal calculaValorImposto(Produto produto) {
        BigDecimal porcentagem = new BigDecimal("0.25");
        return porcentagem.multiply(produto.getValorTotalSemImposto());
    }

}
