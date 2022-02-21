package com.algaworks.boleto;

import com.algaworks.Produto;

import java.math.BigDecimal;

public interface Boleto {

    void emitirBoleto(Produto produto, BigDecimal valorImposto);

}
