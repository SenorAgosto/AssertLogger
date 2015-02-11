package org.slf4j.impl;

import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class AssertingLoggerFactory implements ILoggerFactory {

    AtomicReference<String> concurrentRegex = new AtomicReference<String>("");

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
        boolean success = false;

        while(!success) {
            String regex = concurrentRegex.get();
            String newRegex = regex + "|(" + classOrNamespaceRegEx + ")";

            success = concurrentRegex.compareAndSet(regex, newRegex);
        }
    }
    
    // Match the class name against ignore list
    public boolean shouldIgnore(String name) {
        return Pattern.matches(concurrentRegex.get(), name);
    }
}