package com.kamila;

import com.kamila.impl.ConsoleLogger;

public class GerarLogConsole {

    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger();

        String message = "Mensagem registrada!";

        consoleLogger.createLog(message);
    }

}
