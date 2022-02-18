package com.algaworks.pagamento.factory;

import com.algaworks.gestorderisco.GestorDeRisco;
import com.algaworks.operadora.Operadora;

/**
 * Fábrica de métodos de pagamento sem implementação. Por isso 'abstract'
 */
public interface ModuloPagamentoFactory {

    public Operadora criarOperadora();

    public GestorDeRisco criarGestorDeRisco();

}
