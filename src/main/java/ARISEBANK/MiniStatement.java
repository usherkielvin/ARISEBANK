package ARISEBANK;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MiniStatement extends JPanel {
    @SuppressWarnings("unused")
    private JFrame frame;
    private JLabel backgroundLabel;
    public MiniStatement(JFrame frame) {
        setLayout(null);

        backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/q.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        ImageIcon icon = new ImageIcon("ARISEBANK/zlogo.png");
        JLabel logo = new JLabel(icon); 
        logo.setBounds(-7, 11, 70, 30);
        backgroundLabel.add(logo);

        JLabel date = new JLabel();
        date.setFont(new Font("Arial", Font.BOLD, 9));
        date.setForeground(Color.WHITE);
        date.setBounds(470, 20, 300, 15);
        backgroundLabel.add(date);

        Timer timer = new Timer(1000, _ -> {
        String currentDateTime = new SimpleDateFormat("d'th' MMMM, yyyy | h:mm a").format(new Date());
        date.setText(currentDateTime);
        });
        timer.start();
        
        JLabel welcomeLabel = new JLabel("ARISE BANK");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 35));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(60, 10, 300, 30);
        backgroundLabel.add(welcomeLabel);

        JLabel wc = new JLabel("MINI-STATEMENT");
        wc.setFont(new Font("Arial", Font.BOLD, 12));
        wc.setForeground(Color.WHITE);
        wc.setBounds(470, 6, 300, 15);
        backgroundLabel.add(wc);
        
        JLabel reach = new JLabel("|");
        reach.setFont(new Font("Arial", Font.PLAIN, 35));
        reach.setForeground(Color.WHITE);
        reach.setBounds(285, 0, 300, 45);
        backgroundLabel.add(reach);

        JLabel in = new JLabel("Rise With Us");
        in.setFont(new Font("Arial", Font.BOLD, 15));
        in.setForeground(Color.WHITE);
        in.setBounds(300, 15, 300, 20);
        backgroundLabel.add(in);

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
}