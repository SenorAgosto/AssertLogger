package net.breakingrobots.unit_testing;

import org.slf4j.impl.NullLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import org.junit.Test;
import org.junit.Assert;

public class NullLoggerTest {

    @Test
    public void verifyInstantiationOfNullLogger() {
        final NullLogger logger = new NullLogger();
        final Logger logger2 = new NullLogger();
    }

    @Test 
    public void verifyIsEnabledAreFalse() {

        final NullLogger logger = new NullLogger();

        Assert.assertFalse(logger.isInfoEnabled(null));
        Assert.assertFalse(logger.isInfoEnabled());
        Assert.assertFalse(logger.isTraceEnabled(null));
        Assert.assertFalse(logger.isTraceEnabled());
        Assert.assertFalse(logger.isDebugEnabled(null));
        Assert.assertFalse(logger.isDebugEnabled());
        Assert.assertFalse(logger.isWarnEnabled(null));
        Assert.assertFalse(logger.isWarnEnabled());
        Assert.assertFalse(logger.isErrorEnabled(null));
        Assert.assertFalse(logger.isErrorEnabled());
    }

    @Test
    public void verifyLoggingDebugDoesntAssert() {

        final NullLogger logger = new NullLogger();

        logger.debug((Marker)null, "This will succeed.");
        logger.debug((Marker)null, "This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.debug((Marker)null, "This will succeed.", new Long(1));
        logger.debug((Marker)null, "This will succeed.", new Long(1), new Long(2));
        logger.debug((Marker)null, "This will succeed.", new RuntimeException());

        logger.debug("This will succeed.");
        logger.debug("This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.debug("This will succeed.", new Long(1));
        logger.debug("This will succeed.", new Long(1), new Long(2));
        logger.debug("This will succeed.", new RuntimeException());
    }

    @Test
    public void verifyLoggingInfoDoesntAssert() {

        final NullLogger logger = new NullLogger();

        logger.info((Marker)null, "This will succeed.");
        logger.info((Marker)null, "This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.info((Marker)null, "This will succeed.", new Long(1));
        logger.info((Marker)null, "This will succeed.", new Long(1), new Long(2));
        logger.info((Marker)null, "This will succeed.", new RuntimeException());

        logger.info("This will succeed.");
        logger.info("This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.info("This will succeed.", new Long(1));
        logger.info("This will succeed.", new Long(1), new Long(2));
        logger.info("This will succeed.", new RuntimeException());
    }

    @Test
    public void verifyLoggingTraceDoesntAssert() {

        final NullLogger logger = new NullLogger();

        logger.trace((Marker)null, "This will succeed.");
        logger.trace((Marker)null, "This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.trace((Marker)null, "This will succeed.", new Long(1));
        logger.trace((Marker)null, "This will succeed.", new Long(1), new Long(2));
        logger.trace((Marker)null, "This will succeed.", new RuntimeException());

        logger.trace("This will succeed.");
        logger.trace("This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.trace("This will succeed.", new Long(1));
        logger.trace("This will succeed.", new Long(1), new Long(2));
        logger.trace("This will succeed.", new RuntimeException());
    }

    @Test
    public void verifyLoggingWarnDoesntAssert() {

        final NullLogger logger = new NullLogger();

        logger.warn((Marker)null, "This will succeed.");
        logger.warn((Marker)null, "This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.warn((Marker)null, "This will succeed.", new Long(1));
        logger.warn((Marker)null, "This will succeed.", new Long(1), new Long(2));
        logger.warn((Marker)null, "This will succeed.", new RuntimeException());

        logger.warn("This will succeed.");
        logger.warn("This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.warn("This will succeed.", new Long(1));
        logger.warn("This will succeed.", new Long(1), new Long(2));
        logger.warn("This will succeed.", new RuntimeException());
    }

    @Test
    public void verifyLoggingErrorDoesntAssert() {

        final NullLogger logger = new NullLogger();

        logger.error((Marker)null, "This will succeed.");
        logger.error((Marker)null, "This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.error((Marker)null, "This will succeed.", new Long(1));
        logger.error((Marker)null, "This will succeed.", new Long(1), new Long(2));
        logger.error((Marker)null, "This will succeed.", new RuntimeException());

        logger.error("This will succeed.");
        logger.error("This will succeed.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        logger.error("This will succeed.", new Long(1));
        logger.error("This will succeed.", new Long(1), new Long(2));
        logger.error("This will succeed.", new RuntimeException());
    }
}
