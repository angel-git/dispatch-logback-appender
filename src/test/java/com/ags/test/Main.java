package com.ags.test;

import ch.qos.logback.classic.Logger;
import com.ags.logback.DispatchAppenderListener;
import com.ags.logback.LoggerUtils;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * @author angelg
 */
public class Main {

    private ExamplePanel examplePanel;


    private static final String LOGGER_NAME = "eventLogger";
    private static final Logger EVENT_LOGGER = (Logger) LoggerFactory.getLogger(LOGGER_NAME);
    private static final Logger STD_LOGGER = (Logger) LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        new Main().runApplication();
    }

    private void runApplication() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                examplePanel = new ExamplePanel();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(examplePanel);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                LoggerUtils.addListener(LOGGER_NAME, "EVENT", new DispatchAppenderListener() {
                    @Override
                    public void doAppend(String text) {
                        examplePanel.addText(text);
                    }
                });


                STD_LOGGER.warn("std logger");
                EVENT_LOGGER.warn("event logger");

            }
        });

    }



}
