package ARISEBANK;
import java.awt.*;
import javax.swing.*;
public class ARISEexit extends JPanel {
    public ARISEexit(JFrame frame) {
        setLayout(null);
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/s.gif"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        JLabel headerLabel = new JLabel("Cash Withdrawals | Deposit | Bank Transfer | Bill Payments | Others");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(3, 5, 1000, 50);
        backgroundLabel.add(headerLabel);

        Timer timer3 = new Timer(1300, _ -> {
            backgroundLabel.setIcon(new ImageIcon("src/main/resources/Photos/ab.png"));
            revalidate();
            repaint();

            JLabel tapLabel = new JLabel("PLEASE TAKE YOUR CARD");
            tapLabel.setFont(new Font("Arial", Font.BOLD, 15));
            tapLabel.setForeground(Color.WHITE);
            tapLabel.setBounds(190, 295, 300, 20);
            backgroundLabel.add(tapLabel);

            JOptionPane.showMessageDialog(frame, 
            "Thank you for banking with us.\n     Together, We Rise!", 
            "ARISE BANK", JOptionPane.INFORMATION_MESSAGE);
            ARISE.buttonSound();
            frame.setContentPane(new ARISEatm(frame));
            frame.revalidate();

        });

        timer3.setRepeats(false);
        timer3.start();

        Timer timer1 = new Timer(1000, _ -> {
            ARISE.cardSound();
        });
        timer1.setRepeats(false);
        timer1.start();
    }
}
