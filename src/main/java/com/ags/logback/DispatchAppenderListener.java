package com.ags.logback;

/**
 *
 * @author angelg
 */
public interface DispatchAppenderListener {

    /**
     * Method called whenever there is something to log.
     * @param text
     */
    public void doAppend(String text);
}
