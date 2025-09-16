package ARISEBANK;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class ARISElogin extends JPanel {

    private JPasswordField passwordField;
    private JLabel validatingLabel; 
    private JFrame loginFrame;
    private int pinAttempts = 0;
    private final int MAX_ATTEMPTS = 3;
    private JPanel numpadPanel;

    public ARISElogin(JFrame frame) {
    this.loginFrame = frame;
    setLayout(null);
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
    date.setBounds(470, 20, 300, 15);
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
    messageTitle.setBounds(470, 6, 300, 15);
    backgroundLabel.add(messageTitle);
//BARLINE TITLE
    JLabel barlineTitle = new JLabel("|");
    barlineTitle.setFont(new Font("Arial", Font.PLAIN, 35));
    barlineTitle.setForeground(Color.WHITE);
    barlineTitle.setBounds(285, 0, 300, 45);
    backgroundLabel.add(barlineTitle);
//PIN LABEL
    JLabel pinLabel = new JLabel("Enter your 4-digit PIN:");
    pinLabel.setForeground(Color.WHITE);
    pinLabel.setBounds(80, 90, 300, 30);
    pinLabel.setFont(new Font("Arial", Font.BOLD, 14));
    backgroundLabel.add(pinLabel);
//PASSWORD FIELD
    passwordField = new JPasswordField();
    passwordField.setBounds(35, 140, 250, 50);
    passwordField.setFont(new Font("Arial", Font.BOLD, 30));
    passwordField.setHorizontalAlignment(SwingConstants.CENTER);
    passwordField.setBorder(null);
    backgroundLabel.add(passwordField);

    SwingUtilities.invokeLater(() -> {
        passwordField.requestFocusInWindow();
        passwordField.grabFocus();
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                String currentText = new String(passwordField.getPassword());

                if (!Character.isDigit(c) || currentText.length() >= 4) {
                    e.consume();
                }
            }
        });
        passwordField.addActionListener(_ -> performLogin());
//ENTER BUTTON
     JButton enterButton = new JButton(">");
    enterButton.setBounds(515, 210, 45, 45);
    enterButton.setFont(new Font("Arial", Font.BOLD, 18));
    enterButton.setBackground(Color.GREEN);
    enterButton.setFocusPainted(false);
    enterButton.setForeground(Color.WHITE);
    enterButton.setOpaque(true);
    enterButton.setFocusPainted(false);
    enterButton.setContentAreaFilled(true);
    enterButton.setBorderPainted(true);
    enterButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            enterButton.setBackground(new Color(125, 150, 125));
            enterButton.setForeground(Color.WHITE);
            enterButton.setFocusPainted(false);
            enterButton.setBorderPainted(false);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            enterButton.setForeground(Color.WHITE);
            enterButton.setBackground(Color.GREEN);
            enterButton.setBorderPainted(true);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            enterButton.setForeground(Color.GREEN);
            enterButton.setBackground(Color.WHITE);
            enterButton.setFocusPainted(false);
            enterButton.setBorderPainted(false);
            ARISE.buttonSound();
        }
    });
    backgroundLabel.add(enterButton);
    enterButton.addActionListener(_ -> performLogin());
//EXIT BUTTON
    JButton exitButton = new JButton("EXIT");
    exitButton.setFont(new Font("Arial", Font.BOLD, 12));
    exitButton.setBackground(new Color(45,37,76));
    exitButton.setForeground(Color.WHITE);
    exitButton.setBounds(500, 360, 90, 30);
    exitButton.setOpaque(true);
    exitButton.setFocusPainted(false);
    exitButton.setContentAreaFilled(true);
    exitButton.setBorderPainted(true);
    exitButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
                exitButton.setBackground(Color.RED);
                exitButton.setFocusPainted(false);
                exitButton.setBorderPainted(false);
            }
            @Override

            public void mouseExited(MouseEvent e) {
                exitButton.setForeground(Color.WHITE);
                exitButton.setBackground(new Color(45,37,76));
                exitButton.setBorderPainted(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                exitButton.setForeground(Color.RED);
                exitButton.setBackground(Color.WHITE);
                exitButton.setFocusPainted(false);
                exitButton.setBorderPainted(false);
                ARISE.buttonSound();
             
            }
        });
        backgroundLabel.add(exitButton);
        exitButton.addActionListener(_ -> {
      
            loginFrame.setContentPane(new ARISEexit(loginFrame));
            loginFrame.validate();
            
        });
//VALIDATING LABEL
        validatingLabel = new JLabel("");
        validatingLabel.setBounds(55, 200, 200, 30);
        validatingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        validatingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        validatingLabel.setForeground(Color.WHITE);
        validatingLabel.setOpaque(false);
        backgroundLabel.add(validatingLabel);
//JOPTION THEME
        ARISE.jtheme();
//NUMPAD PANEL
        numpadPanel = createNumpadPanel();
        numpadPanel.setBounds(350, 100, 210, 210);
        numpadPanel.setOpaque(false);
        backgroundLabel.add(numpadPanel);
    }
//NUMPAD PANEL
    private JPanel createNumpadPanel() {
        JPanel numpadPanel = new JPanel(new GridLayout(4, 4, 10, 10));
    
        String[][] buttons = {
            {"1", "2", "3", "C"},
            {"4", "5", "6", "<"},
            {"7", "8", "9", ""},
            {"", "0", "", ""}
        };
    
        for (String[] row : buttons) {
            for (String text : row) {
                if (text.isEmpty()) {
                    numpadPanel.add(new JLabel());
                } else {
                    JButton button = new JButton(text);
                    button.setFont(new Font("Arial", Font.BOLD, 18));
                    button.setOpaque(true);
                    button.setFocusPainted(false);
                    button.setContentAreaFilled(true);
                    button.setBorderPainted(true);
                    button.setBorder(BorderFactory.createLineBorder(new Color(45, 37, 76), 1));
                    if (text.equals("C")) {
                        button.setBackground(Color.RED);
                        button.setForeground(Color.WHITE);
                    }
                     else if (text.equals("<")) {
                        button.setBackground(Color.orange);
                        button.setForeground(Color.WHITE);
                    }
                    else {
                        button.setBackground(Color.white);
                        button.setForeground(Color.BLACK);
                    }
                    button.addActionListener(_ -> handleNumpadInput(text));
                    numpadPanel.add(button);
                    button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            if (text.equals("C")) {
                                button.setBackground(new Color(166,44 , 42));
                                button.setForeground(Color.WHITE);
                            }
                             else if (text.equals("<")) {
                                button.setBackground(new Color(255, 165, 0));
                                button.setForeground(Color.WHITE);
                            }
                            else {
                                button.setBackground(Color.white);
                                button.setForeground(Color.BLACK);
                            }   
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            if (text.equals("C")) {
                                button.setBackground(Color.red);
                                button.setForeground(Color.white);
                            }
                             else if (text.equals("<")) {
                                button.setBackground(Color.orange);
                                button.setForeground(Color.white);
                            }
                            else {
                                button.setBackground(Color.white);
                                button.setForeground(Color.BLACK);
                            }
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            if (text.equals("C")) {
                                button.setBackground(Color.WHITE);
                                button.setForeground(Color.RED);
                            }
                             else if (text.equals("<")) {
                                button.setBackground(Color.WHITE);
                                button.setForeground(Color.orange);
                            }
                            else {
                                button.setBackground(Color.white);
                                button.setForeground(Color.BLACK);
                            }  
                            ARISE.buttonSound();
                            passwordField.requestFocusInWindow();
                            passwordField.grabFocus();
                        }
                    });
                }
            }
        }
        return numpadPanel;
    }
//NUMPAD INPUT
    private void handleNumpadInput(String input) {
        
        String currentText = new String(passwordField.getPassword());
        if (currentText.length() >= 4) {
         
        }

        switch (input) {
            case "C":
                passwordField.setText("");
                SwingUtilities.invokeLater(() -> {
                    passwordField.requestFocusInWindow();
                    passwordField.grabFocus();
                    });   
                break;
            case "<":
                if (currentText.length() > 0) {
                    passwordField.setText(currentText.substring(0, currentText.length() - 1));
                    SwingUtilities.invokeLater(() -> {
                        passwordField.requestFocusInWindow();
                        passwordField.grabFocus();
                        });
                }
                break;
            default:
                if (currentText.length() < 4) {
                    passwordField.setText(currentText + input);
                    SwingUtilities.invokeLater(() -> {
        passwordField.requestFocusInWindow();
        passwordField.grabFocus();
        });
                }
                break;
        }
    }
//PERFORM LOGIN
    private void performLogin() {
        passwordField.requestFocusInWindow();
        passwordField.grabFocus();
        String password = new String(passwordField.getPassword());

        if (password.isEmpty()) {
            ARISE.errorSound();
            JOptionPane.showMessageDialog(loginFrame, "PIN cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (password.length() < 4) {
            ARISE.errorSound();
            JOptionPane.showMessageDialog(loginFrame, "PIN must be 4 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
        validatingLabel.setText("Validating PIN");
        }
        new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(500); 
                    final int dots = i;
                    SwingUtilities.invokeLater(() -> validatingLabel.setText("Validating PIN" + ".".repeat(dots + 1)));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (password.equals(String.valueOf(ARISE.USER_PIN))) { 
                SwingUtilities.invokeLater(() -> {
                    ARISE.buttonSound();
                    JOptionPane.showMessageDialog(loginFrame, "LOGIN SUCCESSFUL ", "ARISE BANK", JOptionPane.INFORMATION_MESSAGE);
                    ARISE.buttonSound();
                        loginFrame.setContentPane(new ARISEloading1(loginFrame));
                        loginFrame.validate();
                });
            } else {
                SwingUtilities.invokeLater(() -> {
                    pinAttempts++;
                    passwordField.setText("");
                    if (pinAttempts >= MAX_ATTEMPTS) {
                        ARISE.errorSound();
                        JOptionPane.showMessageDialog(loginFrame, 
                            "You have reached the maximum attempts!", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                            loginFrame.setContentPane(new ARISEexit(loginFrame));
                            loginFrame.validate();

                    } else {
                        ARISE.errorSound();
                        JOptionPane.showMessageDialog(loginFrame, 
                            "Invalid PIN! " + (MAX_ATTEMPTS - pinAttempts) + " attempts left.", 
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                            ARISE.buttonSound();
                    }
                    validatingLabel.setText("");
                });
                
            }
        }).start();  
    }
}