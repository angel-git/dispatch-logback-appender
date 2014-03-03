package com.ags.logback;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import org.slf4j.LoggerFactory;

/**
 * @author angelg
 */
public class LoggerUtils {


    /**
     * Adds the listener into DispatchAppender defined by the input parameters.
     * @param loggerName
     * @param appenderName
     * @param appenderListener
     */
    public static void addListener(String loggerName, String appenderName, DispatchAppenderListener appenderListener) {
        Appender<ILoggingEvent> appender = ((Logger)LoggerFactory.getLogger(loggerName)).getAppender(appenderName);
        if (appender instanceof DispatchAppender) {
            ((DispatchAppender) appender).setDispatchAppenderListener(appenderListener);
        }
    }

}
