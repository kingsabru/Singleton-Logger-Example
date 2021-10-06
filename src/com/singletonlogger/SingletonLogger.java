package com.singletonlogger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SingletonLogger {
    private static SingletonLogger logger;

    private final String logFile = "singleton_log.txt";
    private PrintWriter writer;

    // Private constructor
    private SingletonLogger(){
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {}
    }


    public static SingletonLogger getInstance(){
        if(logger == null){
            synchronized (SingletonLogger.class){
                if(logger == null){
                    logger = new SingletonLogger();
                }
            }
        }
        return logger;
    }

    public void logWithdraw (String account, double amount) {
        writer.println("WITHDRAW (" + account + "): " + amount + "$");
    }

    public void logDeposit (String account, double amount) {
        writer.println("DEPOSIT (" + account + "): " + amount + "$");
    }

    public void logTransfer (String fromAccount, String toAccount, double amount) {
        writer.println("TRANSFER (" + fromAccount + "->" + toAccount + "): " + amount + "$");
    }
}
