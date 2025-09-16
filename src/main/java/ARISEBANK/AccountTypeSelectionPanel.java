package ARISEBANK;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;

public class AccountTypeSelectionPanel extends JPanel {
    private JButton currentButton;
    private JButton savingsButton;
    
    public AccountTypeSelectionPanel(ActionListener actionListener) {
        setLayout(null);
        JLabel backgroundLabel = new JLabel(new ImageIcon("ARISEBANK/zsave.gif"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        JLabel title = new JLabel("SELECT ACCOUNT TYPE");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setForeground(Color.WHITE);
        title.setBounds(190, 50, 250, 30);
        backgroundLabel.add(title);

        currentButton = createButton("CURRENT", 80, 290, actionListener);
        backgroundLabel.add(currentButton);

        savingsButton = createButton("SAVINGS", 383, 290, actionListener);
        backgroundLabel.add(savingsButton);
    }

    private JButton createButton(String text, int x, int y, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBounds(x, y, 130, 30);
      
        button.setBackground(new Color(45, 37, 76));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
      
    
        button.setFocusPainted(false);
        button.addActionListener(actionListener);
        return button;
    
    }
}

