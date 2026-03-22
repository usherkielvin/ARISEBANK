package ARISEBANK;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.event.ActionListener;

public class AccountTypeSelectionPanel extends JPanel {
    private JButton currentButton;
    private JButton savingsButton;

    public AccountTypeSelectionPanel(ActionListener actionListener) {
        setLayout(null);
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/saq.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        JLabel title = new JLabel("SELECT ACCOUNT TYPE");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setForeground(Color.WHITE);
        title.setBounds(190, 50, 250, 30);
        backgroundLabel.add(title);

        currentButton = createButton("CURRENT", 80, 290, 130, actionListener);
        backgroundLabel.add(currentButton);

        savingsButton = createButton("SAVINGS", 383, 290, 130, actionListener);
        backgroundLabel.add(savingsButton);
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
}
