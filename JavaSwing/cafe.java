package JavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cafe {
    public static void main(String[] args) {
        // Main Frame
        JFrame frame = new JFrame("Jolibee Cashier GUI");
        frame.setLayout(new GridLayout(0,3,10,10));
        
        // Side Menu
        JPanel sideMenuPanel = new JPanel();
        sideMenuPanel.setBackground(new Color(175, 175, 175));
        sideMenuPanel.setPreferredSize(new Dimension(300,400));
        
        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(175, 175, 175));
        mainPanel.setPreferredSize(new Dimension(300,400));
        mainPanel.setLayout(new GridLayout(0,3,10,10)); 

        // Image Box
        String[] images = {"Burger.jpg", "Pizza.jpg", "Fries.jpg"};
        double [] price = {5.99,10.99,2.99};
        for (int i = 0; i < images.length;i++) {
            String img = images[i];
                    
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setPreferredSize(new Dimension(125, 220));

            // lowerBox 
            JPanel lowerBox = new JPanel(new FlowLayout());

            ImageIcon icon = new ImageIcon("JavaSwing/swingImages/" + img);
            Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            String name = img.replace(".jpg", "").replace(".png", "");

            JLabel label = new JLabel(scaledIcon);
            label.setText("<html><center>" + name + "<br>$" + price[i] + "</center></html>");
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setPreferredSize(new Dimension(125,175));
            label.setOpaque(true);
            label.setBackground(Color.pink); 
            

            JButton plusButton = new JButton("+");
            plusButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    System.out.println("hey you click it");
                }
            });

            JButton minusButton = new JButton("-");
            
            lowerBox.add(plusButton);
            lowerBox.add(minusButton);

            itemPanel.add(label, BorderLayout.CENTER);
            itemPanel.add(lowerBox,BorderLayout.SOUTH);

            mainPanel.add(itemPanel);
        }
            
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