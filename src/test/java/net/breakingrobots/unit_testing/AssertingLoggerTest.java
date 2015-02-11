package net.breakingrobots.unit_testing;

import org.slf4j.impl.AssertingLogger;
import org.slf4j.impl.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarker;

import org.junit.Test;
import org.junit.Assert;

public class AssertingLoggerTest {

    @Test
    public void verifyInstantiationOfAssertingLogger() {
        final AssertingLogger logger = new AssertingLogger();
    }

    @Test 
    public void verifyIsTraceEnabled() {

        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.TRACE);

        Assert.assertTrue(logger.isTraceEnabled(null));
        Assert.assertTrue(logger.isTraceEnabled());
    }

    @Test 
    public void verifyIsTraceEnabledWhenLogLevelIsLower() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.ALL);

        Assert.assertTrue(logger.isTraceEnabled());
        Assert.assertTrue(logger.isTraceEnabled(null));
    }

    @Test 
    public void verifyIsTraceEnabledIsFalseWhenLogLevelIsHigher() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.ERROR);

        Assert.assertFalse(logger.isTraceEnabled());
        Assert.assertFalse(logger.isTraceEnabled(null));
    }

    @Test 
    public void verifyIsDebugEnabled() {

        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.DEBUG);

        Assert.assertTrue(logger.isDebugEnabled(null));
        Assert.assertTrue(logger.isDebugEnabled());
    }

    @Test 
    public void verifyIsDebugEnabledWhenLogLevelIsLower() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.TRACE);

        Assert.assertTrue(logger.isDebugEnabled());
        Assert.assertTrue(logger.isDebugEnabled(null));
    }

    @Test 
    public void verifyIsDebugEnabledIsFalseWhenLogLevelIsHigher() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.ERROR);

        Assert.assertFalse(logger.isDebugEnabled());
        Assert.assertFalse(logger.isDebugEnabled(null));
    }

    @Test 
    public void verifyIsInfoEnabled() {

        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.INFO);

        Assert.assertTrue(logger.isInfoEnabled(null));
        Assert.assertTrue(logger.isInfoEnabled());
    }

    @Test 
    public void verifyIsInfoEnabledWhenLogLevelIsLower() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.DEBUG);

        Assert.assertTrue(logger.isInfoEnabled());
        Assert.assertTrue(logger.isInfoEnabled(null));
    }

    @Test 
    public void verifyIsInfoEnabledIsFalseWhenLogLevelIsHigher() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.ERROR);

        Assert.assertFalse(logger.isInfoEnabled());
        Assert.assertFalse(logger.isInfoEnabled(null));
    }

    @Test 
    public void verifyIsWarnEnabled() {

        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.WARN);

        Assert.assertTrue(logger.isWarnEnabled(null));
        Assert.assertTrue(logger.isWarnEnabled());
    }

    @Test 
    public void verifyIsWarnEnabledWhenLogLevelIsLower() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.INFO);

        Assert.assertTrue(logger.isWarnEnabled());
        Assert.assertTrue(logger.isWarnEnabled(null));
    }

    @Test 
    public void verifyIsWarnEnabledIsFalseWhenLogLevelIsHigher() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.ERROR);

        Assert.assertFalse(logger.isWarnEnabled());
        Assert.assertFalse(logger.isWarnEnabled(null));
    }

    @Test 
    public void verifyIsErrorEnabled() {

        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.ERROR);

        Assert.assertTrue(logger.isErrorEnabled(null));
        Assert.assertTrue(logger.isErrorEnabled());
    }

    @Test 
    public void verifyIsErrorEnabledWhenLogLevelIsLower() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.INFO);

        Assert.assertTrue(logger.isErrorEnabled());
        Assert.assertTrue(logger.isErrorEnabled(null));
    }

    @Test 
    public void verifyIsErrorEnabledIsFalseWhenLogLevelIsHigher() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.FATAL);

        Assert.assertFalse(logger.isErrorEnabled());
        Assert.assertFalse(logger.isErrorEnabled(null));
    }


    @Test 
    public void verifyEnabledFunctionsWhenLogLevelIsAll() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.ALL);

        Assert.assertTrue(logger.isTraceEnabled());
        Assert.assertTrue(logger.isInfoEnabled());
        Assert.assertTrue(logger.isDebugEnabled());
        Assert.assertTrue(logger.isWarnEnabled());
        Assert.assertTrue(logger.isErrorEnabled());
    }

    @Test 
    public void verifyEnabledFunctionsReturnFalseWhenLoggingIsOff() {
        final AssertingLogger logger = new AssertingLogger();
        logger.setLogLevel(Level.OFF);

        Assert.assertFalse(logger.isTraceEnabled());
        Assert.assertFalse(logger.isInfoEnabled());
        Assert.assertFalse(logger.isDebugEnabled());
        Assert.assertFalse(logger.isWarnEnabled());
        Assert.assertFalse(logger.isErrorEnabled());
    }



    @Test
    public void verifyLoggingDebugDoesntAssertWithHigherLogLevel() {

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.FATAL);

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
        catch(AssertionError assertionError) {
            Assert.fail();
        }
    }

    @Test
    public void verifyDebugAssertsMarkerStringArgument() {

        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug((Marker)null, "This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyDebugAssertsMarkerFormatEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug((Marker)null, "This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }


    @Test 
    public void verifyDebugAssertsMarkerFormatOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug((Marker)null, "This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            

    @Test 
    public void verifyDebugAssertsMarkerFormatTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug((Marker)null, "This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyDebugAssertsMarkerFormatException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug((Marker)null, "This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyDebugAssertsString() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug("This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test 
    public void verifyDebugAssertsStringEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug("This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyDebugAssertsStringOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug("This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }
            
    @Test 
    public void verifyDebugAssertsStringTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug("This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            
        
    @Test
    public void verifyDebugAssertsStringException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.DEBUG);

            logger.debug("This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }



    @Test
    public void verifyLoggingWarnDoesntAssertWithHigherLogLevel() {

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.FATAL);

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
        catch(AssertionError assertionError) {
            Assert.fail();
        }
    }

    @Test
    public void verifyWarnAssertsMarkerStringArgument() {

        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn((Marker)null, "This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyWarnAssertsMarkerFormatEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn((Marker)null, "This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }


    @Test 
    public void verifyWarnAssertsMarkerFormatOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn((Marker)null, "This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            

    @Test 
    public void verifyWarnAssertsMarkerFormatTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn((Marker)null, "This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyWarnAssertsMarkerFormatException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn((Marker)null, "This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyWarnAssertsString() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn("This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test 
    public void verifyWarnAssertsStringEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn("This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyWarnAssertsStringOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn("This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }
            
    @Test 
    public void verifyWarnAssertsStringTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn("This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            
        
    @Test
    public void verifyWarnAssertsStringException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.WARN);

            logger.warn("This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }



    @Test
    public void verifyLoggingInfoDoesntAssertWithHigherLogLevel() {

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.FATAL);

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
        catch(AssertionError assertionError) {
            Assert.fail();
        }
    }

    @Test
    public void verifyInfoAssertsMarkerStringArgument() {

        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info((Marker)null, "This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyInfoAssertsMarkerFormatEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info((Marker)null, "This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }


    @Test 
    public void verifyInfoAssertsMarkerFormatOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info((Marker)null, "This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            

    @Test 
    public void verifyInfoAssertsMarkerFormatTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info((Marker)null, "This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyInfoAssertsMarkerFormatException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info((Marker)null, "This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyInfoAssertsString() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info("This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test 
    public void verifyInfoAssertsStringEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info("This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyInfoAssertsStringOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info("This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }
            
    @Test 
    public void verifyInfoAssertsStringTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info("This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            
        
    @Test
    public void verifyInfoAssertsStringException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.INFO);

            logger.info("This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }



    @Test
    public void verifyLoggingTraceDoesntAssertWithHigherLogLevel() {

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.FATAL);

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
        catch(AssertionError assertionError) {
            Assert.fail();
        }
    }

    @Test
    public void verifyTraceAssertsMarkerStringArgument() {

        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace((Marker)null, "This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyTraceAssertsMarkerFormatEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace((Marker)null, "This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }


    @Test 
    public void verifyTraceAssertsMarkerFormatOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace((Marker)null, "This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            

    @Test 
    public void verifyTraceAssertsMarkerFormatTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace((Marker)null, "This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyTraceAssertsMarkerFormatException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace((Marker)null, "This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyTraceAssertsString() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace("This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test 
    public void verifyTraceAssertsStringEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace("This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyTraceAssertsStringOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace("This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }
            
    @Test 
    public void verifyTraceAssertsStringTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace("This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            
        
    @Test
    public void verifyTraceAssertsStringException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.TRACE);

            logger.trace("This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }



    @Test
    public void verifyLoggingErrorDoesntAssertWithHigherLogLevel() {

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.FATAL);

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
        catch(AssertionError assertionError) {
            Assert.fail();
        }
    }

    @Test
    public void verifyErrorAssertsMarkerStringArgument() {

        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error((Marker)null, "This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyErrorAssertsMarkerFormatEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error((Marker)null, "This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }


    @Test 
    public void verifyErrorAssertsMarkerFormatOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error((Marker)null, "This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            

    @Test 
    public void verifyErrorAssertsMarkerFormatTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error((Marker)null, "This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyErrorAssertsMarkerFormatException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error((Marker)null, "This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyErrorAssertsString() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error("This will fail.");
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test 
    public void verifyErrorAssertsStringEllipseArguments() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error("This will fail.", new Long(1), new Long(12), new Float(12.0), new Long(13));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

    @Test
    public void verifyErrorAssertsStringOneObject() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error("This will fail.", new Long(1));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }
            
    @Test 
    public void verifyErrorAssertsStringTwoObjects() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error("This will fail.", new Long(1), new Long(2));
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }            
        
    @Test
    public void verifyErrorAssertsStringException() {
        boolean failed = false;

        try {
            final AssertingLogger logger = new AssertingLogger();
            logger.setLogLevel(Level.ERROR);

            logger.error("This will fail.", new RuntimeException());
        }
        catch(AssertionError assertionError) {
            // this is the happy path.
            failed = true;
        }

        Assert.assertTrue(failed);
    }

}
