package ARISEBANK;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bpi extends JPanel {
    private JFrame frame;
    private JTextField amountField, AccountField, nameField;
    private JLabel backgroundLabel, selectService,name,amount,number;
    private JButton enterButton,pinButton;
    private JLabel  pinLabel;
    private JPasswordField pinField;
    private JPanel numpadPanel, numpadPanel2;
    private float amountPay;

    public bpi(JFrame frame) {
        this.frame = frame;
        setLayout(null);
        ARISE.jtheme();

        backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/q.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);
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

        ImageIcon banklogo = new ImageIcon("src/main/resources/Photos/headerLogo.png");
        JLabel logo = new JLabel(banklogo); 
        logo.setBounds(-7, 11, 70, 30);
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
//WELCOME MESSAGE
    selectService = new JLabel("TRANSFER TO BPI ACCOUNT");
    selectService.setFont(new Font("Arial", Font.BOLD, 14));
    selectService.setForeground(Color.WHITE);
    selectService.setBounds(30, 90, 300, 30);
    backgroundLabel.add(selectService);
//TEXTBOX
amount = new JLabel("Amount (Max of PHP 50,000.00)");
    amount.setFont(new Font("Arial", Font.PLAIN, 12));
    amount.setForeground(Color.WHITE);
    amount.setBounds(35, 112, 300, 30);
    backgroundLabel.add(amount);

    amountField = new JTextField();
    amountField.setBounds(35, 140, 250, 30);
    amountField.setFont(new Font("Arial", Font.BOLD, 18));
    amountField.setBorder(null);
    backgroundLabel.add(amountField);
    SwingUtilities.invokeLater(() -> {
        amountField.requestFocusInWindow();
        amountField.grabFocus();
    });
    amountField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent e) {
            char c = e.getKeyChar();
            String currentText = new String(amountField.getText());

            if (!Character.isDigit(c) || currentText.length() >= 30) {
                e.consume();
            }
        }
    });
    amountField.addActionListener(_ -> nameField.requestFocusInWindow());
//ACCOUNT FIELD
    AccountField = new JTextField();
    AccountField.setBounds(35, 255, 250, 30);
    AccountField.setFont(new Font("Arial", Font.BOLD, 18));
    AccountField.setBorder(null);
    backgroundLabel.add(AccountField);
    SwingUtilities.invokeLater(() -> {
        
    });
    AccountField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent e) {
            char c = e.getKeyChar();
            String currentText = new String(AccountField.getText());

            if (!Character.isDigit(c) || currentText.length() >= 15) {
                e.consume();
            }
        }
    });
    AccountField.addActionListener(_ -> showConfirmation());

    name = new JLabel("Account Name");
    name.setFont(new Font("Arial", Font.PLAIN, 12));
    name.setForeground(Color.WHITE);
    name.setBounds(35, 165, 300, 30);
    backgroundLabel.add(name);

    number = new JLabel("Account Number");
    number.setFont(new Font("Arial", Font.PLAIN, 12));
    number.setForeground(Color.WHITE);
    number.setBounds(35, 225, 300, 30);
    backgroundLabel.add(number);



    nameField = new JTextField();
    nameField.setBounds(35, 195, 250, 30);
    nameField.setFont(new Font("Arial", Font.BOLD, 18));
    nameField.setBorder(null);
    backgroundLabel.add(nameField);
    SwingUtilities.invokeLater(() -> {
        
    });
    nameField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent e) {
            char c = e.getKeyChar();
            String currentText = nameField.getText();
    
            if ((!Character.isLetter(c) && c != ' ') || currentText.length() >= 50) {
                e.consume();
            }
        }
    });
    
    nameField.addActionListener(_ -> AccountField.requestFocusInWindow());

    enterButton = new JButton(">");
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
    enterButton.addActionListener(_ -> showConfirmation());
//PIN MESSAGE
    pinLabel = new JLabel("ENTER YOUR PIN");
    pinLabel.setFont(new Font("Arial", Font.BOLD, 14));
    pinLabel.setForeground(Color.WHITE);
    pinLabel.setBounds(110, 100, 300, 30);
    backgroundLabel.add(pinLabel);
    pinLabel.setVisible(false);


    pinField = new JPasswordField();
    pinField.setBounds(35, 140, 250, 50);
    pinField.setVisible(false);
    pinField.setHorizontalAlignment(SwingConstants.CENTER);
    pinField.setFont(new Font("Arial", Font.BOLD, 30));
    pinField.setBorder(null);
    backgroundLabel.add(pinField);

    SwingUtilities.invokeLater(() -> {
        pinField.requestFocusInWindow();
        pinField.grabFocus();
        });
        pinField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                String currentText = new String(pinField.getPassword());

                if (!Character.isDigit(c) || currentText.length() >= 4) {
                    e.consume();
                }
            }
        });
        pinField.addActionListener(_ -> validatePin());

        pinButton = new JButton(">");
    pinButton.setBounds(515, 210, 45, 45);
    pinButton.setFont(new Font("Arial", Font.BOLD, 18));
    pinButton.setBackground(Color.GREEN);
    pinButton.setFocusPainted(false);
    pinButton.setForeground(Color.WHITE);
    pinButton.setOpaque(true);
    pinButton.setFocusPainted(false);
    pinButton.setContentAreaFilled(true);
    pinButton.setBorderPainted(true);
    pinButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            pinButton.setBackground(new Color(125, 150, 125));
            pinButton.setForeground(Color.WHITE);
            pinButton.setFocusPainted(false);
            pinButton.setBorderPainted(false);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            pinButton.setForeground(Color.WHITE);
            pinButton.setBackground(Color.GREEN);
            pinButton.setBorderPainted(true);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            pinButton.setForeground(Color.GREEN);
            pinButton.setBackground(Color.WHITE);
            pinButton.setFocusPainted(false);
            pinButton.setBorderPainted(false);
            ARISE.buttonSound();
        }
    });
    backgroundLabel.add(pinButton);
    pinButton.addActionListener(_ -> validatePin());
    pinButton.setVisible(false);

        numpadPanel = createNumpadPanel();
        numpadPanel.setBounds(350, 100, 210, 210);
        numpadPanel.setOpaque(false);
        backgroundLabel.add(numpadPanel);

        numpadPanel2 = createNumpadPanel2();
        numpadPanel2.setBounds(350, 100, 210, 210);
        numpadPanel2.setOpaque(false);
        backgroundLabel.add(numpadPanel2);
        numpadPanel2.setVisible(false);
    }

    private JPanel createNumpadPanel2() {
        numpadPanel2 = new JPanel(new GridLayout(4, 4, 10, 10));
    
        String[][] buttons = {
            {"1", "2", "3", "C"},
            {"4", "5", "6", "<"},
            {"7", "8", "9", ""},
            {"", "0", "", ""}
        };
    
        for (String[] row : buttons) {
            for (String text : row) {
                if (text.isEmpty()) {
                    numpadPanel2.add(new JLabel());
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
                    button.addActionListener(_ -> handleNumpadInput2(text));
                    numpadPanel2.add(button);
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
                        }
                    });
                }
            }
        }
        return numpadPanel2;
    }

    private void handleNumpadInput2(String input) {
        String currentText = new String(pinField.getPassword());
        if (currentText.equals("Enter here for other amount")) {
            currentText = "";
        }
        switch (input) {
            case "C":
                pinField.setText("");
                pinField.setFont(new Font("Arial", Font.BOLD, 20));
                pinField.setForeground(Color.BLACK);  
                break;
            case "<": 
                if (!currentText.isEmpty()) {
                    pinField.setText(currentText.substring(0, currentText.length() - 1));
                    pinField.setFont(new Font("Arial", Font.BOLD, 20));
                    pinField.setForeground(Color.BLACK);
                }
                break;
            default:
                if (currentText.length() < 30 && input.matches("\\d")) {
                    pinField.setText(currentText + input);
                    pinField.setFont(new Font("Arial", Font.BOLD, 20));
                    pinField.setForeground(Color.BLACK);
                }
                break;
        }
        SwingUtilities.invokeLater(() -> {
            pinField.requestFocusInWindow();
            pinField.grabFocus();
        });
    }

    private JPanel createNumpadPanel() {
        numpadPanel = new JPanel(new GridLayout(4, 4, 10, 10));
    
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
                        }
                    });
                }
            }
        }
        return numpadPanel;
    }

    private void handleNumpadInput(String input) {
        String currentText = amountField.getText().trim();
        if (currentText.equals("Enter here for other amount")) {
            currentText = "";
        }
        switch (input) {
            case "C":
                amountField.setText("");
                amountField.setFont(new Font("Arial", Font.BOLD, 20));
                amountField.setForeground(Color.BLACK);  
                break;
            case "<": 
                if (!currentText.isEmpty()) {
                    amountField.setText(currentText.substring(0, currentText.length() - 1));
                    amountField.setFont(new Font("Arial", Font.BOLD, 20));
                    amountField.setForeground(Color.BLACK);
                }
                break;
            default:
                if (currentText.length() < 30 && input.matches("\\d")) {
                    amountField.setText(currentText + input);
                    amountField.setFont(new Font("Arial", Font.BOLD, 20));
                    amountField.setForeground(Color.BLACK);
                }
                break;
        }
        SwingUtilities.invokeLater(() -> {
            amountField.requestFocusInWindow();
            amountField.grabFocus();
        });
    }

    private void showConfirmation() {

        
        try {
            String enteredAmount = amountField.getText();
            if (enteredAmount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            amountPay = Float.parseFloat(enteredAmount);
            if (ARISE.Currentbalance < amountPay) {
                amountField.setText("");
                amountField.requestFocusInWindow();
                amountField.grabFocus();
                JOptionPane.showMessageDialog(this, "Insufficient funds! Please enter a valid amount.", 
                        "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                return;
            } 
       
            enterButton.setVisible(false);
            numpadPanel.setVisible(false);
            selectService.setVisible(false);
            amountField.setVisible(false);
            nameField.setVisible(false);
            AccountField.setVisible(false);
            name.setVisible(false);
            amount.setVisible(false);
            number.setVisible(false);
            
            numpadPanel2.setVisible(true);

            int response = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to transfer " + amountPay + "?", 
                    "Transfer Confirmation", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
    
            if (response == JOptionPane.YES_OPTION) {
                askForPin();
                pinField.requestFocusInWindow();
                pinField.grabFocus();
            } else {
                resetScreen();
                revalidate();
                repaint();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid amount.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        

    }
    
    private void askForPin() {
        pinField.requestFocusInWindow();
        pinField.grabFocus();
        pinLabel.setVisible(true);
        pinField.setVisible(true);
        pinButton.setVisible(true);
    }
    private void validatePin() {
        String pinInput = new String(pinField.getPassword());
        if (!pinInput.isEmpty() && Integer.parseInt(pinInput) == ARISE.USER_PIN) {
            ARISE.Currentbalance -= Float.parseFloat(amountField.getText());
            JOptionPane.showMessageDialog(this, "Funds successfully transferred! \nNew  balance: " + ARISE.Currentbalance, 
                    "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);
            askForAReceipt();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid PIN! Transaction canceled.", 
                    "Transaction Failed", JOptionPane.ERROR_MESSAGE);
           return;
        }
    }
    private void askForAnotherTransaction() {
        int response = JOptionPane.showConfirmDialog(this, 
                "Do you want to make another transaction?", 
                "Another Transaction?", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            returnToMenu();
            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(frame, 
                            "Thank you for banking with us.\n     Together, We Rise!", 
                            "ARISE BANK", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
        }
    }
    private void askForAReceipt() {
        int response = JOptionPane.showConfirmDialog(this, 
                "Do you want to print a receipt?", 
                "Receipt", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            long transactionNumber = (long) (Math.random() * 1000000000L) + 1000000000L; 
            String atmId = "69143911";
            History.addTransaction("TRANSFER", amountPay, ARISE.Currentbalance, atmId, transactionNumber);

            new Receipt("DEPOSIT", amountPay,ARISE.Currentbalance).setVisible(true);
            timer();
            
          
            
        } else {
           askForAnotherTransaction();
        }
    }
    private void resetScreen() {
        amountField.requestFocusInWindow();
        amountField.grabFocus();
        amountField.setText("");
        amountField.setVisible(true);
        selectService.setVisible(true); 
            enterButton.setVisible(true);
            numpadPanel.setVisible(true);
            selectService.setVisible(true);
            createNumpadPanel().setVisible(true);

            numpadPanel2.setVisible(false);
            pinLabel.setVisible(false);
            pinField.setVisible(false);
            pinButton.setVisible(false);
            
    }
    private void returnToMenu() {
        ARISE frame = (ARISE) SwingUtilities.getWindowAncestor(this);
        frame.setContentPane(new ARISEmenu(frame));
        frame.revalidate();
        frame.repaint();
    }
    public void timer() {
        Timer timer = new Timer(4000, new ActionListener() { // 3000 ms = 3 seconds
            @Override
            public void actionPerformed(ActionEvent e) {
                askForAnotherTransaction();
            }
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start();
    }
}
