package com.kamila.factory;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {

    protected abstract LogPrinter logPrinter();

    public void createLog(String message) {

        String dataEHoraAtuais = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        logPrinter().print("Em " + dataEHoraAtuais + " - " + message);
    }

}
