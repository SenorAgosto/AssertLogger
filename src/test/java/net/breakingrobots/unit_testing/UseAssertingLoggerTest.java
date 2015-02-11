package net.breakingrobots.unit_testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.impl.AssertingLogger;
import org.slf4j.impl.AssertingLoggerFactory;
import org.slf4j.impl.Level;
import org.slf4j.impl.NullLogger;
import org.slf4j.impl.StaticLoggerBinder;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class UseAssertingLoggerTest {

    private final Logger logger = LoggerFactory.getLogger(UseAssertingLoggerTest.class);
    
    @Before 
    public void addIgnores() {
        AssertingLoggerFactory factory = (AssertingLoggerFactory) StaticLoggerBinder.getSingleton().getLoggerFactory();
        factory.ignore("org.junit.*");  // ignore all org.junit classes.
        factory.ignore("myclass");

        factory.setLogLevel(Level.ERROR);
    }

    @Test
    public void verifyLoggerFactoryBindingsAreWorking() {
        Assert.assertTrue(logger instanceof AssertingLogger);
    }

    @Test 
    public void verifyLoggerFactoryGivesMeNullImplementationIfMyClassIsIgnored() {
        final Logger logger = LoggerFactory.getLogger(org.junit.Test.class);
        Assert.assertTrue(logger instanceof NullLogger);
    }

    @Test 
    public void verifyLoggerFactorySetsLogLevelCorrectly() {
        boolean failed = false;

        final Logger logger = LoggerFactory.getLogger("testing");

        try {
            logger.debug("This will not assert.");
        }
        catch(AssertionError assertionError) {
            failed = true;
        }

        Assert.assertFalse(failed);

        try {
            logger.error("This will assert.");
        }
        catch(AssertionError assertionError) {
            failed = true;
        }

        Assert.assertTrue(failed);
    }
}