package ARISEBANK;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class CheckBalance extends JPanel {
    private JButton currentButton;
    private JButton savingsButton;
    private JFrame frame;

    public CheckBalance(JFrame frame) {
        this.frame = frame;
        setLayout(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/saq.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        ImageIcon icon = new ImageIcon("zaq.png");
        JButton logo = new JButton(icon);
        logo.setFont(new Font("Arial", Font.PLAIN, 12));
        logo.setBackground(new Color(45,37,76));
        logo.setForeground(Color.WHITE);
        logo.setBounds(-7, 11, 70, 30);
        logo.setOpaque(false);
        logo.setFocusPainted(false);
        logo.setContentAreaFilled(false);
        logo.setBorderPainted(false);
        backgroundLabel.add(logo);

        JLabel date = new JLabel();
        date.setFont(new Font("Arial", Font.BOLD, 9));
        date.setForeground(Color.WHITE);
        date.setBounds(460, 20, 300, 15);
        backgroundLabel.add(date);

        String currentDateTime = new SimpleDateFormat("d'th' MMMM, yyyy | h:mm a").format(new Date());
        date.setText(currentDateTime);

        JLabel welcomeLabel = new JLabel("ARISE BANK");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 35));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(60, 10, 300, 30);
        backgroundLabel.add(welcomeLabel);

        JLabel wc = new JLabel("CHECK BALANCE");
        wc.setFont(new Font("Arial", Font.BOLD, 12));
        wc.setForeground(Color.WHITE);
        wc.setBounds(470, 6, 300, 15);
        backgroundLabel.add(wc);

        currentButton = createButton("CURRENT", 80, 290, 130, _ -> showBalance("Current"));
        backgroundLabel.add(currentButton);

        savingsButton = createButton("SAVINGS", 383, 290, 130, _ -> showBalance("Savings"));
        backgroundLabel.add(savingsButton);

        
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
            frame.setContentPane(new ARISEmenu(frame));
            frame.validate(); 
        });

        JButton EXIT = new JButton("EXIT");
        EXIT.setFont(new Font("Arial", Font.BOLD, 12));
        EXIT.setBackground(new Color(45,37,76));
        EXIT.setForeground(Color.WHITE);
        EXIT.setBounds(500, 360, 90, 30);
        EXIT.setOpaque(true);
        EXIT.setFocusPainted(false);
        EXIT.setContentAreaFilled(true);
        EXIT.setBorderPainted(true);
        EXIT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EXIT.setBackground(Color.red);
                EXIT.setForeground(Color.WHITE);
                EXIT.setFocusPainted(false);
                EXIT.setBorderPainted(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                EXIT.setForeground(Color.WHITE);
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
            frame.setContentPane(new ARISElogin(frame));
            frame.validate(); 
        });
    }

    private JButton createButton(String text, int x, int y, int w, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBounds(x, y, w, 30);
        button.setBackground(new Color(45, 37, 76));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.addActionListener(action);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.YELLOW);
                button.setForeground(new Color(45, 37, 76));
                button.setFocusPainted(false);
                button.setBorderPainted(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE);
                button.setBackground(new Color(45, 37, 76));
                button.setBorderPainted(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                button.setForeground(Color.YELLOW);
                button.setBackground(new Color(45, 37, 76));
                button.setFocusPainted(false);
                button.setBorderPainted(false);
            }
        });
        return button;
    }
    private void showBalance(String accountType) {
        String balanceMessage;
        if (accountType.equals("Current")) {
            balanceMessage = "Your Current Balance is: " + ARISE.Currentbalance;
        } else {
            balanceMessage = "Your Savings Balance is: " + ARISE.Savingsbalance;
        }
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
        UIManager.put("OptionPane.messageForeground", Color.WHITE); 
        UIManager.put("OptionPane.background", new Color(45, 37, 76)); 
        UIManager.put("Panel.background", new Color(45, 37, 76)); 
        UIManager.put("Button.background", new Color(255, 215, 0));
        UIManager.put("Button.foreground", new Color(45, 37, 76)); 
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 12)); 
        UIManager.put("Button.focus", Color.TRANSLUCENT);
        ImageIcon icon = new ImageIcon("ARISEBANK/zaq.png"); 
        UIManager.put("OptionPane.informationIcon", icon);
    
        JLabel messageLabel = new JLabel(balanceMessage);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setOpaque(false);
        messageLabel.setBorder(null);

        JOptionPane.showMessageDialog(frame, messageLabel, accountType + " Balance", JOptionPane.INFORMATION_MESSAGE);
        return;
    
       
    }
    
}
