package com.algaworks.builder;

import com.algaworks.model.Produto;
import com.algaworks.notafiscalfactory.NotaFiscal;
import com.algaworks.notafiscalfactory.NotaFiscalPF;
import com.algaworks.notafiscalfactory.NotaFiscalPJ;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotaFiscalBuilder {

    private NotaFiscal notaFiscal;

    public NotaFiscalBuilder pessoaJuridica() {
        this.notaFiscal = new NotaFiscalPJ();
        return this;
    }

    public NotaFiscalBuilder pessoaFisica() {
        this.notaFiscal = new NotaFiscalPF();
        return this;
    }

    public NotaFiscalBuilder numero(String numero) {
        this.notaFiscal.setNumero(numero);
        return this;
    }

    public NotaFiscalBuilder dataDeEmissao(String date) throws ParseException {
        Date dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        this.notaFiscal.setDataDeEmissao(dateFormat);
        return this;
    }

    public NotaFiscalBuilder itemProduto(Produto produto) {
        if (this.notaFiscal.getItensProduto() == null) {
            this.notaFiscal.setItensProduto(new ArrayList<>());
        }
        this.notaFiscal.getItensProduto().add(produto);
        return this;
    }

    public NotaFiscalBuilder itemProduto(String nome, int quantidade, String valor) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setValor(new BigDecimal(valor));

        if (this.notaFiscal.getItensProduto() == null) {
            this.notaFiscal.setItensProduto(new ArrayList<>());
        }
        this.notaFiscal.getItensProduto().add(produto);

        return this;
    }

    public NotaFiscal construir() {
        return this.notaFiscal;
    }

}
