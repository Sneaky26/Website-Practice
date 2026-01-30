package Jolibee2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TransactionDetail{
    final int quantity;
    final String name;
    final double price;
    TransactionDetail(int quantity, String name, double price){
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }
    int getQuantity(){return quantity;}
    String getName(){return name;}
    double getPrice(){return price;}

    public double getTotal(){
        return quantity * price;
    }
}

public class jabilee {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        // Menu
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(300,800));
        menuPanel.setBackground(Color.red); 
        JPanel menuPanelWrapper = new JPanel(new FlowLayout());
        menuPanelWrapper.add(menuPanel);

        // Main
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,60,40));
        mainPanel.setPreferredSize(new Dimension(900,700));
        mainPanel.setBackground(Color.pink);
        JPanel mainPanelWrapper = new JPanel(new FlowLayout());
        mainPanelWrapper.add(mainPanel);

        // Receipt
        JPanel receiptPanel = new JPanel(new FlowLayout());
        receiptPanel.setPreferredSize(new Dimension(400,800));
        receiptPanel.setBackground(Color.gray);
        JPanel receiptPanelWrapper = new JPanel(new FlowLayout());
        receiptPanelWrapper.add(receiptPanel);


        String [] images = {"Pizza.jpg","Fries.jpg","Burger.jpg"};
        double [] price = {9.99, 3.99, 5.99};
        
        for (int i = 0; i < images.length ; i++){
            String img = images[i];
            final int index = i;

            JPanel itemBox = new JPanel(new BorderLayout());
            itemBox.setPreferredSize(new Dimension(150,200));

            ImageIcon icon = new ImageIcon("Jolibee2/Images/" + img);
            Image scaledIcon = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledImages = new ImageIcon(scaledIcon);
            
            String name = img.replace(".jpg","").replace(".png","");
            
            // UpperBox
            JLabel upperBox = new JLabel(scaledImages);
            upperBox.setText("<html><center>Name: " + name + "<br>Price: $" + price[i] + "</center></html>");
            upperBox.setVerticalTextPosition(JLabel.BOTTOM);
            upperBox.setHorizontalTextPosition(JLabel.CENTER);

            // Lower Box
            JTextField quantity = new JTextField(2);
            quantity.setPreferredSize(new Dimension(50,25));
            quantity.setHorizontalAlignment(JTextField.CENTER);

            final int[] num = {0};

            JLabel receiptDetail = new JLabel();
            receiptDetail.setForeground(Color.WHITE);
            JLabel totalCost = new JLabel();
            totalCost.setForeground(Color.WHITE);

            JButton minus = new JButton("-");
            minus.setBackground(Color.red);
            minus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if (num[0] > 0){
                        num[0]--;
                        String text = Integer.toString(num[0]);
                        TransactionDetail transactionDetails = new TransactionDetail(num[0], name, price[index]);
                        receiptDetail.setIcon(scaledImages);
                        receiptDetail.setText(transactionDetails.getQuantity()+ "x Name: " + transactionDetails.getName()+ " Price: "+ transactionDetails.getPrice());
                        String total = Double.toString(transactionDetails.getTotal());
                        totalCost.setText("Total Cost: " + total);
                        receiptPanel.add(receiptDetail);
                        receiptPanel.add(totalCost);
                        quantity.setText(text);
                        if (num[0] == 0){
                            minus.setEnabled(false);
                            receiptDetail.setVisible(false);
                        }
                    }       
                }
            });
            
            JButton plus = new JButton("+");
            plus.setBackground(Color.green);
            plus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){           
                    num[0]++;
                    receiptDetail.setVisible(true);
                    String text = Integer.toString(num[0]);
                    quantity.setText(text); 
                    minus.setEnabled(true);
                    TransactionDetail transactionDetails = new TransactionDetail(num[0], name, price[index]);
                    receiptDetail.setText(transactionDetails.getQuantity()+ "x Name: " + transactionDetails.getName()+ " Price: $"+ transactionDetails.getPrice());
                    String total = Double.toString(transactionDetails.getTotal());
                    totalCost.setText("Total Cost: $" + total);
                    receiptPanel.add(receiptDetail);
                    receiptPanel.add(totalCost);     
                }
            });

            // Quantity Limiter
            quantity.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (quantity.getText().length() >= 2) {
                    e.consume(); 
                }
            }   
            });

            JPanel lowerBox = new JPanel();
            lowerBox.add(plus);
            lowerBox.add(quantity);
            lowerBox.add(minus);
            
            itemBox.add(upperBox,BorderLayout.CENTER);
            itemBox.add(lowerBox,BorderLayout.SOUTH);
            
            mainPanel.add(itemBox);
        }
         

        
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,75,100));
        frame.add(menuPanelWrapper);
        frame.add(mainPanelWrapper);
        frame.add(receiptPanelWrapper);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Cashier GUI");
        frame.setVisible(true);
    }
}
