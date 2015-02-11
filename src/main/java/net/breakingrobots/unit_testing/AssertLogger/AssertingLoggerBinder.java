package net.breakingrobots.unit_testing.AssertLogger;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class AssertingLoggerBinder implements LoggerFactoryBinder {

    private static final AssertingLoggerBinder SINGLETON = new AssertingLoggerBinder();
    private static final String loggerFactoryClassString = AssertingLoggerBinder.class.getName();
    private final ILoggerFactory loggerFactory;

    public static String REQUESTED_API_VERSION = "1.7";

    public static final AssertingLoggerBinder getSingleton() {
        return SINGLETON;
    }

    private AssertingLoggerBinder() {
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