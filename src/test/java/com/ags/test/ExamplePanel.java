package com.ags.test;

import javax.swing.*;
import java.awt.*;

/**
 * @author angelg
 */
public class ExamplePanel extends JPanel {

    private JTextArea output;

    public ExamplePanel() {
        setLayout(new BorderLayout());
        output = new JTextArea();
        add(new JScrollPane(output));
    }

    public void addText(String text) {
        output.append(text);
    }


}