package Jolibee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(400,900));
        menuPanel.setBackground(Color.blue);
        JPanel menuWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT, 75, 50));
        menuWrapper.setOpaque(false);
        menuWrapper.add(menuPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.red);
        JPanel mainWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 100));
        mainWrapper.setOpaque(false);
        mainWrapper.add(mainPanel);
        JPanel layoutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        layoutPanel.setBackground(Color.pink);
        
        
        String[] images = {"Burger.jpg","Fries.jpg","Pizza.jpg","Pizza.jpg","Pizza.jpg","Burger.jpg","Fries.jpg","Pizza.jpg","Pizza.jpg","Pizza.jpg"};
        double[] price = {5.99,10.99,2.99,3.99,3.55,5.99,10.99,2.99,3.99,3.55};
        for (int i = 0; i < images.length; i++){
            String img = images[i];
            JPanel itemPanel = new JPanel(new BorderLayout());

            itemPanel.setPreferredSize(new Dimension(125,175));

            ImageIcon icon = new ImageIcon("Jolibee/Images/"+img);
            Image scaledIcon = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledImages = new ImageIcon(scaledIcon);
            String name = img.replace(".jpg","").replace(".png","");

            JLabel upperItem = new JLabel(scaledImages);

            upperItem.setText("<html><center>" + name + "<br>$" + price[i] + "</center></html>");
            upperItem.setVerticalTextPosition(JLabel.BOTTOM);
            upperItem.setHorizontalTextPosition(JLabel.CENTER);
            upperItem.setPreferredSize(new Dimension(100,140));

            JPanel lowerItem = new JPanel();

            JButton plus = new JButton("+");
            plus.addActionListener(e -> System.out.println("YOU CLICKED PLUS "));
            JButton minus = new JButton("-");
            minus.addActionListener(e -> System.out.println("YOU CLICKED MINUS "));

            lowerItem.add(plus);
            lowerItem.add(minus);
            itemPanel.add(upperItem,BorderLayout.CENTER);
            itemPanel.add(lowerItem,BorderLayout.SOUTH);
            layoutPanel.add(itemPanel);
        }
        
        layoutPanel.setPreferredSize(new Dimension(960, 1000));
        
        JScrollPane scroll = new JScrollPane(layoutPanel);
        scroll.setPreferredSize(new Dimension(980,780));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scroll, BorderLayout.CENTER);

        JPanel receiptPanel = new JPanel();
        receiptPanel.setPreferredSize(new Dimension(400,900));
        receiptPanel.setBackground(Color.yellow);

        JPanel receiptWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT,75,50));
        receiptWrapper.setOpaque(false);
        receiptWrapper.add(receiptPanel);

        frame.setLayout(new BorderLayout(50,10));
        frame.add(menuWrapper,BorderLayout.WEST);
        frame.add(mainWrapper,BorderLayout.CENTER);
        frame.add(receiptWrapper,BorderLayout.EAST);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}