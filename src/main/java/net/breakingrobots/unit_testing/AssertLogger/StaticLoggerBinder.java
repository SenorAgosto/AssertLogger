package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
    private static final String loggerFactoryClassString = StaticLoggerBinder.class.getName();
    private final ILoggerFactory loggerFactory;

    public static String REQUESTED_API_VERSION = "1.7";

    public static final StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    private StaticLoggerBinder() {
        loggerFactory = new AssertingLoggerFactory();
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    @Override 
    public String getLoggerFactoryClassStr() {
        return loggerFactoryClassString;
    }
} 