package com.algaworks.notafiscalfactory;

public class NotaFiscalPJ extends NotaFiscal {

    @Override
    protected TipoPessoa tipoPessoa() {
        return new TipoPessoaPJ();
    }

}
