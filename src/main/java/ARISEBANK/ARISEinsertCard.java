package ARISEBANK;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ARISEinsertCard extends JPanel {

    public ARISEinsertCard(JFrame frame) {
        setLayout(null);
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/ab.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        JLabel headerLabel = new JLabel("Cash Withdrawals | Deposit | Bank Transfer | Bill Payments | Others");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(3, 5, 1000, 50);
        backgroundLabel.add(headerLabel);

        JLabel tapLabel = new JLabel("TAP TO INSERT CARD");
        tapLabel.setFont(new Font("Arial", Font.BOLD, 15));
        tapLabel.setForeground(Color.WHITE);
        tapLabel.setBounds(205, 290, 300, 30);
        backgroundLabel.add(tapLabel);

        JButton tapButton = new JButton("");
        tapButton.setFont(new Font("Arial", Font.BOLD, 15));
        tapButton.setForeground(Color.WHITE);
        tapButton.setOpaque(false);
        tapButton.setContentAreaFilled(false);
        tapButton.setBorderPainted(false);
        tapButton.setFocusPainted(false);
        tapButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tapButton.setBounds(0, 0, 600, 400);

        ActionListener insertCardAction = _ -> {
            backgroundLabel.setIcon(new ImageIcon("src/main/resources/Photos/bv.gif"));
            revalidate();
            repaint();
            ARISE.buttonSound();

            Timer timer = new Timer(600, _ -> {
                frame.setContentPane(new ARISEloading(frame));
                frame.revalidate();
            });
            timer.setRepeats(false);
            timer.start();

            Timer timer1 = new Timer(350, _ -> {
                ARISE.cardSound();
            });
            timer1.setRepeats(false);
            timer1.start();
        };

        tapButton.addActionListener(insertCardAction);

        tapButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    insertCardAction.actionPerformed(null);
                }
            }
        });
        SwingUtilities.invokeLater(() -> tapButton.requestFocusInWindow());
        backgroundLabel.add(tapButton);
    }
}
