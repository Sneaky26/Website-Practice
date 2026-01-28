package JavaSwing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cafe {
    public static void main(String[] args) {
        // Main Frame
        JFrame frame = new JFrame("Jolibee Cashier GUI");
        frame.setLayout(null);
        
        // Side Menu
        JPanel sideMenuPanel = new JPanel();
        sideMenuPanel.setBackground(new Color(175, 175, 175));
        sideMenuPanel.setBounds(50, 100, 400, 850);
        
        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(175, 175, 175));
        mainPanel.setBounds(500, 100, 925, 850);
        mainPanel.setLayout(null); 
        
        // Item Box (inside mainPanel)
        JPanel itemBox = new JPanel();
        itemBox.setBackground(new Color(230, 230, 230));
        itemBox.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        itemBox.setBounds(50, 50, 825, 750); 
        
        // Image Box
        String[] images = {"Burger.jpg", "Pizza.jpg", "Fries.jpg"};
        double [] price = {5.99,10.99,2.99};
        for (int i = 0; i < images.length;i++) {
            
            String img = images[i];
            ImageIcon icon = new ImageIcon("JavaSwing/swingImages/" + img);
            Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            String name = img.replace(".jpg", "").replace(".png", "");

            JLabel label = new JLabel(scaledIcon);
            label.setText("<html><center>" + name + "<br>$" + price[i] + "</center></html>");
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);

            label.setOpaque(true);
            label.setBackground(Color.WHITE); 
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            itemBox.add(label);
        }
        
        mainPanel.add(itemBox); 
        
        // Receipt Panel
        JLabel receiptLabel = new JLabel("Receipt List");
        receiptLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel receiptPanel = new JPanel();
        receiptPanel.setBackground(new Color(175, 175, 175));
        receiptPanel.setBounds(1475, 100, 400, 850);
        receiptPanel.add(receiptLabel);
        
        frame.add(sideMenuPanel);
        frame.add(mainPanel);
        frame.add(receiptPanel);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}