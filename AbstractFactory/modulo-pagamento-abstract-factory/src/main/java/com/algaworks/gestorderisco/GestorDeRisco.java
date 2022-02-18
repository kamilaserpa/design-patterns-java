package com.algaworks.gestorderisco;

import com.algaworks.gestorderisco.exception.AlertaDeRiscoException;

import java.math.BigDecimal;

/**
 * Métodos de verificação indicativo de possibilidade de fraude.
 */
public interface GestorDeRisco {

    void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException;

}
