
import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add product - O(1)
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    // Update product - O(1)
    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated: " + product);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete product - O(1)
    public void deleteProduct(int productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Search product - O(1)
    public Product searchProduct(int productId) {
        return inventory.get(productId);
    }

    // Display all products - O(n)
    public void displayAll() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 10, 75000));
        manager.addProduct(new Product(102, "Mouse", 50, 500));
        manager.addProduct(new Product(103, "Keyboard", 30, 1500));

        manager.updateProduct(102, 60, 450);
        manager.deleteProduct(103);

        System.out.println("\nSearch for 101: " + manager.searchProduct(101));

        System.out.println("\nAll Products:");
        manager.displayAll();
    }
}