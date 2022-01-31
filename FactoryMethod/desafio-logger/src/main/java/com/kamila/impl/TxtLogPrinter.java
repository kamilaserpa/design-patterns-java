package com.kamila.impl;

import com.kamila.factory.LogPrinter;

public class TxtLogPrinter implements LogPrinter {


    @Override
    public void print(String message) {
        //private logger = LoggerFactory.getLogger(LogPrinterConsole.class);
        System.out.println("*-----------------LOGGER TXT------------------*");
        System.out.println(message);
    }

}
