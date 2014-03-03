package com.ags.logback;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Appender that calls an DispatchAppenderListener every time there is an event to log.
 * @author angelg
 */
public class DispatchAppender extends AppenderBase<ILoggingEvent> {

    protected PatternLayoutEncoder encoder;
    private DispatchAppenderListener dispatchAppenderListener;

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (encoder == null || encoder.getLayout() == null) {
            addError(String.format("encoder or pattern for '%s' not found", eventObject.getLoggerName()));
            return;
        }

        String text = applyPattern(eventObject);
        if (dispatchAppenderListener != null) {
            dispatchAppenderListener.doAppend(text);
        }
    }

    private String applyPattern(ILoggingEvent eventObject) {
        return encoder.getLayout().doLayout(eventObject);
    }

    /**
     * Adds the listener that will be called every time the logger is triggered.
     * @param dispatchAppenderListener
     */
    public void setDispatchAppenderListener(DispatchAppenderListener dispatchAppenderListener) {
        this.dispatchAppenderListener = dispatchAppenderListener;
    }

    /**
     * Automatically called from Logback core.
     * @param encoder
     */
    public void setEncoder(PatternLayoutEncoder encoder) {
        this.encoder = encoder;
    }
}
