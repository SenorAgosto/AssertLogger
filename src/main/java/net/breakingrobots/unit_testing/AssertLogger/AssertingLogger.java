package net.breakingrobots.unit_testing.AssertLogger;

import org.slf4j.Logger;
import org.slf4j.Marker;

import org.junit.Assert;

public class AssertingLogger implements Logger { 

    private int logLevel = Level.WARN;

    // set the log level...
    public void setLogLevel(int level) {
        this.logLevel = level;
    }

    public void debug(Marker marker, String msg) {
        fail(this, Level.DEBUG);
    }

    public void debug(Marker marker, String format, Object... arguments) {
        fail(this, Level.DEBUG);
    }

    public void debug(Marker marker, String format, Object arg) {
        fail(this, Level.DEBUG);
    }

    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        fail(this, Level.DEBUG);
    }

    public void debug(Marker marker, String msg, Throwable t) {
        fail(this, Level.DEBUG);
    }

    public void debug(String msg) {
        fail(this, Level.DEBUG);
    }

    public void debug(String format, Object... arguments) {
        fail(this, Level.DEBUG);
    }

    public void debug(String format, Object arg) {
        fail(this, Level.DEBUG);
    }

    public void debug(String format, Object arg1, Object arg2) {
        fail(this, Level.DEBUG);
    }

    public void debug(String msg, Throwable t) {
        fail(this, Level.DEBUG);
    }

    public void error(Marker marker, String msg) {
        fail(this, Level.ERROR);
    }

    public void error(Marker marker, String format, Object... arguments) {
        fail(this, Level.ERROR);
    }

    public void error(Marker marker, String format, Object arg) {
        fail(this, Level.ERROR);
    }

    public void error(Marker marker, String format, Object arg1, Object arg2) {
        fail(this, Level.ERROR);
    }

    public void error(Marker marker, String msg, Throwable t) {
        fail(this, Level.ERROR);
    }

    public void error(String msg) {
        fail(this, Level.ERROR);
    }

    public void error(String format, Object... arguments) {
        fail(this, Level.ERROR);
    }

    public void error(String format, Object arg) {
        fail(this, Level.ERROR);
    }

    public void error(String format, Object arg1, Object arg2) {
        fail(this, Level.ERROR);
    }

    public void error(String msg, Throwable t) {
        fail(this, Level.ERROR);
    }

    public String getName() {
        return "AssertingLogger";
    }

    public void info(Marker marker, String msg) {
        fail(this, Level.INFO);
    }

    public void info(Marker marker, String format, Object... arguments) {
        fail(this, Level.INFO);
    }

    public void info(Marker marker, String format, Object arg) {
        fail(this, Level.INFO);
    }

    public void info(Marker marker, String format, Object arg1, Object arg2) {
        fail(this, Level.INFO);
    }

    public void info(Marker marker, String msg, Throwable t) {
        fail(this, Level.INFO);
    }

    public void info(String msg) {
        fail(this, Level.INFO);
    }

    public void info(String format, Object... arguments) {
        fail(this, Level.INFO);
    }

    public void info(String format, Object arg) {
        fail(this, Level.INFO);
    }

    public void info(String format, Object arg1, Object arg2) {
        fail(this, Level.INFO);
    }

    public void info(String msg, Throwable t) {
        fail(this, Level.INFO);
    }

    public boolean isDebugEnabled() {
        return this.logLevel == Level.DEBUG;
    }

    public boolean isDebugEnabled(Marker marker) {
        return this.logLevel == Level.DEBUG;
    }

    public boolean isErrorEnabled() {
        return this.logLevel == Level.ERROR;
    }

    public boolean isErrorEnabled(Marker marker) {
        return this.logLevel == Level.ERROR;
    }

    public boolean isInfoEnabled() {
        return this.logLevel == Level.INFO;
    }

    public boolean isInfoEnabled(Marker marker) {
        return this.logLevel == Level.INFO;
    }

    public boolean isTraceEnabled() {
        return this.logLevel == Level.TRACE;
    }

    public boolean isTraceEnabled(Marker marker) {
        return this.logLevel == Level.TRACE;
    }

    public boolean isWarnEnabled() {
        return this.logLevel == Level.WARN;
    }

    public boolean isWarnEnabled(Marker marker) {
        return this.logLevel == Level.WARN;   
    }

    public void trace(Marker marker, String msg) {
        fail(this, Level.TRACE);
    }

    public void trace(Marker marker, String format, Object... argArray) {
        fail(this, Level.TRACE);
    }

    public void trace(Marker marker, String format, Object arg) {
        fail(this, Level.TRACE);
    }

    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        fail(this, Level.TRACE);
    }

    public void trace(Marker marker, String msg, Throwable t) {
        fail(this, Level.TRACE);
    }

    public void trace(String msg) {
        fail(this, Level.TRACE);
    }

    public void trace(String format, Object... arguments) {
        fail(this, Level.TRACE);
    }

    public void trace(String format, Object arg) {
        fail(this, Level.TRACE);
    }

    public void trace(String format, Object arg1, Object arg2) {
        fail(this, Level.TRACE);
    }

    public void trace(String msg, Throwable t) {
        fail(this, Level.TRACE);
    }

    public void warn(Marker marker, String msg) {
        fail(this, Level.WARN);
    }

    public void warn(Marker marker, String format, Object... arguments) {
        fail(this, Level.WARN);
    }

    public void warn(Marker marker, String format, Object arg) {
        fail(this, Level.WARN);
    }

    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        fail(this, Level.WARN);
    }

    public void warn(Marker marker, String msg, Throwable t) {
        fail(this, Level.WARN);
    }

    public void warn(String msg) {
        fail(this, Level.WARN);
    }

    public void warn(String format, Object... arguments) {
        fail(this, Level.WARN);
    }

    public void warn(String format, Object arg) {
        fail(this, Level.WARN);
    }

    public void warn(String format, Object arg1, Object arg2) {
        fail(this, Level.WARN);
    }

    public void warn(String msg, Throwable t) {
        fail(this, Level.WARN);
    }

    // print the stack if the logging event is high enough.
    private static void fail(AssertingLogger logger, int level) {
        if(logger.logLevel <= level) {
            Assert.fail();
        }
    }
}
