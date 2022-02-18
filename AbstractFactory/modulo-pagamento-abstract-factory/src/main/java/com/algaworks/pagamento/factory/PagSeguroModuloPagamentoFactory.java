package com.algaworks.pagamento.factory;

import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.gestorderisco.fraudcontrol.FraudControl;
import com.algaworks.operadora.Operadora;
import com.algaworks.operadora.cielo.Cielo;
import com.algaworks.pagamento.factory.ModuloPagamentoFactory;

public class PagSeguroModuloPagamentoFactory implements ModuloPagamentoFactory {

    @Override
    public Operadora criarOperadora() {
        return new Cielo();
    }

    @Override
    public GestorDeRisco criarGestorDeRisco() {
        return new FraudControl();
    }

}
