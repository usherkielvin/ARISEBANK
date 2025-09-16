package ARISEBANK;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends JPanel {
    private JFrame frame;
    private JTextField amountField;
    private JLabel backgroundLabel, selectService;
    private JButton enterButton,pinButton;
    private JLabel  pinLabel;
    private JPasswordField pinField;
    private JPanel numpadPanel, numpadPanel2;
    private float depositAmount;
    private String selectedAccountType;

    public Deposit(JFrame frame) {
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
            int response = JOptionPane.showConfirmDialog(this,
            "Do you want to go back to the menu ? ",
            "Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

    if (response == JOptionPane.YES_OPTION) {
        frame.setContentPane(new ARISEmenu(frame));
        frame.validate(); 
    } else {
        return;
    }
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
    selectService = new JLabel("SELECT AMOUNT TO DEPOSIT");
    selectService.setFont(new Font("Arial", Font.BOLD, 14));
    selectService.setForeground(Color.WHITE);
    selectService.setBounds(50, 90, 300, 30);
    backgroundLabel.add(selectService);
//TEXTBOX
    amountField = new JTextField();
    amountField.setBounds(35, 140, 250, 50);
    amountField.setFont(new Font("Arial", Font.BOLD, 30));
    amountField.setBorder(null);
    amountField.setHorizontalAlignment(SwingConstants.CENTER);
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
    amountField.addActionListener(_ -> showConfirmation());

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
        if (selectedAccountType == null) {
            showAccountTypeSelection();
            return;
        }
        try {
            String enteredAmount = amountField.getText();
            
            if (enteredAmount.isEmpty() || enteredAmount.equals("Enter here for other amount")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            depositAmount = Float.parseFloat(enteredAmount);
            if (depositAmount > 50000) {
                amountField.setText("");
                amountField.requestFocusInWindow();
                amountField.grabFocus();
                JOptionPane.showMessageDialog(this, "Invalid amount! Cannot exceed 50,000.", 
                        "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                return;
            } 
        
pinField.setVisible(false);
            int response = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to deposit " + depositAmount + " into " + selectedAccountType + " account?",
                    "Deposit Confirmation", 
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
    private void showAccountTypeSelection() {
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Select Account Type", true);
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setUndecorated(true);
        dialog.setResizable(false);
    
        AccountTypeSelectionPanel selectionPanel = new AccountTypeSelectionPanel(e -> {
            JButton source = (JButton) e.getSource();
            selectedAccountType = source.getText();
            dialog.dispose();
            showConfirmation(); 
        });
    
        dialog.setContentPane(selectionPanel);
        dialog.setVisible(true);
    }
    
    
    private void askForPin() {
        pinField.requestFocusInWindow();
        pinField.grabFocus();
        pinLabel.setVisible(true);
        pinField.setVisible(true);
        pinButton.setVisible(true);

        amountField.setVisible(false);
            enterButton.setVisible(false);
            numpadPanel.setVisible(false);
            selectService.setVisible(false);

            numpadPanel2.setVisible(true);
    }
    private void validatePin() {
        String pinInput = new String(pinField.getPassword());
        if (!pinInput.isEmpty() && Integer.parseInt(pinInput) == ARISE.USER_PIN) {

            if (selectedAccountType.equals("CURRENT")) {
                ARISE.Currentbalance += depositAmount;
            } else {
                ARISE.Savingsbalance += depositAmount;
            }
            JOptionPane.showMessageDialog(this, "Deposit successful! New balance: " +
            (selectedAccountType.equals("CURRENT") ? ARISE.Currentbalance : ARISE.Savingsbalance),
            "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);

    askForAReceipt();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid PIN! Transaction canceled.", 
                    "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                    frame.setContentPane(new ARISEmenu(frame));
                    frame.revalidate();
            frame.repaint();


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
         frame.setContentPane(new ARISEmenu(frame));
            frame.revalidate();
            frame.repaint();

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
            History.addTransaction("WITHDRAWAL", depositAmount, ARISE.Currentbalance, atmId, transactionNumber);

            new Receipt("DEPOSIT", depositAmount,ARISE.Currentbalance).setVisible(true);
           timer();
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
    public void timer() {
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askForAnotherTransaction();
            }
        });
        timer.setRepeats(false); // Ensure it only runs once
        timer.start();
    }
}
