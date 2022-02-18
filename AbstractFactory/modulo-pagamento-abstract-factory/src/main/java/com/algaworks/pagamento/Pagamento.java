package com.algaworks.pagamento;

import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.gestorderisco.exception.AlertaDeRiscoException;
import com.algaworks.operadora.Operadora;
import com.algaworks.operadora.exception.CapturaNaoAutorizadaException;
import com.algaworks.pagamento.factory.ModuloPagamentoFactory;

import java.math.BigDecimal;

public class Pagamento {

    private Operadora operadora;
    private GestorDeRisco gestorDeRisco;

    public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory) {
        this.operadora = moduloPagamentoFactory.criarOperadora();
        this.gestorDeRisco = moduloPagamentoFactory.criarGestorDeRisco();
    }

    public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }

}
