package com.algaworks.pagamento;

import com.algaworks.gestorderisco.exception.AlertaDeRiscoException;
import com.algaworks.operadora.exception.CapturaNaoAutorizadaException;
import com.algaworks.pagamento.factory.ModuloPagamentoFactory;
import com.algaworks.pagamento.factory.PagSeguroModuloPagamentoFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

public class PagamentoViaPagSeguroTest {

    private Pagamento pagamento;

    @Before
    public void init() {
        ModuloPagamentoFactory pagseguro = new PagSeguroModuloPagamentoFactory();
        pagamento = new Pagamento(pagseguro);
    }

    @Test
    public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
        assertNotNull(codigoAutorizacao);
    }

    @Test(expected = CapturaNaoAutorizadaException.class)
    public void deveNegarCaptura_cartaoInvalido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("5555.2222", new BigDecimal("2000"));
    }

    @Test(expected = AlertaDeRiscoException.class)
    public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("7777.2222", new BigDecimal("5500"));
    }

}
