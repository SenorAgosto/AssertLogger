package net.breakingrobots.unit_testing;

import org.slf4j.impl.AssertingLoggerFactory;
import org.slf4j.impl.AssertingLogger;
import org.slf4j.impl.Level;
import org.slf4j.impl.NullLogger;

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
    public void verifyFluentInterfaceForAddingIgnoredClasses() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
        factory.ignore("test").ignore("test2").ignore("test3");

        final Logger l1 = factory.getLogger("test");
        Assert.assertTrue(l1 instanceof NullLogger);

        final Logger l2 = factory.getLogger("test2");
        Assert.assertTrue(l2 instanceof NullLogger);

        final Logger l3 = factory.getLogger("test3");
        Assert.assertTrue(l3 instanceof NullLogger);
    }

    @Test
    public void verifyFluentInterfaceForSettingLogLevel() {
        final AssertingLoggerFactory factory = new AssertingLoggerFactory();
        factory.ignore("test").setLogLevel(Level.WARN).ignore("test2");

        final Logger l1 = factory.getLogger("test");
        Assert.assertTrue(l1 instanceof NullLogger);

        final Logger l2 = factory.getLogger("test2");
        Assert.assertTrue(l2 instanceof NullLogger);

        final Logger l3 = factory.getLogger("test3");
        Assert.assertTrue(l3 instanceof AssertingLogger);

        l3.debug("This will not assert");

        boolean failed = false;
        try {
            l3.error("This will assert.");
        }
        catch(AssertionError assertionError) {
            failed = true;
        }

        Assert.assertTrue(failed);
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
