package loggingexample;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
 
public class Programmatic {
 
    public static void main(String[] args) {
        PatternLayout layout = new PatternLayout();
      //  String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
      //  layout.setConversionPattern(conversionPattern);
 
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();
 
        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile("applog3.txt");
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();
 
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        rootLogger.addAppender(consoleAppender);
        rootLogger.addAppender(fileAppender);
 
        Logger logger = Logger.getLogger(Programmatic.class);
        System.out.println("Programmatic-confg");
        logger.debug("this is a debug log message");
        logger.info("this is a information log message");
        logger.warn("this is a warning log message");
    }
}
