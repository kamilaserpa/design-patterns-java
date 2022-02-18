package com.algaworks.gestorderisco.fraudcontrol;

import com.algaworks.gestorderisco.exception.AlertaDeRiscoException;
import com.algaworks.gestorderisco.GestorDeRisco;

import java.math.BigDecimal;

public class FraudControl implements GestorDeRisco {

	@Override
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		if (cartao.startsWith("7777")) {
			throw new AlertaDeRiscoException("Cartão suspeito.");
		}
    }

}
