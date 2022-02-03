package com.algaworks.notafiscalfactory;

import com.algaworks.model.Produto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class NotaFiscal {

    protected abstract TipoPessoa tipoPessoa();

    private String numero;
    private Date dataDeEmissao;
    private List<Produto> itensProduto;

    public BigDecimal getValorTotalComImposto() {
        return itensProduto.stream()
                .map(item -> item.getValor().multiply(new BigDecimal(item.getQuantidade())))
                .map(valor -> valor.multiply(tipoPessoa().getPorcentagemImposto()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataDeEmissao() {
        return dataDeEmissao;
    }

    public void setDataDeEmissao(Date dataDeEmissao) {
        this.dataDeEmissao = dataDeEmissao;
    }

    public List<Produto> getItensProduto() {
        return itensProduto;
    }

    public void setItensProduto(List<Produto> itensProduto) {
        this.itensProduto = itensProduto;
    }

}
