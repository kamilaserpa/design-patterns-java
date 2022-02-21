package com.algaworks.boleto.banco;

import com.algaworks.Produto;
import com.algaworks.boleto.Boleto;

import java.math.BigDecimal;

public class CaixaBoleto implements Boleto {

    @Override
    public void emitirBoleto(Produto produto, BigDecimal valorImposto) {
        BigDecimal valorUnitario = produto.getValorUnitario();

        System.out.println("----------- Boleto Caixa Econômica ---------");
        System.out.println(" Descrição: " + produto.getNome() + " -> " + produto.getQuantidade() + " x " + valorUnitario + " = " + valorUnitario.multiply(new BigDecimal(produto.getQuantidade())));
        System.out.println(" Imposto =  " + valorImposto);
        System.out.println(" Total a pagar =  " + getValorTotal(produto, valorImposto));
    }

    private BigDecimal getValorTotal(Produto produto, BigDecimal valorImposto) {
        return valorImposto.add(produto.getValorTotalSemImposto());
    }


}
