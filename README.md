# AssertLogger 

AssertLogger is a SLF4J logging implementation intended to be used in unit tests. The implementation throws an AssertionError when any logging is done through the SLF4J API by production code. 

The log level which triggers failures is configurable. We can also ignore (not assert) for classes or namespaces matching regular expressions. 

## Changing the Log Level 

To change the log level which triggers failures, e.g. a debug message is okay, but an error should cause a unit test failure. 

    @Before
    public void init() {
        AssertingLoggerFactory factory = (AssertingLoggerFactory) StaticLoggerBinder.getSingleton().getLoggerFactory();

        // any message at ERROR or above 
        // will cause an assert.
        factory.setLogLevel(Level.ERROR);
    }

You can also change the setting directly on the logger. 

    @Before
    public void init() {
        AssertingLogger logger = (AssertingLogger) LoggerFactory.getLogger(Class.class);

        // only assert if the log is a warning or error,
        // debug messages are ignored.
        logger.setLogLevel(Level.WARN);
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

## Dependencies 

These are the versions I've built against. 

- SLF4J 1.7.7
    
