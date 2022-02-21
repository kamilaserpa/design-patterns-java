package com.algaworks.notafiscal;

import com.algaworks.Produto;

import java.math.BigDecimal;

public interface NotaFiscal {

    BigDecimal emitirNotaImposto(Produto valor);

    BigDecimal calculaValorImposto(Produto produto);

}
