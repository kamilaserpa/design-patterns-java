package com.algaworks.pagamento.factory;

import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.gestorderisco.clearsale.ClearSale;
import com.algaworks.operadora.Operadora;
import com.algaworks.operadora.redecard.Redecard;

public class PayPalModuloPagamentoFactory implements ModuloPagamentoFactory {

    @Override
    public Operadora criarOperadora() {
        return new Redecard();
    }

    @Override
    public GestorDeRisco criarGestorDeRisco() {
        return new ClearSale();
    }

}
