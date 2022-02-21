package com.algaworks.venda.factory;

import com.algaworks.boleto.Boleto;
import com.algaworks.notafiscal.NotaFiscal;

public interface ModuloVendaFactory {

    NotaFiscal buildNotaFiscal();

    Boleto buildBoleto();

}
