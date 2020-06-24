package nz.ac.vuw.swen301.a2.client;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;


public class LogMonitor implements ActionListener {

    private static final String[] LEVELS = {"ALL","TRACE","DEBUG","INFO","WARN","ERROR","FATAL","OFF"};
    private JPanel northPanel = new JPanel();
    private JFrame frame = new JFrame();
    private JPanel southPanel = new JPanel();

    public void setup(){

    }

    public void display() {

    
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main (String[] args) throws InterruptedException {
        LogMonitor l = new LogMonitor();
        CreateRandomLogs randomLogGenerator = new CreateRandomLogs();
        randomLogGenerator.generateRandomLogs();
        l.setup();

    }
}
