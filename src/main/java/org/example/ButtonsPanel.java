package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel implements ActionListener {
    private SandSimulator simulator;
    private JButton startButton;
    private JButton stopButton;
    private JButton clearButton;

    public ButtonsPanel(SandSimulator simulator) {
        this.simulator = simulator;

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(160,828));

        stopButton = new JButton("Stop simulation");
        startButton = new JButton("Start simulation");
        clearButton = new JButton("Clear the canva");

        stopButton.addActionListener(this);
        startButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(stopButton);
        add(startButton);
        add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == stopButton) simulator.stop();
        else if (source == startButton) simulator.start();
        else if (source == clearButton) simulator.restart();
    }
}
