# Week 1: Engineering Concepts

##  Overview

Week 1 covers **Algorithms data Structures** and **Design Patterns and Principles** - the foundation of software engineering.

---

##  All Exercises (10 Total)
Algorithms data structures 
| # | Exercise | Topic/Pattern | Folder |
|---|----------|---------------|--------|
| 1 | Inventory Management System | HashMap, O(1) operations | `Exercise1_InventoryManagement/` |
| 2 | E-commerce Platform Search | Linear & Binary Search | `Exercise2_EcommerceSearch/` |
| 3 | Sorting Customer Orders | Bubble Sort & Quick Sort | `Exercise3_SortingOrders/` |
| 4 | Employee Management System | Array operations | `Exercise4_EmployeeManagement/` |
| 5 | Task Management System | Singly Linked List | `Exercise5_TaskManagement/` |
| 6 | Library Management System | Linear & Binary Search | `Exercise6_LibraryManagement/` |
| 7 | Financial Forecasting | Recursive Algorithms | `Exercise7_FinancialForecasting/` |

Design patterns and Principles
| 1 | Singleton Pattern | Creational Pattern | `Exercise1_SingletonPattern/` |
| 2 | Factory Method Pattern | Creational Pattern | `Exercise2_FactoryMethodPattern/` |
| 3 | Builder Pattern | Creational Pattern | `Exercise3_BuilderPattern/` |

---

##  How to Run

Navigate to any exercise folder and run:

```bash
javac FileName.java
java FileName
```

---

##  Sample Outputs

### Exercise 1: Inventory Management System

```
Added: Product{ID=101, Name='Laptop', Qty=10, Price=75000.0}
Added: Product{ID=102, Name='Mouse', Qty=50, Price=500.0}
Added: Product{ID=103, Name='Keyboard', Qty=30, Price=1500.0}
Updated: Product{ID=102, Name='Mouse', Qty=60, Price=450.0}
Deleted: Product{ID=103, Name='Keyboard', Qty=30, Price=1500.0}

Search for 101: Product{ID=101, Name='Laptop', Qty=10, Price=75000.0}

All Products:
Product{ID=101, Name='Laptop', Qty=10, Price=75000.0}
Product{ID=102, Name='Mouse', Qty=60, Price=450.0}
```

---

### Exercise 2: E-commerce Platform Search

```
Linear Search (unsorted) - ID 102: Product{ID=102, Name='Keyboard', Category='Electronics'}
Linear Search (unsorted) - ID 999: null

Sorted products: [Product{ID=101, Name='Mouse', Category='Electronics'}, Product{ID=102, Name='Keyboard', Category='Electronics'}, Product{ID=103, Name='Laptop', Category='Electronics'}, Product{ID=104, Name='Phone', Category='Electronics'}, Product{ID=105, Name='Book', Category='Education'}]

Binary Search (sorted) - ID 104: Product{ID=104, Name='Phone', Category='Electronics'}
Binary Search (sorted) - ID 999: null
```

---

### Exercise 3: Sorting Customer Orders

```
Bubble Sort Result:
Order{ID=103, Customer='Amit', Total=₹3000.0}
Order{ID=101, Customer='Rahul', Total=₹5000.0}
Order{ID=104, Customer='Sneha', Total=₹12000.0}
Order{ID=102, Customer='Priya', Total=₹15000.0}

Quick Sort Result:
Order{ID=103, Customer='Amit', Total=₹3000.0}
Order{ID=101, Customer='Rahul', Total=₹5000.0}
Order{ID=104, Customer='Sneha', Total=₹12000.0}
Order{ID=102, Customer='Priya', Total=₹15000.0}
```

---

### Exercise 4: Employee Management System

```
Added: Employee{ID=101, Name='Rahul', Position='Developer', Salary=₹50000.0}
Added: Employee{ID=102, Name='Priya', Position='Manager', Salary=₹75000.0}
Added: Employee{ID=103, Name='Amit', Position='Tester', Salary=₹40000.0}

All Employees:
Employee{ID=101, Name='Rahul', Position='Developer', Salary=₹50000.0}
Employee{ID=102, Name='Priya', Position='Manager', Salary=₹75000.0}
Employee{ID=103, Name='Amit', Position='Tester', Salary=₹40000.0}

Search for 102: Employee{ID=102, Name='Priya', Position='Manager', Salary=₹75000.0}

Deleted employee with ID: 102

After Deletion:
Employee{ID=101, Name='Rahul', Position='Developer', Salary=₹50000.0}
Employee{ID=103, Name='Amit', Position='Tester', Salary=₹40000.0}
```

---

### Exercise 5: Task Management System

```
Added: Task{ID=101, Name='Design UI', Status='Pending'}
Added: Task{ID=102, Name='Implement Login', Status='In Progress'}
Added: Task{ID=103, Name='Write Tests', Status='Pending'}

--- All Tasks ---
Task{ID=101, Name='Design UI', Status='Pending'}
Task{ID=102, Name='Implement Login', Status='In Progress'}
Task{ID=103, Name='Write Tests', Status='Pending'}

Search for 102: Task{ID=102, Name='Implement Login', Status='In Progress'}

Deleted task: 102

After Deletion:
--- All Tasks ---
Task{ID=101, Name='Design UI', Status='Pending'}
Task{ID=103, Name='Write Tests', Status='Pending'}
```

---

### Exercise 6: Library Management System

```
Linear Search - '1984': Book{ID=101, Title='1984', Author='Orwell'}
Linear Search - 'Unknown': null

Sorted Books:
Book{ID=101, Title='1984', Author='Orwell'}
Book{ID=103, Title='Pride and Prejudice', Author='Austen'}
Book{ID=104, Title='The Catcher in the Rye', Author='Salinger'}
Book{ID=102, Title='The Great Gatsby', Author='Fitzgerald'}
Book{ID=105, Title='To Kill a Mockingbird', Author='Lee'}

Binary Search - 'Pride and Prejudice': Book{ID=103, Title='Pride and Prejudice', Author='Austen'}
Binary Search - 'Unknown': null
```

---

### Exercise 7: Financial Forecasting

```
Initial Investment: ₹100000.0
Annual Rate: 8.0%
Years: 10

Recursive Result: ₹215892.50
Time taken: 1200 ns

Iterative Result: ₹215892.50
Time taken: 500 ns

Memoization Result: ₹215892.50
```

---

### Exercise 1: Singleton Pattern

```
Logger instance created!
[LOG] Application started
[LOG] User logged in
Are both instances same? true
```

---

### Exercise 2: Factory Method Pattern

```
Opening Word Document...
Saving Word Document...
Closing Word Document...

Opening PDF Document...
Saving PDF Document...
Closing PDF Document...

Opening Excel Document...
Saving Excel Document...
Closing Excel Document...
```

---

### Exercise 3: Builder Pattern

```
Gaming PC: Computer{CPU='Intel i9', RAM='32GB', Storage='1TB NVMe SSD', GraphicsCard='NVIDIA RTX 4080', Bluetooth=true}
Office PC: Computer{CPU='Intel i5', RAM='16GB', Storage='512GB SSD', GraphicsCard='Integrated', Bluetooth=false}
Basic PC: Computer{CPU='Intel i3', RAM='8GB', Storage='256GB SSD', GraphicsCard='Integrated', Bluetooth=false}
```

---

##  Complexity Analysis

| Exercise | Best Time | Average Time | Worst Time |
|----------|-----------|--------------|------------|
| HashMap Operations | O(1) | O(1) | O(1) |
| Linear Search | O(1) | O(n) | O(n) |
| Binary Search | O(1) | O(log n) | O(log n) |
| Bubble Sort | O(n) | O(n²) | O(n²) |
| Quick Sort | O(n log n) | O(n log n) | O(n²) |
| Array Operations | O(1) | O(n) | O(n) |
| Linked List Operations | O(1) | O(n) | O(n) |
| Recursive (with memo) | O(1) | O(n) | O(n) |

---

##  Completion Status

| # | Exercise | Status |
|---|----------|--------|
| 1 | Inventory Management System | ✅ |
| 2 | E-commerce Platform Search | ✅ |
| 3 | Sorting Customer Orders | ✅ |
| 4 | Employee Management System | ✅ |
| 5 | Task Management System | ✅ |
| 6 | Library Management System | ✅ |
| 7 | Financial Forecasting | ✅ |
| 1 | Singleton Pattern | ✅ |
| 2 | Factory Method Pattern | ✅ |
| 3 | Builder Pattern | ✅ |

---

##  Key Takeaways

- **HashMap** → O(1) operations for fast access
- **Binary Search** → O(log n) faster than Linear Search O(n)
- **Quick Sort** → O(n log n) faster than Bubble Sort O(n²)
- **Singleton** → Only one instance of a class
- **Factory Method** → Create objects without specifying exact class
- **Builder** → Step-by-step creation of complex objects

---
