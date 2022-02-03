package com.algaworks.notafiscalfactory;

import java.math.BigDecimal;

public class TipoPessoaPF implements TipoPessoa{

    @Override
    public BigDecimal getPorcentagemImposto() {
        return new BigDecimal("1.04");
    }

}
