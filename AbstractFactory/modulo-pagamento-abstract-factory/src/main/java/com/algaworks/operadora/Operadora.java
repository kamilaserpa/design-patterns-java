package com.algaworks.operadora;

import com.algaworks.operadora.exception.CapturaNaoAutorizadaException;

import java.math.BigDecimal;

public interface Operadora {

    void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException;

    Long confirmar();

}
