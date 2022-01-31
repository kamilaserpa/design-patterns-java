package com.kamila.impl;

import com.kamila.factory.LogPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleLogPrinter implements LogPrinter {

    private final Logger logger = LoggerFactory.getLogger(ConsoleLogPrinter.class);

    @Override
    public void print(String message) {
        logger.info("*-----------------LOGGER CONSOLE------------------*");
        logger.info(message);
    }

}
