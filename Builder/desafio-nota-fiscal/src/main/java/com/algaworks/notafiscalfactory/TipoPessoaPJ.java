package com.algaworks.notafiscalfactory;

import java.math.BigDecimal;

public class TipoPessoaPJ implements TipoPessoa {

    @Override
    public BigDecimal getPorcentagemImposto() {
        return new BigDecimal("1.07");
    }

}
