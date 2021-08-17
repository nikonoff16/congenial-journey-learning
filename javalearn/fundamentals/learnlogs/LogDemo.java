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

        /*
        Why it's not working for a while...
        TODO: I shall find solution of this behaviour.
        */
        String strangeNumber = "#32453235";
        LOGGER.log(Level.INFO, "I'm in the method number {0}", strangeNumber);
    }
}
