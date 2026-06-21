
public class TaskManager {
    // Node class for Singly Linked List
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public TaskManager() {
        head = null;
        size = 0;
    }

    // Add task at end - O(n)
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Added: " + task);
    }

    // Search task - O(n)
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse all - O(n)
    public void displayAll() {
        Node current = head;
        System.out.println("--- All Tasks ---");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete task - O(n)
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            size--;
            System.out.println("Deleted task: " + taskId);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found!");
        } else {
            current.next = current.next.next;
            size--;
            System.out.println("Deleted task: " + taskId);
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task(101, "Design UI", "Pending"));
        manager.addTask(new Task(102, "Implement Login", "In Progress"));
        manager.addTask(new Task(103, "Write Tests", "Pending"));

        manager.displayAll();

        System.out.println("\nSearch for 102: " + manager.searchTask(102));

        manager.deleteTask(102);

        System.out.println("\nAfter Deletion:");
        manager.displayAll();
    }
}