package net.breakingrobots.unit_testing.AssertLogger;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class AssertingLoggerFactory implements ILoggerFactory {

    String regex = "";

    public AssertingLoggerFactory() {
    }

    // Return a logger implementation for this class 'name'.
    public Logger getLogger(String name) {

        // if the name is in the ignore filter, return a null implementation.
        if(!shouldIgnore(name)) {
            return new AssertingLogger();    
        }
        
        return new NullLogger();
    }

    // Adds regex pattern to list of patterns
    public void ignore(String classOrNamespaceRegEx) {
        regex = regex + "|(" + classOrNamespaceRegEx + ")";
    }
    
    // Match the class name against ignore list
    public boolean shouldIgnore(String name) {
        return Pattern.matches(regex, name);
    }
}