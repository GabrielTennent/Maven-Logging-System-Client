package nz.ac.vuw.swen301.a2.client;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;


public class LogMonitor implements ActionListener {

    private static final String[] LEVELS = {"ALL","TRACE","DEBUG","INFO","WARN","ERROR","FATAL","OFF"};
    private JFrame frame = new JFrame("Server log retriever");
    private JPanel firstPanel = new JPanel();
    private JPanel secondPanel = new JPanel();
    private CreateRandomLogs randomLogGenerator;

    public void setup() throws InterruptedException {
        this.randomLogGenerator = new CreateRandomLogs();
        randomLogGenerator.generateRandomLogs();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.add(firstPanel, BorderLayout.NORTH);
        frame.setTitle("Logs");


        JTable table = new JTable();
        String[][] data = {{}};
        String[] columnNames = {"ID", "Message", "Time", "Thread", "Logger", "Level", "Error Message"};

        //Labels
        JLabel levelText = new JLabel("Min Level");
        levelText.setForeground(Color.BLACK);
        levelText.setFont(new Font("AppleGothic", Font.PLAIN, 15));
        firstPanel.add(levelText);

        //Drop down box to select the level
        JComboBox levelList = new JComboBox(LEVELS);
        levelList.setSelectedIndex(3);
        levelList.addActionListener(this);
        firstPanel.add(levelList);

        //Limit Label
        JLabel limitText = new JLabel("Limit");
        limitText.setFont(new Font("AppleGothic", Font.PLAIN, 15));
        limitText.setForeground(Color.BLACK);
        firstPanel.add(limitText);

        //Limit input setter
        JTextField limitField = new JTextField();
        limitField.setText("100");
        firstPanel.add(limitField);

        //Retrieve logs button
        JButton generateLogs = new JButton("Retrieve logs");
        frame.getContentPane().add(generateLogs);
        frame.setVisible(true);
        firstPanel.add(generateLogs);
        generateLogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });





    }

    public String[][] getData() {

    return null;
    
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main (String[] args) throws InterruptedException {
        LogMonitor l = new LogMonitor();
        l.setup();
    }
}
