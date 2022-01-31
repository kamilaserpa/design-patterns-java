package com.kamila.impl;

import com.kamila.factory.LogPrinter;
import com.kamila.factory.Logger;

public class ConsoleLogger extends Logger {

    @Override
    protected LogPrinter logPrinter() {
        return new ConsoleLogPrinter();
    }

}
