package javalearn.fundamentals.learnlogs;

import java.util.logging.*;

public class LogDemoTest {
    private final static Logger LOGGER = Logger.getLogger(LogDemoTest.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.WARNING, "Program is running.");
        
        var test = new LogDemo();

        test.getMessage();
    }
}
