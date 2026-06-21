
import java.util.Arrays;

public class SearchEngine {

    // Linear Search - O(n)
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.getProductId() == targetId) {
                return p;
            }
        }
        return null;
    }

    // Binary Search - O(log n) - Array must be sorted by productId
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return products[mid];
            }
            if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Helper to sort products by ID
    public static void sortById(Product[] products) {
        Arrays.sort(products, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(103, "Laptop", "Electronics"),
            new Product(101, "Mouse", "Electronics"),
            new Product(105, "Book", "Education"),
            new Product(102, "Keyboard", "Electronics"),
            new Product(104, "Phone", "Electronics")
        };

        // Unsorted array for linear search
        System.out.println("Linear Search (unsorted) - ID 102: " + linearSearch(products, 102));
        System.out.println("Linear Search (unsorted) - ID 999: " + linearSearch(products, 999));

        // Sort for binary search
        sortById(products);
        System.out.println("\nSorted products: " + Arrays.toString(products));

        System.out.println("Binary Search (sorted) - ID 104: " + binarySearch(products, 104));
        System.out.println("Binary Search (sorted) - ID 999: " + binarySearch(products, 999));
    }
}