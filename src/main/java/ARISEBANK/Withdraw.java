package ARISEBANK;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;
public class Withdraw extends JPanel {
    private static JFrame frame;
    private JTextField amountField;
    private JPasswordField pinField;
    private JLabel backgroundLabel,transactionLabel,pinLabel;
    private JButton enterButton,enterButton2,enterAmount, hundred,twohundred,fivehundred,onethousand,twok,fivek;
    private float withdrawedAmount;
    private JPanel numpadPanel, numpadPanel2;
    private boolean transactionInProgress = false;

    private String selectedAccountType;



        public Withdraw(JFrame frame) {
            Withdraw.frame = frame;
            setLayout(null);
            ARISE.jtheme();
    
            backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/q.png"));
            backgroundLabel.setBounds(0, 0, 600, 400);
            add(backgroundLabel);
    
            ImageIcon icon = new ImageIcon("src/main/resources/zaq.png");
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
            date.setBounds(460, 20, 300, 15);
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
            transactionLabel = new JLabel("SELECT AMOUNT TO WITHDRAW");
            transactionLabel.setFont(new Font("Arial", Font.BOLD, 14));
            transactionLabel.setForeground(Color.WHITE);
            transactionLabel.setBounds(45, 95, 300, 30);
            backgroundLabel.add(transactionLabel);
    
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
    
    hundred = createButton("200", 40, 130,  _ -> {
        amountField.setText("200");
        withdrawedAmount = Integer.parseInt(amountField.getText());
        showConfirmation();
    });
    backgroundLabel.add(hundred);
    
    twohundred = createButton("500", 130, 130,  _ -> {
        amountField.setText("500");
        withdrawedAmount = Integer.parseInt(amountField.getText());
        showConfirmation();
    });
    backgroundLabel.add(twohundred);
    
    fivehundred = createButton("1000", 220, 130, _ -> {
        amountField.setText("1000");
        withdrawedAmount = Integer.parseInt(amountField.getText());
        showConfirmation();
    });
    backgroundLabel.add(fivehundred);
    
    
    onethousand = createButton("2000", 40, 180, _ -> {
        amountField.setText("2000");
        withdrawedAmount = Integer.parseInt(amountField.getText());
        showConfirmation();
        });
    backgroundLabel.add(onethousand);
    
    twok = createButton("3000", 130, 180,  _ -> {
        amountField.setText("3000");
        withdrawedAmount = Integer.parseInt(amountField.getText());
        showConfirmation();
    });
    backgroundLabel.add(twok);
    
    fivek = createButton("5000", 220, 180,  _ -> {
        amountField.setText("5000");
        withdrawedAmount = Integer.parseInt(amountField.getText());
        showConfirmation();
    });
    backgroundLabel.add(fivek);
    
    //WITHDRAWAL
    amountField = new JTextField();
    amountField.setBounds(40, 230, 160, 40);
    amountField.setFont(new Font("Arial", Font.PLAIN, 12));
    amountField.setForeground(Color.gray);
    amountField.setText("  Enter here for other amount");
    amountField.setBorder(null);
    backgroundLabel.add(amountField);
    amountField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (amountField.getText().equals("  Enter here for other amount")) {
                amountField.setText("");
                amountField.setFont(new Font("Arial", Font.BOLD, 20));
                amountField.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (amountField.getText().isEmpty()) {
                amountField.setForeground(Color.GRAY);
                amountField.setFont(new Font("Arial", Font.PLAIN, 12));
                amountField.setText("  Enter here for other amount");
            }
        }
    });
    SwingUtilities.invokeLater(() -> {
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
    
            enterAmount = new JButton("Enter");
            enterAmount.setBounds(220, 230, 70, 40);
            enterAmount.setFont(new Font("Arial", Font.BOLD, 12));
            enterAmount.setBackground(Color.GREEN);
            enterAmount.setFocusPainted(false);
            enterAmount.setForeground(Color.WHITE);
            enterAmount.setOpaque(true);
            enterAmount.setFocusPainted(false);
            enterAmount.setContentAreaFilled(true);
            enterAmount.setBorderPainted(true);
            enterAmount.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    enterAmount.setBackground(new Color(125, 150, 125));
                    enterAmount.setForeground(Color.WHITE);
                    enterAmount.setFocusPainted(false);
                    enterAmount.setBorderPainted(false);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    enterAmount.setForeground(Color.WHITE);
                    enterAmount.setBackground(Color.GREEN);
                    enterAmount.setBorderPainted(true);
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    enterAmount.setForeground(Color.GREEN);
                    enterAmount.setBackground(Color.WHITE);
                    enterAmount.setFocusPainted(false);
                    enterAmount.setBorderPainted(false);
                    ARISE.buttonSound();
                }
            });
            backgroundLabel.add(enterAmount);
            enterAmount.addActionListener(_ -> showConfirmation());
    
            numpadPanel = createNumpadPanel();
            numpadPanel.setBounds(350, 100, 210, 210);
            numpadPanel.setOpaque(false);
            backgroundLabel.add(numpadPanel);

            numpadPanel2 = createNumpadPanel2();
            numpadPanel2.setBounds(350, 100, 210, 210);
            numpadPanel2.setOpaque(false);
            backgroundLabel.add(numpadPanel2);
            numpadPanel2.setVisible(false);
    //PIN MESSAGE
            pinLabel = new JLabel("Enter your 4-digit PIN:");
            pinLabel.setForeground(Color.WHITE);
            pinLabel.setBounds(80, 90, 300, 30);
            pinLabel.setFont(new Font("Arial", Font.BOLD, 14));
            backgroundLabel.add(pinLabel);
    
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
    
                enterButton2 = new JButton(">");
                enterButton2.setBounds(515, 210, 45, 45);
                enterButton2.setFont(new Font("Arial", Font.BOLD, 18));
                enterButton2.setBackground(Color.GREEN);
                enterButton2.setFocusPainted(false);
                enterButton2.setForeground(Color.WHITE);
                enterButton2.setOpaque(true);
                enterButton2.setFocusPainted(false);
                enterButton2.setContentAreaFilled(true);
                enterButton2.setBorderPainted(true);
                enterButton2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        enterButton2.setBackground(new Color(125, 150, 125));
                        enterButton2.setForeground(Color.WHITE);
                        enterButton2.setFocusPainted(false);
                        enterButton2.setBorderPainted(false);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        enterButton2.setForeground(Color.WHITE);
                        enterButton2.setBackground(Color.GREEN);
                        enterButton2.setBorderPainted(true);
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        enterButton2.setForeground(Color.GREEN);
                        enterButton2.setBackground(Color.WHITE);
                        enterButton2.setFocusPainted(false);
                        enterButton2.setBorderPainted(false);
                        ARISE.buttonSound();
                    }
                });
                backgroundLabel.add(enterButton2);
                enterButton2.addActionListener(_ -> showConfirmation());
    
            enterButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validatePin();
            }
        });
            enterButton2.setVisible(false);
            pinField.setVisible(false);
            pinLabel.setVisible(false);
    
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
            EXIT.setForeground(Color.red);
            EXIT.setBounds(500, 360, 90, 30);
            EXIT.setOpaque(true);
            EXIT.setFocusPainted(false);
            EXIT.setContentAreaFilled(true);
            EXIT.setBorderPainted(true);
            EXIT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    EXIT.setBackground(Color.red);
                    EXIT.setForeground(new Color(45,37,76));
                    EXIT.setFocusPainted(false);
                    EXIT.setBorderPainted(false);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    EXIT.setForeground(Color.red);
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
                            }
                        });
                    }
                }
            }
            return numpadPanel;
        }
    
        private void handleNumpadInput(String input) {
            amountField.setFont(new Font("Arial", Font.BOLD, 20));
            amountField.setForeground(Color.BLACK);
            String currentText = amountField.getText().trim();
            if (currentText.equals("Enter here for other amount")) {
                currentText = "";
            }
            switch (input) {
                case "C":
                    amountField.setText("");
                    SwingUtilities.invokeLater(() -> {
                        amountField.requestFocusInWindow();
                        amountField.grabFocus();
                        });
                    break;
                case "<":
                    if (currentText.length() > 0) {
                        amountField.setText(currentText.substring(0, currentText.length() - 1));
                        SwingUtilities.invokeLater(() -> {
                            amountField.requestFocusInWindow();
                            amountField.grabFocus();
                            });
                    }
                    break;
                default:
                    if (currentText.length() < 4) {
                        amountField.setText(currentText + input);
                        SwingUtilities.invokeLater(() -> {
                            amountField.requestFocusInWindow();
                            amountField.grabFocus();
                            });
                    }
                    break;
            }
            SwingUtilities.invokeLater(() -> {
                amountField.requestFocusInWindow();
                amountField.grabFocus();
            });
        }
        
        private void showConfirmation() {
            if (transactionInProgress) return;

            if (selectedAccountType == null) {
                showAccountTypeSelection();
                return;
            }
        
            try {
                String enteredAmount = amountField.getText().trim();
                withdrawedAmount = Float.parseFloat(enteredAmount);
        
                if (enteredAmount.isEmpty() || enteredAmount.equals("Enter here for other amount")) {
                    ARISE.errorSound();
                    JOptionPane.showMessageDialog(frame, "Please enter an amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                if (withdrawedAmount % 100 != 0) {
                    ARISE.errorSound();
                    JOptionPane.showMessageDialog(this, "Invalid amount! We only dispense paper bills.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (withdrawedAmount < 200) {
                    ARISE.errorSound();
                    JOptionPane.showMessageDialog(this, "Invalid amount! Minimum withdrawal is 200.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                if (withdrawedAmount > ARISE.Currentbalance) {
                    amountField.setText("");
                    ARISE.errorSound();
                    JOptionPane.showMessageDialog(this, "Insufficient funds! Check your balance and try again.",
                            "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                transactionInProgress = true;
              int response = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to withdraw " + withdrawedAmount + " from your " + selectedAccountType + " account?",
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
            amountField.setVisible(false);
            hundred.setVisible(false);
            twohundred.setVisible(false);
            fivehundred.setVisible(false);
            onethousand.setVisible(false);
            twok.setVisible(false);
            fivek.setVisible(false);

            enterAmount.setVisible(false);
            transactionLabel.setVisible(false);
            enterButton.setVisible(false);
            numpadPanel.setVisible(false);

            pinLabel.setVisible(true);
            pinField.setVisible(true);
            enterButton2.setVisible(true);
            numpadPanel2.setVisible(true);
        }
        private void validatePin() {
            String pinInput = new String(pinField.getPassword());
            if (!pinInput.isEmpty() && Integer.parseInt(pinInput) == ARISE.USER_PIN) {
                withdrawedAmount = Float.parseFloat(amountField.getText());

                if (selectedAccountType.equals("CURRENT")) {
                    ARISE.Currentbalance -= withdrawedAmount;
                } else {
                    ARISE.Savingsbalance -= withdrawedAmount;
                }
                SwingUtilities.invokeLater(() -> {
                    askReciept();
                });
        
                return; 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid PIN! Transaction canceled.",
                        "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                resetScreen();
                returnToMenu();
                return;
            }
      
            }
        
        
        
            private void askReciept() {
                int response = JOptionPane.showConfirmDialog(this,
                        "Do you want to print a receipt?",
                        "Receipt",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            
                if (response == JOptionPane.YES_OPTION) {
                    long transactionNumber = (long) (Math.random() * 1000000000L) + 1000000000L; // Generate a random transaction number
String atmId = "69143911"; // Replace with actual ATM ID if needed

History.addTransaction("WITHDRAWAL", withdrawedAmount, ARISE.Currentbalance, atmId, transactionNumber);

                    Receipt receipt = new Receipt("WITHDRAWAL", withdrawedAmount, ARISE.Currentbalance);
                    receipt.setVisible(true);
            
                    // Delay returning to login to allow the receipt window to show
                    Timer timer = new Timer(3000, _ -> returnReciept());
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    returnReciept();
                }
            }
            
        

        private void returnReciept(){
            frame.setContentPane(new ARISElogin(frame));
                frame.revalidate();
                frame.repaint();
        }
    
        private void resetScreen() {
            amountField.setVisible(true);
            hundred.setVisible(true);
            twohundred.setVisible(true);
            fivehundred.setVisible(true);
            numpadPanel.setVisible(true);
            createNumpadPanel().setVisible(true);
            onethousand.setVisible(true);
            twok.setVisible(true);
            fivek.setVisible(true);
            enterAmount.setVisible(true);
            transactionLabel.setVisible(true);
            numpadPanel2.setVisible(false);
        }
    
        private void returnToMenu() {
            SwingUtilities.invokeLater(() -> {
                resetScreen();
                frame.setContentPane(new ARISEmenu(frame));
                frame.revalidate();
                frame.repaint();
            });
        }
        
        private JButton createButton(String text, int x, int y, java.awt.event.ActionListener action) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setBounds(x, y, 70, 40);
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
                    button.setBackground(Color.yellow);
                    button.setForeground(new Color(45, 37, 76));
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                }
    
                @Override
                public void mouseExited(MouseEvent e) {
                    button.setBackground(new Color(45, 37, 76));
                    button.setForeground(Color.WHITE);
                    button.setBorderPainted(true);
                }
    
                @Override
                public void mousePressed(MouseEvent e) {
                    button.setForeground(new Color(45, 37, 76));
                    button.setBackground(Color.yellow);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                }
            });
            return button;
        }
        
    }