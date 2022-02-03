package com.algaworks.builder;

import com.algaworks.model.Produto;

import java.math.BigDecimal;

public class ProdutoBuilder {

    private Produto instancia;

    public ProdutoBuilder() {
        this.instancia = new Produto();
    }

    public ProdutoBuilder nome(String nome) {
        instancia.setNome(nome);
        return this;
    }

    public ProdutoBuilder quantidade(Integer quantidade) {
        instancia.setQuantidade(quantidade);
        return this;
    }

    public ProdutoBuilder valor(String valor) {
        instancia.setValor(new BigDecimal(valor));
        return this;
    }

    public Produto construir() {
        return this.instancia;
    }

}
