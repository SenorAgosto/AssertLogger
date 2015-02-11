# AssertLogger 

AssertLogger is a SLF4J logging implementation that makes a Junit Assert.fail() when any logging is done through the SLF4J API. 

The log level which triggers failures is configurable. We can also ignore some class's logging based on namespace or class name. 

## Changing the Log Level 

To change the log level which triggers failures, e.g. a debug message is okay, but an error should cause a unit test failure. 

    @Before
    public void init() {
        AsertingLoggerFactory factory = (AssertingLoggerFactory) StaticLoggerBinder.getSingleton().getLoggerFactory();

        // any message at ERROR or above (FATAL) will cause an assert.
        factory.setLogLevel(Level.ERROR);
    }

## Adding Ignored Classes and Namespaces

To prevent logging from a particular class or namespace from triggering an unit test failures, add them to the ignore list - regular expressions are supported.

    @Before 
    public void init() {
        AssertingLoggerFactory factory = (AssertingLoggerFactory) StaticLoggerBinder.getSingleton().getLoggerFactory();

        // ignore all org.junit classes.
        factory.ignore("org.junit.*");

        // ignore just one class.
        factory.ignore("myclass");

        // ignore another class. 
        factory.ignore(MyClass.class.getName());
    }

Any logging from junit classes, or myclass, or MyClass would be ignored. Logging from any other class would trigger an Assert.fail(). 



