
public class OrderSorter {

    // Bubble Sort - O(n²)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort - O(n log n) average
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(101, "Rahul", 5000),
            new Order(102, "Priya", 15000),
            new Order(103, "Amit", 3000),
            new Order(104, "Sneha", 12000)
        };

        // Bubble Sort
        Order[] bubbleCopy = orders1.clone();
        bubbleSort(bubbleCopy);
        System.out.println("Bubble Sort Result:");
        for (Order o : bubbleCopy) System.out.println(o);

        // Quick Sort
        Order[] quickCopy = orders1.clone();
        quickSort(quickCopy, 0, quickCopy.length - 1);
        System.out.println("\nQuick Sort Result:");
        for (Order o : quickCopy) System.out.println(o);
    }
}