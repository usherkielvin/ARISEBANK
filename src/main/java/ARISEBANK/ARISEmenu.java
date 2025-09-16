package ARISEBANK;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class ARISEmenu extends JPanel {

    public ARISEmenu(JFrame frame) {
        setLayout(null);
        ARISE.jtheme();
//BACKGROUND LABEL
    JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/q.png")); 
    backgroundLabel.setBounds(0, 0, 600, 400);
    add(backgroundLabel);
//BANK LOGO
    ImageIcon banklogo = new ImageIcon("src/main/resources/Photos/headerLogo.png"); 
    JLabel logo = new JLabel(banklogo); 
    logo.setBounds(-7, 11, 70, 30);
    backgroundLabel.add(logo);
//DATE & TIME
    JLabel date = new JLabel();
    date.setFont(new Font("Arial", Font.BOLD, 9));
    date.setForeground(Color.WHITE);
    date.setBounds(460, 20, 300, 15);
    backgroundLabel.add(date);
//DATE FORMAT
    String currentDateTime = new SimpleDateFormat("d'th' MMMM, yyyy | h:mm a").format(new Date());
    date.setText(currentDateTime);
//BANK TITLE
    JLabel bankTitle = new JLabel("ARISE BANK");
    bankTitle.setFont(new Font("Arial", Font.BOLD, 35));
    bankTitle.setForeground(Color.WHITE);
    bankTitle.setBounds(60, 10, 300, 30);
    backgroundLabel.add(bankTitle);
//TAGLINE TITLE
    JLabel taglineTitle = new JLabel("Rise With Us");
    taglineTitle.setFont(new Font("Arial", Font.BOLD, 15));
    taglineTitle.setForeground(Color.WHITE);
    taglineTitle.setBounds(300, 15, 300, 20);
    backgroundLabel.add(taglineTitle);
//MESSAGE TITLE
    JLabel messageTitle = new JLabel(ARISE.GreetingMessage());
    messageTitle.setFont(new Font("Arial", Font.BOLD, 12));
    messageTitle.setForeground(Color.WHITE);
    messageTitle.setBounds(460, 6, 300, 15);
    backgroundLabel.add(messageTitle);
//BARLINE TITLE
    JLabel barlineTitle = new JLabel("|");
    barlineTitle.setFont(new Font("Arial", Font.PLAIN, 35));
    barlineTitle.setForeground(Color.WHITE);
    barlineTitle.setBounds(285, 0, 300, 45);
    backgroundLabel.add(barlineTitle);

//WELCOME MESSAGE
    JLabel selectService = new JLabel("PLEASE SELECT A SERVICE");
    selectService.setFont(new Font("Arial", Font.BOLD, 18));
    selectService.setForeground(Color.WHITE);
    selectService.setBounds(180, 60, 300, 30);
    backgroundLabel.add(selectService);
//CHECK BALANCE BUTTON
    JButton balanceButton = createButton("CHECK BALANCE", 50, 100, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new CheckBalance(frame));
            frame.validate();
        });
        backgroundLabel.add(balanceButton);
//DEPOSIT BUTTON
        JButton depositButton = createButton("DEPOSIT", 50, 155, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new Deposit(frame));
            frame.validate();
        });
        backgroundLabel.add(depositButton);
//WITHDRAW BUTTON
        JButton withdrawButton = createButton("WITHDRAW", 50, 210, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new Withdraw(frame));
            frame.validate();
        });
        backgroundLabel.add(withdrawButton);
//TRANSFER BUTTON
        JButton transferButton = createButton("TRANSFER", 50, 265, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new Transfer(frame));
            frame.validate();
        });
        backgroundLabel.add(transferButton);
//BILL PAYMENT BUTTON
        JButton billButton = createButton("PAYBILLS", 360, 155, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new Paybills(frame));
            frame.validate();
        });
        backgroundLabel.add(billButton);
//MOBILE TOPUP BUTTON
        JButton mobileButton = createButton("MOBILE TOPUP", 360, 100, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new MobileTopup(frame));
            frame.validate();
        });
        backgroundLabel.add(mobileButton);
//CHANGE PIN BUTTON
         JButton changepinButton = createButton("CHANGE PIN", 360, 210, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new ChangePin(frame));
            frame.validate();
        });
        backgroundLabel.add(changepinButton);
//MINI STATEMENT BUTTON       
        JButton statemeButton = createButton("MINI-STATEMENT", 360, 265, 190, _ -> {
           ARISE.buttonSound();
            frame.setContentPane(new History(frame));
            frame.validate();
        });
        backgroundLabel.add(statemeButton);
        
//EXIT BUTTON
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.setBackground(new Color(45,37,76));
        exitButton.setForeground(Color.red);
        exitButton.setBounds(500, 360, 90, 30);
        exitButton.setOpaque(true);
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(true);
        exitButton.setBorderPainted(true);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setBackground(Color.red);
                exitButton.setForeground(Color.WHITE);
                exitButton.setFocusPainted(false);
                exitButton.setBorderPainted(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setForeground(Color.red);
                exitButton.setBackground(new Color(45,37,76));
                exitButton.setBorderPainted(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
               ARISE.buttonSound();
                exitButton.setForeground(Color.RED);
                exitButton.setBackground(Color.WHITE);
                exitButton.setFocusPainted(false);
                exitButton.setBorderPainted(false);
            }
        });
        backgroundLabel.add(exitButton);

        exitButton.addActionListener(_ -> {
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
    }
//BUTTON DESIGN
    private JButton createButton(String text, int x, int y, int w, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBounds(x, y, w, 40);
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
                button.setBackground(Color.orange);
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
                button.setForeground(Color.BLACK);
                button.setBackground(new Color(45, 37, 76));
                button.setFocusPainted(false);
                button.setBorderPainted(false);
            }
        });
        return button;
    }
}
