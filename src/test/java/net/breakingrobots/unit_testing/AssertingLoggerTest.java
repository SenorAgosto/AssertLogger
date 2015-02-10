package net.breakingrobots.unit_testing;

import net.breakingrobots.unit_testing.AssertLogger.AssertingLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AssertingLoggerTest {

    @Test
    public void verifyInstantiationOfAssertingAppender() {
        final AssertingLogger logger = new AssertingLogger();
    }
}
