package com.algaworks.venda.factory;

import com.algaworks.boleto.Boleto;
import com.algaworks.notafiscal.NotaFiscal;

import java.util.Properties;

public class VendaLojaBFactory implements ModuloVendaFactory {

    Properties prop = new Properties();

    @Override
    public NotaFiscal buildNotaFiscal() {
        NotaFiscal nf = null;
        try {
            prop.load(this.getClass().getResourceAsStream("/config.properties"));
            nf = (NotaFiscal) Class
                    .forName(prop.getProperty("nfe.ce"))
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível carregar a classe para NF-e");
        }
        return nf;
    }

    @Override
    public Boleto buildBoleto() {
        Boleto boleto = null;
        try {
            prop.load(this.getClass().getResourceAsStream("/config.properties"));
            boleto = (Boleto) Class
                    .forName(prop.getProperty("boleto.caixa"))
                    .getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível carregar a classe para Boleto.");
        }
        return boleto;
    }

}
