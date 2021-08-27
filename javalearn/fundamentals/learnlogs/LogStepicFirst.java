package javalearn.fundamentals.learnlogs;

import java.util.logging.*;

public class LogStepicFirst {
    private static void configureLogging() {
        final Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);
        
        final Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB" );
        loggerB.setLevel(Level.WARNING);
        
        final Logger loggerC = Logger.getLogger("org.stepic.java");
        loggerC.setLevel(Level.ALL);
        loggerC.setUseParentHandlers(false);
        
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        loggerC.addHandler(consoleHandler);
        
        XMLFormatter xmlFormatter = new XMLFormatter();
            consoleHandler.setFormatter(xmlFormatter);
    }
    
}
