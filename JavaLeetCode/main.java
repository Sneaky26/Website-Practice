import java.util.Scanner;

/* 
    Leader:
    Justine B. Dimla
    Members:
    Nyle Adriel Dalay
    Miguel Adrian Cortez
    Franz G. Mamangon
    John Philip Miguel Lorenzo
*/ 

// ==================== PART 1 & 2: Book Classes ====================

class Book {
    String title, author;
    private float price;
    
    Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    void displayDetails() {
        System.out.println("==================");
        System.out.println("Book Description");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("==================");
    }
    
    void applyDiscount(float percentage) {
        price = price - (price * percentage / 100);
    }
}

class Ebook extends Book {
    float fileSize;
    
    Ebook(String title, String author, float price, float fileSize) {
        super(title, author, price);
        this.fileSize = fileSize;
    }
    
    @Override
    void displayDetails() {
        System.out.println("==================");
        System.out.println("E-Book Description");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + getPrice());
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("==================");
    }
}

// ==================== PART 3: Abstract Classes and Interfaces ====================

abstract class Shape {
    abstract float calculateArea();
    
    void displayShapeType() {
        System.out.println("Shape type: " + this.getClass().getSimpleName());
    }
}

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    float radius;
    
    Circle(float radius) {
        this.radius = radius;
    }
    
    @Override
    float calculateArea() {
        return 3.14f * radius * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }
}

class Rectangle extends Shape implements Drawable {
    float length, width;
    
    Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    float calculateArea() {
        return length * width;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with length: " + length + " and width: " + width);
    }
}

// ==================== MAIN CLASS ====================

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("\n========== IT206 Assignment Menu ==========");
            System.out.println("[1] Create and Manage Book");
            System.out.println("[2] Create and Manage E-Book");
            System.out.println("[3] Work with Shapes");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");
            option = input.nextInt();
            input.nextLine();
            System.out.println();
            
            switch (option) {
                case 1:
                    handleBook(input);
                    break;
                case 2:
                    handleEbook(input);
                    break;
                case 3:
                    handleShapes(input);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
        
        input.close();
    }
    
    static void handleBook(Scanner input) {
        String title, author;
        float price, discount;
        String choice;
        
        System.out.println("You have selected Create and Manage Book!");
        System.out.print("Enter book title: ");
        title = input.nextLine();
        
        System.out.print("Enter author name: ");
        author = input.nextLine();
        
        System.out.print("Enter price: $");
        price = input.nextFloat();
        input.nextLine();
        
        Book book = new Book(title, author, price);
        
        System.out.println("\nBook created successfully!");
        book.displayDetails();
        
        System.out.print("\nDo you want to apply a discount? (y/n): ");
        choice = input.nextLine();
        
        if (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter discount percentage: ");
            discount = input.nextFloat();
            input.nextLine();
            
            book.applyDiscount(discount);
            System.out.println("\nAfter applying " + discount + "% discount:");
            book.displayDetails();
        }
    }
    
    static void handleEbook(Scanner input) {
        String title, author;
        float price, fileSize, discount;
        String choice;

        System.out.println("You have selected Create and Manage E-Book!");
        System.out.print("Enter e-book title: ");
        title = input.nextLine();
        
        System.out.print("Enter author name: ");
        author = input.nextLine();
        
        System.out.print("Enter price: $");
        price = input.nextFloat();
        
        System.out.print("Enter file size (MB): ");
        fileSize = input.nextFloat();
        input.nextLine();
        
        Ebook ebook = new Ebook(title, author, price, fileSize);
        
        System.out.println("\nE-Book created successfully!");
        ebook.displayDetails();
        
        System.out.print("\nDo you want to apply a discount? (y/n): ");
        choice = input.nextLine();
        
        if (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter discount percentage: ");
            discount = input.nextFloat();
            input.nextLine();
            
            ebook.applyDiscount(discount);
            System.out.println("\nAfter applying " + discount + "% discount:");
            ebook.displayDetails();
        }
    }
    
    static void handleShapes(Scanner input) {
        int shapeChoice;
        float radius, length, width;
        
        System.out.println("You have selected Work With Shapes!");
        System.out.println("Choose a shape:");
        System.out.println("[1] Circle");
        System.out.println("[2] Rectangle");
        System.out.print("Enter choice: ");
        shapeChoice = input.nextInt();
        input.nextLine();
        
        if (shapeChoice == 1) {
            System.out.print("Enter radius: ");
            radius = input.nextFloat();
            input.nextLine();
            
            Circle circle = new Circle(radius);
            System.out.println();
            circle.displayShapeType();
            System.out.println("Area: " + circle.calculateArea());
            circle.draw();
            
        } else if (shapeChoice == 2) {
            System.out.print("Enter length: ");
            length = input.nextFloat();
            
            System.out.print("Enter width: ");
            width = input.nextFloat();
            input.nextLine();
            
            Rectangle rectangle = new Rectangle(length, width);
            System.out.println();
            rectangle.displayShapeType();
            System.out.println("Area: " + rectangle.calculateArea());
            rectangle.draw();
            
        } else {
            System.out.println("Invalid choice!");
        }
    }
}