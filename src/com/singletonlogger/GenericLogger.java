package com.singletonlogger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericLogger {
    private final String logFile = "generic_log.txt";
    private PrintWriter writer;

    public GenericLogger(){
        // Initialize PrintWriter to write formatted text to a file
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {}
    }

    public void logWithdraw (String account, double amount) {
        writer.println("WITHDRAW (" + account + "): $" + amount);
    }

    public void logDeposit (String account, double amount) {
        writer.println("DEPOSIT (" + account + "): $" + amount);
    }

    public void logTransfer (String fromAccount, String toAccount, double amount) {
        writer.println("TRANSFER (" + fromAccount + "->" + toAccount + "): $" + amount);
    }
}
