package com.kamila;

import com.kamila.impl.TxtLogger;

public class GerarLogTxt {

    public static void main(String[] args) {
        TxtLogger txtLogger = new TxtLogger();

        String message = "Mensagem registrada!";

        txtLogger.createLog(message);
    }

}
