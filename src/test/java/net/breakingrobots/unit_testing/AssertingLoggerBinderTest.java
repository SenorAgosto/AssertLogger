package net.breakingrobots.unit_testing;

import net.breakingrobots.unit_testing.AssertLogger.AssertingLoggerBinder;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AssertingLoggerBinderTest {

    @Test
    public void verifyInstantiationOfAssertingLoggerBinder() {
        final AssertingLoggerBinder binder = AssertingLoggerBinder.getSingleton();
    }
}
