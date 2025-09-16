package ARISEBANK;

import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History extends JPanel {
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    private JTextArea historyArea;

    public History(JFrame frame) {
        setLayout(null);
        setPreferredSize(new Dimension(600, 400));
        setBackground(new Color(0, 0, 0, 0)); // Remove white background
        
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/q.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);
        
        ImageIcon banklogo = new ImageIcon("src/main/resources/Photos/headerLogo.png"); 
        JLabel logo = new JLabel(banklogo); 
        logo.setBounds(-7, 11, 70, 30);
        backgroundLabel.add(logo);
        
        JLabel date = new JLabel();
        date.setFont(new Font("Arial", Font.BOLD, 9));
        date.setForeground(Color.WHITE);
        date.setBounds(460, 20, 300, 15);
        backgroundLabel.add(date);
        
        String currentDateTime = new SimpleDateFormat("d'th' MMMM, yyyy | h:mm a").format(new Date());
        date.setText(currentDateTime);
        
        JLabel bankTitle = new JLabel("ARISE BANK");
        bankTitle.setFont(new Font("Arial", Font.BOLD, 35));
        bankTitle.setForeground(Color.WHITE);
        bankTitle.setBounds(60, 10, 300, 30);
        backgroundLabel.add(bankTitle);
        
        JLabel taglineTitle = new JLabel("Rise With Us");
        taglineTitle.setFont(new Font("Arial", Font.BOLD, 15));
        taglineTitle.setForeground(Color.WHITE);
        taglineTitle.setBounds(300, 15, 300, 20);
        backgroundLabel.add(taglineTitle);
        
        JLabel messageTitle = new JLabel(ARISE.GreetingMessage());
        messageTitle.setFont(new Font("Arial", Font.BOLD, 12));
        messageTitle.setForeground(Color.WHITE);
        messageTitle.setBounds(460, 6, 300, 15);
        backgroundLabel.add(messageTitle);
        
        JLabel barlineTitle = new JLabel("|");
        barlineTitle.setFont(new Font("Arial", Font.PLAIN, 35));
        barlineTitle.setForeground(Color.WHITE);
        barlineTitle.setBounds(285, 0, 300, 45);
        backgroundLabel.add(barlineTitle);
        JButton Menu = new JButton("MENU");
        Menu.setFont(new Font("Arial", Font.BOLD, 12));
        Menu.setBackground(new Color(45,37,76));
        Menu.setForeground(Color.WHITE);
        Menu.setBounds(10, 360, 90, 30);
        Menu.setOpaque(true);
        Menu.setFocusPainted(false);
        Menu.setContentAreaFilled(true);
        Menu.setBorderPainted(true);
        Menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.setBackground(Color.YELLOW);
                Menu.setForeground(new Color(45, 37, 76));
                Menu.setFocusPainted(false);
                Menu.setBorderPainted(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Menu.setForeground(Color.WHITE);
                Menu.setBackground(new Color(45,37,76));
                Menu.setBorderPainted(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Menu.setForeground(Color.YELLOW);
                Menu.setBackground(new Color(45,37,76));
                Menu.setFocusPainted(false);
                Menu.setBorderPainted(false);
            }
        });
        backgroundLabel.add(Menu);

        Menu.addActionListener(_ -> {
            int response = JOptionPane.showConfirmDialog(this,
                    "Do you want to go back to the menu ? ",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
    
            if (response == JOptionPane.YES_OPTION) {
                frame.setContentPane(new ARISEmenu(frame));
                frame.validate(); 
            } else {
                return;
            }
        });

            JButton EXIT = new JButton("EXIT");
            EXIT.setFont(new Font("Arial", Font.BOLD, 12));
            EXIT.setBackground(new Color(45,37,76));
            EXIT.setForeground(Color.red);
            EXIT.setBounds(500, 360, 90, 30);
            EXIT.setOpaque(true);
            EXIT.setFocusPainted(false);
            EXIT.setContentAreaFilled(true);
            EXIT.setBorderPainted(true);
            EXIT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    EXIT.setBackground(Color.red);
                    EXIT.setForeground(new Color(45,37,76));
                    EXIT.setFocusPainted(false);
                    EXIT.setBorderPainted(false);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    EXIT.setForeground(Color.red);
                    EXIT.setBackground(new Color(45,37,76));
                    EXIT.setBorderPainted(true);
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    EXIT.setForeground(Color.RED);
                    EXIT.setBackground(Color.WHITE);
                    EXIT.setFocusPainted(false);
                    EXIT.setBorderPainted(false);
                }
            });
            backgroundLabel.add(EXIT);

            EXIT.addActionListener(_ -> {
                int response = JOptionPane.showConfirmDialog(this,
                        "Do you want to exit ? ",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
        
                if (response == JOptionPane.YES_OPTION) {
                    frame.setContentPane(new ARISEexit(frame));
                    frame.validate();
                } else {
                    return;
                }
            });
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Arial", Font.BOLD, 14));
        historyArea.setForeground(Color.WHITE);
        historyArea.setOpaque(false);
        historyArea.setLineWrap(true);
        historyArea.setWrapStyleWord(true);
        historyArea.setBorder(BorderFactory.createEmptyBorder());
        historyArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        historyArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        JScrollPane scrollPane = new JScrollPane(historyArea);
        scrollPane.setBounds(100, 100, 400, 200);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        backgroundLabel.add(scrollPane);
        
        updateHistory();

        
    }

    public static void addTransaction(String transactionType, float amount, float balance, String atmId, long transactionNo) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        String transaction = "----------------------------------------\n" +
                             "DATE: " + formattedDateTime + "\n" +
                             "ID: " + atmId + "\n" +
                             "----------------------------------------\n" +
                             "TYPE: " + transactionType + "\n" +
                             "AMOUNT: ₱ " + String.format("%.2f", amount) + "\n" +
                             "Trans No: " + transactionNo + "\n" +
                             "----------------------------------------\n" +
                             "BALANCE: ₱" + String.format("%.2f", balance) + "\n" +
                             "----------------------------------------\n";
        transactionHistory.add(transaction);
    }

    public void updateHistory() {
        historyArea.setText("");
        for (String record : transactionHistory) {
            historyArea.append(record + "\n");
        }
    }
}