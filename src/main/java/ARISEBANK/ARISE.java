package ARISEBANK;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.awt.event.*;

public class ARISE extends JFrame {
    public static  int USER_PIN = 1234;
    public static float Currentbalance = 3000f;
    public static float Savingsbalance = 5000f;
    
//FRAME
    public ARISE() {
        setTitle("ARISE BANK");
        ImageIcon framelogo = new ImageIcon("src/main/resources/Photos/ARISElogo.png");
        setIconImage(framelogo.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); 
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        setContentPane(new ARISEatm(this));
       
        
    }
//MAIN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ARISE frame = new ARISE();
            frame.setVisible(true);
        });  
    }
//GREETING ON HEADER
    public static String GreetingMessage() {
        String greeting = "";
        int time = Integer.parseInt(new SimpleDateFormat("HH").format(new Date()));
        if (time >= 0 && time < 12) {
            greeting = "Good Morning!";
        } else if (time >= 12 && time < 16) {
            greeting = "Good Afternoon!";
        } else {greeting = "Good Evening!";
        } 
        return greeting;
    }
// JOPTION THEME
    public static void jtheme() {
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
        UIManager.put("OptionPane.messageForeground", Color.WHITE); 
        UIManager.put("OptionPane.background", new Color(45, 37, 76)); 
        UIManager.put("Panel.background", new Color(45, 37, 76)); 
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 12)); 
        UIManager.put("Button.focus", Color.TRANSLUCENT);
        ImageIcon icon1 = new ImageIcon("src/main/resources/zaq.png"); 
        UIManager.put("OptionPane.informationIcon", icon1);
        ImageIcon icon2 = new ImageIcon("src/main/resources/zerror.png");
        UIManager.put("OptionPane.errorIcon", icon2);
    }
//BUTTON CLICK SOUND
    public  static void buttonSound() {
        try {
            File soundFile = new File("src/main/resources/Sounds/clickButton.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
//ERROR SOUND 
    public static void errorSound() {
        try {
            File soundFile = new File("src/main/resources/Sounds/errorSound.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void cardSound() {
        try {
            File soundFile = new File("src/main/resources/Sounds/cardsound.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public static void print() {
        try {
            File soundFile = new File("src/main/resources/zprin.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    

}
class Receipt extends JFrame {
    public Receipt(String transactionType, float amount, float balance) {
        ARISE.print();
        setTitle("Receipt");
        ImageIcon framelogo = new ImageIcon("src/main/resources/Photos/ARISElogo.png");
        setIconImage(framelogo.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 350);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setResizable(false);
        setLayout(null);
        ImageIcon framelogo1 = new ImageIcon("src/main/resources/Photos/ARISElogo.png");
        setIconImage(framelogo1.getImage());
        JPanel recieptPanel = new JPanel(null);
        recieptPanel.setBackground(Color.WHITE);
        recieptPanel.setBounds(0,-500,300,450);
        
        Random random = new Random();
        long randomNumber = 1000000000L + (long) (random.nextDouble() * 7000000000L);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        ImageIcon icon = new ImageIcon("src/main/resources/z111.png");
        JButton logo = new JButton(icon);
        logo.setFont(new Font("Arial", Font.PLAIN, 12));
        logo.setBackground(new Color(45,37,76));
        logo.setForeground(Color.WHITE);
        logo.setOpaque(false);
        logo.setFocusPainted(false);
        logo.setContentAreaFilled(false);
        logo.setBorderPainted(false);

        ImageIcon sheesh = new ImageIcon("src/main/resources/Photos/qr.png");
        JButton qr = new JButton(sheesh);
        qr.setFont(new Font("Arial", Font.PLAIN, 12));
        qr.setBackground(new Color(45,37,76));
        qr.setForeground(Color.WHITE);
        qr.setOpaque(false);
        qr.setFocusPainted(false);
        qr.setContentAreaFilled(false);
        qr.setBorderPainted(false);

        JButton closeButton = new JButton("X");
        closeButton.setBounds(165, 5, 50, 20);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setForeground(Color.BLACK);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(_ -> dispose());
        recieptPanel.add(closeButton);

        JLabel title = new JLabel("ARISE BANK", JLabel.CENTER);
        title.setForeground(Color.black);
        title.setBounds(55, 70, 100, 30);          

        JLabel dateLabel = new JLabel("Date: ");
        JLabel dateValue = new JLabel(formattedDateTime);
        JLabel line = new JLabel("--------------------------------------------");
        JLabel idLabel = new JLabel("ID: ");
        JLabel idValue = new JLabel(String.valueOf(randomNumber));
        JLabel typeLabel = new JLabel("Type: ");
        JLabel typeValue = new JLabel(transactionType);
        JLabel amountLabel = new JLabel("Amount: ");
        JLabel amountValue = new JLabel(String.format("₱%.2f", amount));
        JLabel balanceLabel = new JLabel("Balance: ");
        JLabel balanceValue = new JLabel(String.format("₱%.2f", balance));

        dateLabel.setForeground(Color.black);
        amountLabel.setForeground(Color.black);
        balanceLabel.setForeground(Color.black);

        dateLabel.setBounds(15, 120, 100, 30);
        dateValue.setBounds(40, 120, 150, 30);
        idLabel.setBounds(15, 140, 100, 30);
        idValue.setBounds(40, 140, 150, 30);
        typeLabel.setBounds(15, 180, 150, 30);
        typeValue.setBounds(40, 180, 150, 30);
        amountLabel.setBounds(15, 200, 100, 30);
        amountValue.setBounds(40, 200, 150, 30);
        balanceLabel.setBounds(15, 220, 100, 30);
        balanceValue.setBounds(40, 220, 150, 30);
        line.setBounds(15, 160, 300, 30);
        logo.setBounds(55, 24, 100, 50);
   
        qr.setBounds(55, 260, 100, 50);

        JLabel footer = new JLabel("Thank you for banking with us.");
        footer.setForeground(Color.GRAY);
        footer.setBounds(15, 305, 300, 30);

        JLabel footer1 = new JLabel("Together, We Rise!");
        footer1.setForeground(Color.GRAY);
        footer1.setBounds(45, 320, 300, 30);

        dateValue.setHorizontalAlignment(JTextField.RIGHT);
        idValue.setHorizontalAlignment(JTextField.RIGHT);
        typeValue.setHorizontalAlignment(JTextField.RIGHT);
        amountValue.setHorizontalAlignment(JTextField.RIGHT);
        balanceValue.setHorizontalAlignment(JTextField.RIGHT);

        recieptPanel.add(title);
        recieptPanel.add(dateLabel);
        recieptPanel.add(dateValue);
        recieptPanel.add(idLabel);
        recieptPanel.add(idValue);
        recieptPanel.add(typeLabel);
        recieptPanel.add(typeValue);
        recieptPanel.add(amountLabel);
        recieptPanel.add(amountValue);
        recieptPanel.add(balanceLabel);
        recieptPanel.add(balanceValue);
        recieptPanel.add(line);
        recieptPanel.add(logo);
        recieptPanel.add(qr);
        recieptPanel.add(footer);
        recieptPanel.add(footer1);

        int targetY = 0;
        int speed = 4;

        javax.swing.Timer timer = new javax.swing.Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentY = recieptPanel.getY();
                if (currentY < targetY) {
                    recieptPanel.setLocation(0, currentY + speed);
                } else {
                    recieptPanel.setLocation(0, targetY);
                    ((javax.swing.Timer) e.getSource()).stop();
                }
            }
        });

        timer.start();
        add(recieptPanel);
    }

}