package ARISEBANK;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class ChangePin extends JPanel {
    @SuppressWarnings("unused")
    private JPasswordField passwordField;
 
    private JLabel pinLabel,changeLabel,confirmLabel;
    private JPasswordField pinField;
  private JButton enterButton;
    private JFrame frame;
    private JPasswordField changeField, confirmField;
    private JLabel backgroundLabel;
    private JButton pinButton;
    private JPanel numpadPanel, numpadPanel2;

    private JPasswordField activeField = changeField; 
  

    public ChangePin(JFrame frame) {
        this.frame = frame;
        setLayout(null);
        ARISE.jtheme();

        backgroundLabel = new JLabel(new ImageIcon("src/main/resources/Photos/q.png"));
        backgroundLabel.setBounds(0, 0, 600, 400);
        add(backgroundLabel);

        ImageIcon icon = new ImageIcon("src/main/resources/Photos/headerLogo.png");
        JLabel logo = new JLabel(icon); 
        logo.setBounds(-7, 11, 70, 30);
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
        wc.setBounds(460, 6, 300, 15);
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
                ARISE.buttonSound();
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
                ARISE.buttonSound();
                EXIT.setForeground(Color.RED);
                EXIT.setBackground(Color.WHITE);
                EXIT.setFocusPainted(false);
                EXIT.setBorderPainted(false);
            }
        });
        backgroundLabel.add(EXIT);

        EXIT.addActionListener(_ -> {
            frame.setContentPane(new ARISEexit(frame));
            frame.validate(); 
        });



        pinLabel = new JLabel("ENTER YOUR PIN");
        pinLabel.setFont(new Font("Arial", Font.BOLD, 14));
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setBounds(110, 100, 300, 30);
        backgroundLabel.add(pinLabel);

        changeLabel = new JLabel("ENTER NEW PIN");
        changeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        changeLabel.setForeground(Color.WHITE);
        changeLabel.setBounds(110, 100, 300, 30);
        backgroundLabel.add(changeLabel);
        changeLabel.setVisible(false);

        confirmLabel = new JLabel("CONFIRM NEW PIN");
        confirmLabel.setFont(new Font("Arial", Font.BOLD, 14));
        confirmLabel.setForeground(Color.WHITE);
        confirmLabel.setBounds(100, 210, 300, 30);
        backgroundLabel.add(confirmLabel);
        confirmLabel.setVisible(false);
    
    
        pinField = new JPasswordField();
        pinField.setBounds(35, 140, 250, 50);
       pinField.setHorizontalAlignment(JPasswordField.CENTER);

        pinField.setFont(new Font("Arial", Font.BOLD, 30));
        pinField.setBorder(null);
        backgroundLabel.add(pinField);
        pinField.setVisible(true);
    
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

        numpadPanel = createNumpadPanel();
        numpadPanel.setBounds(350, 100, 210, 210);
        numpadPanel.setOpaque(false);
        backgroundLabel.add(numpadPanel);
        numpadPanel.setVisible(false);

        numpadPanel2 = createNumpadPanel2();
        numpadPanel2.setBounds(350, 100, 210, 210);
        numpadPanel2.setOpaque(false);
        backgroundLabel.add(numpadPanel2);

        confirmField = new JPasswordField();
        confirmField.setBounds(35, 240, 250, 50);
        confirmField.setFont(new Font("Arial", Font.BOLD, 30));
        confirmField.setHorizontalAlignment(JPasswordField.CENTER);
        confirmField.setBorder(null);
        backgroundLabel.add(confirmField);
        SwingUtilities.invokeLater(() -> {
        });
        confirmField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                String currentText = new String(confirmField.getPassword());

                if (!Character.isDigit(c) || currentText.length() >= 4) {
                    e.consume();
                }
            }
        });
        confirmField.addActionListener(_ -> checkConfirmPin());
        confirmField.setVisible(false);

        changeField = new JPasswordField();
        changeField.setBounds(35, 140, 250, 50);
        changeField.setHorizontalAlignment(JPasswordField.CENTER);
        changeField.setFont(new Font("Arial", Font.BOLD, 30));
        changeField.setBorder(null);
        backgroundLabel.add(changeField);
        SwingUtilities.invokeLater(() -> {
            changeField.requestFocusInWindow();
            changeField.grabFocus();
        });
        changeField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                String currentText = new String(changeField.getPassword());

                if (!Character.isDigit(c) || currentText.length() >= 4) {
                    e.consume();
                }
            }
        });
        changeField.addActionListener(_ -> checkChangepin());
        changeField.setVisible(false);

        changeField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                activeField = changeField;
            }
        });
        
        confirmField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                activeField = confirmField; 
            }
        });
    
     
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
    enterButton.addActionListener(_ -> {
        if (activeField == changeField && changeField.getPassword().length == 4) {
            activeField = confirmField; 
            confirmField.setVisible(true);
            confirmField.requestFocusInWindow();
        } else if (activeField == confirmField && confirmField.getPassword().length == 4) {
            checkConfirmPin();
        }
        if (activeField == changeField && changeField.getPassword().length < 4) {
            ARISE.errorSound();
            JOptionPane.showMessageDialog(this, "Invalid pin! Please enter a valid pin.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                    activeField.setText("");
                    activeField.requestFocusInWindow();
                    activeField.grabFocus();

            return;
        }
    });
    
enterButton.setVisible(false);    
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
                if (currentText.length() < 4 && input.matches("\\d")) {
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
    private void validatePin() {
        String pinInput = new String(pinField.getPassword());
        if (!pinInput.isEmpty() && Integer.parseInt(pinInput) == ARISE.USER_PIN) {
            changepin();
    
        } else {
            ARISE.errorSound();
            JOptionPane.showMessageDialog(this, "Invalid PIN! Transaction canceled.", 
                    "Transaction Failed", JOptionPane.ERROR_MESSAGE);
                    frame.setContentPane(new ARISEmenu(frame));
                    frame.revalidate();
            frame.repaint();


           return;
        }
    }
    private void changepin() {
       pinField.setVisible(false);
       numpadPanel2.setVisible(false);
       pinButton.setVisible(false);
       pinLabel.setVisible(false);

        changeField.setVisible(true);
        confirmField.setVisible(true);
        changeLabel.setVisible(true);
        confirmLabel.setVisible(true);
        numpadPanel.setVisible(true);
        enterButton.setVisible(true);
        changeField.requestFocusInWindow();
        changeField.grabFocus();
    }
    private void checkChangepin() {
        if (changeField.getPassword().length == 0 || changeField.getPassword().length < 4) {
            ARISE.errorSound();
            JOptionPane.showMessageDialog(this, "Invalid pin! Please enter a valid pin.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                    changeField.setText("");
            return;
        }

       if (Integer.parseInt(new String(changeField.getPassword())) == ARISE.USER_PIN) {
        ARISE.errorSound();
        JOptionPane.showMessageDialog(this, "New pin cannot be the same as the old pin! \n          Please enter a different pin.", 
        "Error", JOptionPane.ERROR_MESSAGE);
        changeField.setText("");
return;
       }
       confirmField.requestFocusInWindow();
         confirmField.grabFocus();
    }
    private void checkConfirmPin() {
        if (confirmField.getPassword().length == 0 || confirmField.getPassword().length < 4) {
            ARISE.errorSound();
            JOptionPane.showMessageDialog(this, "Invalid pin! Please enter a valid pin.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                    confirmField.setText("");
            return;
        }
        if (!new String(changeField.getPassword()).equals(new String(confirmField.getPassword()))) {
            ARISE.errorSound();
            JOptionPane.showMessageDialog(this, "Pin does not match! Please enter a valid pin.", 
            "Error", JOptionPane.ERROR_MESSAGE);
            confirmField.setText("");
    return;
           }
       showConfirmation();
    }
    private void showConfirmation() {
      
        try {
            String changedpin = new String(confirmField.getPassword());
            
            if (!changedpin.isEmpty() && Integer.parseInt(changedpin) == ARISE.USER_PIN) {
                ARISE.errorSound();
                JOptionPane.showMessageDialog(this, "New pin cannot be the same as the old pin! \n          Please enter a different pin.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
           

            int response = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to change your pin?",
                    "Pin Confirmation", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
    
            if (response == JOptionPane.YES_OPTION) {
                ARISE.USER_PIN = Integer.parseInt(changedpin);
                frame.setContentPane(new ARISElogin(frame));
                frame.revalidate();
                frame.repaint();
            } else {
             frame.setContentPane(new ARISEmenu(frame));
                frame.revalidate();
                frame.repaint();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid pin! Please enter a valid pin.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        

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
        if (activeField == null) {
            activeField = changeField; 
        }
        String currentText = new String(activeField.getPassword()).trim(); 
    
        switch (input) {
            case "C":
                activeField.setText("");
                activeField.setFont(new Font("Arial", Font.BOLD, 20));
                activeField.setForeground(Color.BLACK);
                break;
            case "<":
                if (!currentText.isEmpty()) {
                    activeField.setText(currentText.substring(0, currentText.length() - 1));
                    activeField.setFont(new Font("Arial", Font.BOLD, 20));
                    activeField.setForeground(Color.BLACK);
                }
                break;
            default:
                if (currentText.length() < 4 && input.matches("\\d")) {
                    activeField.setText(currentText + input);
                    activeField.setFont(new Font("Arial", Font.BOLD, 20));
                    activeField.setForeground(Color.BLACK);
                }
                break;
        }
    
     
        if (activeField.getPassword().length == 4) {
            if (Integer.parseInt(new String(changeField.getPassword())) == ARISE.USER_PIN) {
                ARISE.errorSound();
                JOptionPane.showMessageDialog(this, "New pin cannot be the same as the old pin! \n          Please enter a different pin.", 
                "Error", JOptionPane.ERROR_MESSAGE);
                activeField.setText("");
                activeField.requestFocusInWindow();
                activeField.grabFocus();

        return;
               }
            if (activeField == changeField) {
                activeField = confirmField; 
                confirmField.setVisible(true);
                confirmField.requestFocusInWindow();
            } else if (activeField == confirmField) {
                checkConfirmPin();
            }
        }
        
        SwingUtilities.invokeLater(() -> {
            activeField.requestFocusInWindow();
            activeField.grabFocus();
        });
    }

}