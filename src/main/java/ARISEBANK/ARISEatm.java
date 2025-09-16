package ARISEBANK;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ARISEatm extends JPanel {
    public ARISEatm(JFrame frame) {
        setLayout(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/p.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        JButton tapButton = new JButton("");
        tapButton.setFont(new Font("Arial", Font.BOLD, 15));
        tapButton.setForeground(Color.WHITE);
        tapButton.setOpaque(false);
        tapButton.setContentAreaFilled(false);
        tapButton.setBorderPainted(false);
        tapButton.setFocusPainted(false);
        tapButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tapButton.setBounds(0, 0, 600, 400);

        ActionListener startAction = _ -> {
            ARISE.buttonSound();
            frame.setContentPane(new ARISEinsertCard(frame));
            frame.revalidate();
        };

        tapButton.addActionListener(startAction);

        // Add KeyListener to trigger button action on Enter key press
        tapButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    startAction.actionPerformed(null);
                }
            }
        });

        // Set focus to tapButton when panel loads
        SwingUtilities.invokeLater(() -> tapButton.requestFocusInWindow());

        backgroundLabel.add(tapButton);

        JLabel tapLabel = new JLabel("TAP THE SCREEN TO START");
        tapLabel.setFont(new Font("Arial", Font.BOLD, 15));
        tapLabel.setForeground(Color.WHITE);
        tapLabel.setBounds(190, 300, 300, 20);
        backgroundLabel.add(tapLabel);

        JLabel welcome = new JLabel("WELCOME TO");
        welcome.setFont(new Font("Arial Black", Font.PLAIN, 35));
        welcome.setForeground(Color.WHITE);
        welcome.setBounds(275, 80, 1000, 100);
        backgroundLabel.add(welcome);

        JLabel ar = new JLabel("ARISE BANK");
        ar.setFont(new Font("Arial Black", Font.PLAIN, 35));
        ar.setForeground(Color.WHITE);
        ar.setBounds(280, 120, 1000, 100);
        backgroundLabel.add(ar);

        JLabel rise = new JLabel("Together, We Rise!");
        rise.setFont(new Font("Arial Narrow", Font.BOLD, 25));
        rise.setForeground(Color.WHITE);
        rise.setBounds(310, 180, 9000, 100);
        backgroundLabel.add(rise);

        ImageIcon banklogo = new ImageIcon("src/main/resources/Photos/l.png");
        JLabel logo = new JLabel(banklogo); 
        logo.setBounds(10, 90, 195, 195);
        backgroundLabel.add(logo);

        JLabel headerLabel = new JLabel("Cash Withdrawals | Deposit | Bank Transfer | Bill Payments | Others");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(3, 5, 1000, 50);
        backgroundLabel.add(headerLabel);
    }
}
