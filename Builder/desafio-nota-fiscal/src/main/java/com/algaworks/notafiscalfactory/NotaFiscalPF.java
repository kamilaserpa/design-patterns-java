package com.algaworks.notafiscalfactory;

public class NotaFiscalPF extends NotaFiscal {

    @Override
    protected TipoPessoa tipoPessoa() {
        return new TipoPessoaPF();
    }

}
