package com.kamila.impl;

import com.kamila.factory.LogPrinter;
import com.kamila.factory.Logger;

public class TxtLogger extends Logger {

    @Override
    protected LogPrinter logPrinter() {
        return new TxtLogPrinter();
    }

}
