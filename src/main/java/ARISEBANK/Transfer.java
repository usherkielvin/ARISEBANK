package ARISEBANK;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Transfer extends JPanel {
    public Transfer(JFrame frame) {
        setLayout(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/Transfer.png"));
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
        date.setBounds(470, 20, 300, 15);
        backgroundLabel.add(date);

        String currentDateTime = new SimpleDateFormat("d'th' MMMM, yyyy | h:mm a").format(new Date());
        date.setText(currentDateTime);
        
        JLabel welcomeLabel = new JLabel("ARISE BANK");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 35));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(60, 10, 300, 30);
        backgroundLabel.add(welcomeLabel);

        JLabel wc = new JLabel(ARISE.GreetingMessage());
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

        JLabel transferLabel = new JLabel("TRANSFER");
        transferLabel.setFont(new Font("Arial", Font.BOLD, 20));
        transferLabel.setBounds(245, 10, 300, 30);
        backgroundLabel.add(transferLabel);
//METRO
         JButton metroButton = createButton(" ", 232, 83, 136, _ -> {
            ARISE.buttonSound();
            frame.setContentPane(new metroBank(frame));
            frame.validate();
        });
        backgroundLabel.add(metroButton);

        
        JButton pnbButton = createButton(" ", 232, 213, 136, _ -> {
            ARISE.buttonSound();
            frame.setContentPane(new pnb(frame));
            frame.validate();
        });
        backgroundLabel.add(pnbButton);

//BPI
        JButton bpiButton = createButton("", 423, 78, 137, _ -> {
            ARISE.buttonSound();
            frame.setContentPane(new bpi(frame));
            frame.validate();
        });
        backgroundLabel.add(bpiButton);
//BPI
        JButton landbankButton = createButton("", 423, 214, 137, _ -> {
            ARISE.buttonSound();
            frame.setContentPane(new landbank(frame));
            frame.validate();
        });
        backgroundLabel.add(landbankButton);

        JButton bdoButton = createButton("", 40, 83, 136, _ -> {
            ARISE.buttonSound();
            frame.setContentPane(new bdo(frame));
            frame.validate();
        });
        backgroundLabel.add(bdoButton);
        
        JButton savingsAccount = createButton("", 39, 214, 141, _ -> {
            ARISE.buttonSound();
   
            frame.setContentPane(new chinabank(frame));
            frame.validate();
        });
        backgroundLabel.add(savingsAccount);

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
        button.setFont(new Font("Arial", Font.BOLD, 9));
        button.setBounds(x, y, w, 77);
        button.setBackground(new Color(45, 37, 76));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
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