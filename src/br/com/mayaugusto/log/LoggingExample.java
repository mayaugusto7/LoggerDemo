package br.com.mayaugusto.log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LoggingExample {

    static Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }

        logger.setLevel(Level.FINE);
        logger.addHandler(new ConsoleHandler());
        logger.addHandler(new MyHandler());
        try {
            Handler fileHandler = new FileHandler("C:\\Users\\mayco\\tmp\\logger.log", 2000, 5);
            fileHandler.setFormatter(new MyFormatter());
            fileHandler.setFilter(new MyFilter());
            logger.addHandler(fileHandler);

            for (int i = 0; i < 1000; i++) {
                logger.log(Level.INFO, "Msg: {0}", i);
            }
            logger.log(Level.CONFIG, "Config data");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
