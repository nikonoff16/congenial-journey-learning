package javalearn.fundamentals.learnlogs;

import java.util.logging.*;

public class LogDemo {
    private final static Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public LogDemo() {
        LOGGER.log(Level.INFO, "I'm in class!");
        LOGGER.setLevel(Level.WARNING);

        LOGGER.log(Level.INFO, "It should not be shown.");
        LOGGER.log(Level.SEVERE, "ALL IS GONE!!!.");
    }

    public void getMessage() {
        LOGGER.setLevel(Level.FINE);
        LOGGER.log(Level.INFO, "I'm in the method");
    }
}
