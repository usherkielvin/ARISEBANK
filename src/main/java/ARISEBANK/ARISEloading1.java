package ARISEBANK;

import java.awt.*;
import javax.swing.*;

public class ARISEloading1 extends JPanel {
    public ARISEloading1(JFrame frame) {

        setLayout(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/loading.gif"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        JLabel headerLabel = new JLabel("Cash Withdrawals | Deposit | Bank Transfer | Bill Payments | Others");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(3, 5, 1000, 50);
        backgroundLabel.add(headerLabel); 
        Timer timer = new Timer(1000, _ -> {
            ARISE.buttonSound();
            frame.setContentPane(new ARISEmenu(frame));
            frame.revalidate();
        });
        timer.setRepeats(false);
        timer.start(); 
}
}
