import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Define a class for the restaurant management system
class RestaurantManagement {
private static final String EMPLOYEE_PASSWORD = "password123";
private static ArrayList<MenuItem> menu = new ArrayList<>();
private static ArrayList<Employee> employees = new ArrayList<>();

public static void main(String[] args) {
    // Initialize the menu with some items
    menu.add(new MenuItem("Burger", 5.99));
    menu.add(new MenuItem("Pizza", 7.99));
    menu.add(new MenuItem("Salad", 4.99));

    // Initialize some employees
    employees.add(new Employee("John", "Doe", "Chef", 50000));
    employees.add(new Employee("Jane", "Doe", "Waiter", 30000));

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        System.out.println("Welcome to the Restaurant Management System!");
        System.out.println("Please choose an option:");
        System.out.println("1. Customer");
        System.out.println("2. Employee");
        System.out.println("3. Exit");

        int option = 0;
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again.");
            scanner.nextLine(); // consume the invalid input
            continue;
        }

        switch (option) {
            case 1:
                handleCustomer(scanner);
                break;
            case 2:
                handleEmployee(scanner);
                break;
            case 3:
                running = false;
                break;
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }
    }
}

private static void handleCustomer(Scanner scanner) {
    ArrayList<MenuItem> cart = new ArrayList<>();
    boolean ordering = true;

    while (ordering) {
        System.out.println("Here is the menu:");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + menu.get(i).getPrice());
        }

        System.out.println("Please enter the number of the item you would like to add to your cart (0 to finish):");

        int itemNumber = scanner.nextInt();
        if (itemNumber == 0) {
            ordering = false;
        } else if (itemNumber < 1 || itemNumber > menu.size()) {
            System.out.println("Invalid item number, please try again.");
        } else {
            cart.add(menu.get(itemNumber - 1));
        }
    }

    System.out.println("Here is your order summary:");

    double total = 0;
    for (int i = 0; i < cart.size(); i++) {
        System.out.println(cart.get(i).getName() + " - $" + cart.get(i).getPrice());
        total += cart.get(i).getPrice();
    }

    System.out.println("Total: $" + total);
    System.out.println("Thank you for your order!");

    boolean returningToMain = true;

    while (returningToMain) {
        System.out.println("Would you like to return to the main menu or exit? (1. Main menu, 2. Exit)");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                returningToMain = false;
                break;
            case 2:
                returningToMain = false;
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }
    }
}

private static void handleEmployee(Scanner scanner) {
    System.out.println("Please enter the employee password:");
    String password = scanner.next();

    if (!password.equals(EMPLOYEE_PASSWORD)) {
        System.out.println("Incorrect password, access denied.");
        return;
    }

    System.out.println("Here is the list of employees:");

    for (Employee employee : employees) {
        System.out.println(employee.getFullName() + " - " + employee.getRole() + " - $" + employee.getSalary());
    }

    System.out.println("Would you like to add a new employee? (1. Yes, 2. No)");

    int option = scanner.nextInt();

    if (option == 1) {
        System.out.println("Please enter the new employee's first name:");
        String firstName = scanner.next();

        System.out.println("Please enter the new employee's last name:");
        String lastName = scanner.next();

        System.out.println("Please enter the new employee's role:");
        String role = scanner.next();

        System.out.println("Please enter the new employee's salary:");
        double salary = scanner.nextDouble();

        employees.add(new Employee(firstName, lastName, role, salary));
        System.out.println("New employee added.");
    }
}
}

    