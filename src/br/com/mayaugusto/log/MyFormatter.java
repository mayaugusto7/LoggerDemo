package br.com.mayaugusto.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord logRecord) {
        return logRecord.getLongThreadID() + "::" + logRecord.getSourceClassName() + "::"
                + logRecord.getSourceMethodName() + "::" + new Date(logRecord.getMillis()) + "::"
                + logRecord.getMessage() + "\n";
    }

}
