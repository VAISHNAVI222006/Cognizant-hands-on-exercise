// Product.java - Complete runnable version
public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{ID=" + productId + ", Name='" + productName + "', Qty=" + quantity + ", Price=" + price + "}";
    }

    // ✅ MAIN METHOD ADDED - NOW YOU CAN RUN THIS FILE
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 10, 75000);
        Product p2 = new Product(102, "Mouse", 50, 500);
        
        System.out.println(p1);
        System.out.println(p2);
        
        // Test setter
        p1.setQuantity(15);
        System.out.println("\nAfter update:");
        System.out.println(p1);
    }
}