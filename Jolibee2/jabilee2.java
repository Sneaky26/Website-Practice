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

public class jabilee2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel menuPanel = createPanel(300,800, Color.red);
        JPanel mainPanel = createPanel(900,700, Color.pink);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,60,40));
        JPanel receiptPanel = createPanel(400, 800, Color.gray);

        String [] images = {"Pizza.jpg","Fries.jpg","Burger.jpg"};
        double [] price = {9.99, 3.99, 5.99};
        
        for (int i = 0; i < images.length ; i++){
            String imagePath = "Jolibee2/Images/" + images[i];
            String name = images[i].replace(".jpg","").replace(".png","");

            JPanel itemBox = createItemBox(imagePath,name,price[i],receiptPanel);
            
            mainPanel.add(itemBox);
        }
         
        
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,75,100));
        frame.add(menuPanel);
        frame.add(mainPanel);
        frame.add(receiptPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("Cashier GUI");
        frame.setVisible(true);
    }

    // Recycle Panel
    public static JPanel createPanel(int width, int height, Color color){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width,height));
        panel.setBackground(color); 

        return panel;
    }
    // UPDATE RECEIPT
    private static void updateReceiptLabel(JLabel receiptDetail,JLabel totalCost,ImageIcon icon,int qty, String name, double price){
        TransactionDetail td = new TransactionDetail(qty, name, price);
        receiptDetail.setIcon(icon);
        receiptDetail.setText(td.getQuantity() + "x " + td.getName() + " $" + td.getPrice());
        receiptDetail.setVisible(true);

        totalCost.setText("Total: $" + String.format("%.2f", td.getTotal()));
        totalCost.setVisible(true);
    }
    
    // CREATE ITEM BOX
    public static JPanel createItemBox(String imagePath, String name, double price, JPanel receiptPanel){
        JPanel itemBox = new JPanel(new BorderLayout());
        itemBox.setPreferredSize(new Dimension(150,200));

        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledIcon = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledImages = new ImageIcon(scaledIcon);

        // UpperBox
        JLabel upperBox = new JLabel(scaledImages);
        upperBox.setText("<html><center>Name: " + name + "<br>Price: $" + price + "</center></html>");
        upperBox.setVerticalTextPosition(JLabel.BOTTOM);
        upperBox.setHorizontalTextPosition(JLabel.CENTER);
        
        // Lower Box
        JTextField quantity = new JTextField(2);
        quantity.setPreferredSize(new Dimension(50,25));
        quantity.setHorizontalAlignment(JTextField.CENTER);
            
        final int[] num = {0};

        // receipt detail
        JLabel receiptDetail = new JLabel();
        receiptDetail.setForeground(Color.WHITE);
        JLabel totalCost = new JLabel();
        totalCost.setForeground(Color.WHITE);

        receiptPanel.add(receiptDetail);
        receiptPanel.add(totalCost);

        // minus
        JButton minus = new JButton("-");
        JButton plus = new JButton("+");

        minus.setBackground(Color.red);
        minus.addActionListener(e ->{
            if (num[0] <= 0){
                minus.setEnabled(false);
                receiptDetail.setVisible(false);
                totalCost.setVisible(false);
            } else {
                num[0]--;
                plus.setEnabled(true);
                quantity.setText(String.valueOf(num[0]));
                updateReceiptLabel(receiptDetail,totalCost,scaledImages,Integer.parseInt(quantity.getText()), name, price);
            }
        });
        
        // plus
        plus.setBackground(Color.green);
        plus.addActionListener(e -> {
            if (num[0] >= 20){
                plus.setEnabled(false);
            } else {
                num[0]++;
                minus.setEnabled(true);
                quantity.setText(String.valueOf(num[0]));
                updateReceiptLabel(receiptDetail,totalCost,scaledImages, Integer.parseInt(quantity.getText()), name, price);
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

        // Lower Box
        JPanel lowerBox = new JPanel();
        lowerBox.add(plus);
        lowerBox.add(quantity);
        lowerBox.add(minus);
            
        itemBox.add(upperBox,BorderLayout.CENTER);
        itemBox.add(lowerBox,BorderLayout.SOUTH);

        return itemBox;
    }
}

