
import java.util.Arrays;

public class LibraryManager {

    // Linear Search by Title - O(n)
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search by Title - O(log n) - Array must be sorted by title
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare = books[mid].getTitle().compareToIgnoreCase(title);

            if (compare == 0) {
                return books[mid];
            }
            if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Sort books by title
    public static void sortByTitle(Book[] books) {
        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(103, "The Great Gatsby", "Fitzgerald"),
            new Book(101, "1984", "Orwell"),
            new Book(105, "To Kill a Mockingbird", "Lee"),
            new Book(102, "Pride and Prejudice", "Austen"),
            new Book(104, "The Catcher in the Rye", "Salinger")
        };

        // Linear Search (unsorted)
        System.out.println("Linear Search - '1984': " + linearSearch(books, "1984"));
        System.out.println("Linear Search - 'Unknown': " + linearSearch(books, "Unknown"));

        // Binary Search (sorted)
        sortByTitle(books);
        System.out.println("\nSorted Books:");
        for (Book b : books) System.out.println(b);

        System.out.println("\nBinary Search - 'Pride and Prejudice': " + binarySearch(books, "Pride and Prejudice"));
        System.out.println("Binary Search - 'Unknown': " + binarySearch(books, "Unknown"));
    }
}