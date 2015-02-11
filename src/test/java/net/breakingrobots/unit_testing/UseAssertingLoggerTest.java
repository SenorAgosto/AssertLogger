package net.breakingrobots.unit_testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.impl.AssertingLogger;
import org.slf4j.impl.AssertingLoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.slf4j.impl.NullLogger;

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
}