package com.algaworks.pagamento;

import com.algaworks.gestorderisco.exception.AlertaDeRiscoException;
import com.algaworks.operadora.exception.CapturaNaoAutorizadaException;
import com.algaworks.pagamento.factory.ModuloPagamentoFactory;
import com.algaworks.pagamento.factory.PayPalModuloPagamentoFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

public class PagamentoViaPayPalTest {

    private Pagamento pagamento;

    @Before
    public void init() {
        // Seleção da fábrica de Forma de Pagamento
        ModuloPagamentoFactory paypal = new PayPalModuloPagamentoFactory();
        pagamento = new Pagamento(paypal);
    }

    @Test
    public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
        assertNotNull(codigoAutorizacao);
    }

    @Test(expected = CapturaNaoAutorizadaException.class)
    public void deveNegarCaptura_valorAcimaDOLimiteParaCartao() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("2222.2222", new BigDecimal("2000"));
    }

    @Test
    public void deveAutorizarVenda_valorAltoComCartaoValido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("3333.2222", new BigDecimal("2000"));
        assertNotNull(codigoAutorizacao);
    }

    @Test(expected = AlertaDeRiscoException.class)
    public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("1111.2222", new BigDecimal("5500"));
    }

}
