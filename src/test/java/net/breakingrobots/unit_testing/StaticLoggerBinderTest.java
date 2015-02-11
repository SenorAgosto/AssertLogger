package net.breakingrobots.unit_testing;

import org.slf4j.impl.StaticLoggerBinder;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StaticLoggerBinderTest {

    @Test
    public void verifyInstantiationOfStaticLoggerBinder() {
        final StaticLoggerBinder binder = StaticLoggerBinder.getSingleton();
    }
}
