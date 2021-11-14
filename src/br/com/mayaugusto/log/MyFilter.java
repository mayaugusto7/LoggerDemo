package br.com.mayaugusto.log;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MyFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return logRecord.getLevel() != Level.CONFIG;
    }
}
