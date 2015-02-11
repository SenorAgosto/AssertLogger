package net.breakingrobots.unit_testing;

import net.breakingrobots.unit_testing.AssertLogger.AssertingLoggerFactory;
import net.breakingrobots.unit_testing.AssertLogger.AssertingLogger;
import net.breakingrobots.unit_testing.AssertLogger.NullLogger;

import org.slf4j.Logger;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AssertingLoggerFactoryTest {

    @Test
    public void verifyInstantiationOfAssertingLoggerFactory() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
    }

    @Test
    public void verifyCanGetLoggerFromFactory() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
        final Logger logger = factory.getLogger("Test");

        Assert.assertTrue(logger != null);
    }

    @Test
    public void verifyCanGetLoggerFromFactoryWhenIgnoreDoesntMatch() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
        factory.ignore("net.breakingrobots.test.*");

        final Logger logger = factory.getLogger("Test");
        Assert.assertTrue(logger instanceof AssertingLogger);
    }

    @Test
    public void verifyWeGetNullLoggerWhenNameIsIgnored() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
        factory.ignore("Test");

        final Logger logger = factory.getLogger("Test");
        Assert.assertTrue(logger instanceof NullLogger);
    }

    @Test 
    public void verifyWeGetLoggerFromFactoryWhenMultipleIgnoresAndNameDoesntMatch() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
        factory.ignore(AssertingLoggerFactoryTest.class.getName());
        factory.ignore("Test");

        final Logger logger = factory.getLogger("Austin");
        Assert.assertTrue(logger instanceof AssertingLogger);
    }

    @Test 
    public void verifyWeGetNullLoggerFromFactoryWhenMultipleIgnoresAndNameMatches() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
        factory.ignore(AssertingLoggerFactoryTest.class.getName());
        factory.ignore("Test");

        final Logger logger = factory.getLogger(AssertingLoggerFactoryTest.class.getName());
        Assert.assertTrue(logger instanceof NullLogger);
    }
}
