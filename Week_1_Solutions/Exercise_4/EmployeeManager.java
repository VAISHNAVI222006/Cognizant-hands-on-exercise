
public class EmployeeManager {
    private Employee[] employees;
    private int size;
    private static final int MAX_SIZE = 100;

    public EmployeeManager() {
        employees = new Employee[MAX_SIZE];
        size = 0;
    }

    // Add employee - O(1) amortized
    public void addEmployee(Employee emp) {
        if (size < MAX_SIZE) {
            employees[size++] = emp;
            System.out.println("Added: " + emp);
        } else {
            System.out.println("Array full!");
        }
    }

    // Search employee - O(n)
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all - O(n)
    public void displayAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee - O(n)
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            // Shift elements left
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null;
            System.out.println("Deleted employee with ID: " + employeeId);
        } else {
            System.out.println("Employee not found!");
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee(101, "Rahul", "Developer", 50000));
        manager.addEmployee(new Employee(102, "Priya", "Manager", 75000));
        manager.addEmployee(new Employee(103, "Amit", "Tester", 40000));

        System.out.println("\nAll Employees:");
        manager.displayAll();

        System.out.println("\nSearch for 102: " + manager.searchEmployee(102));

        manager.deleteEmployee(102);

        System.out.println("\nAfter Deletion:");
        manager.displayAll();
    }
}
