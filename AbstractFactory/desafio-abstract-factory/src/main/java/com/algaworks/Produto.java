package com.algaworks;

import java.math.BigDecimal;

public class Produto {

    private String nome;
    private String quantidade;
    private BigDecimal valorUnitario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotalSemImposto() {
        return valorUnitario.multiply(new BigDecimal(quantidade));
    }

    public BigDecimal getValorTotalComImposto(BigDecimal imposto) {
        return imposto.add(getValorTotalSemImposto());
    }

}
