package com.singletonlogger;

public class Main {

    public static void main(String[] args) {
	    GenericLogger gLogger1 = new GenericLogger();
        GenericLogger gLogger2 = new GenericLogger();
        GenericLogger gLogger3 = new GenericLogger();

        // File writing is an exclusive serialized operation and cannot be used in multi-threaded fashion
        gLogger1.logDeposit("0001", 80.5);
        gLogger2.logWithdraw("0002", 100);
        gLogger1.logTransfer("0001", "0003", 40);
        gLogger3.logDeposit("0004", 56.74);
        gLogger2.logWithdraw("0005", 30);

        System.out.format("gLogger1 == gLogger2 = %b\ngLogger1 (Hashcode) = %h\ngLogger2 (Hashcode) = %h\n\n",gLogger1.equals(gLogger2),gLogger1.hashCode(),gLogger2.hashCode());

        SingletonLogger sLogger1 = SingletonLogger.getInstance();
        SingletonLogger sLogger2 = SingletonLogger.getInstance();
        SingletonLogger sLogger3 = SingletonLogger.getInstance();

        // File writing access is synchronized
        sLogger1.logDeposit("0001", 80.5);
        sLogger2.logWithdraw("0002", 100);
        sLogger1.logTransfer("0001", "0003", 40);
        sLogger3.logDeposit("0004", 56.74);
        sLogger2.logWithdraw("0005", 30);

        System.out.format("sLogger1 == sLogger2 = %b\nsLogger1 (Hashcode) = %h\nsLogger2 (Hashcode) = %h\n",sLogger1.equals(sLogger2),sLogger1.hashCode(),sLogger2.hashCode());
    }
}
