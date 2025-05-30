import java.util.ArrayList;
import java.util.Scanner;

// Item class
class Item {
    private String name;
    private String description;
    private double unitPrice;
    private int quantityAvailable;

    public Item(String name, String description, double unitPrice, int quantityAvailable) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityAvailable = quantityAvailable;
    }

    public void updateQuantity(int amount) {
        this.quantityAvailable += amount;
    }

    public void printDetails() {
        System.out.println("Item Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity Available: " + quantityAvailable);
    }

    public String getName() {
        return name;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }
}

// Customer class
class Customer {
    private String name;
    private String contactDetails;

    public Customer(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public void printDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Contact Details: " + contactDetails);
    }

    public String getName() {
        return name;
    }
}

// Database class
class Database {
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public void updateItemQuantity(String itemName, int amount) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.updateQuantity(amount);
                return;
            }
        }
    }

    public void searchItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                item.printDetails();
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void listItems() {
        for (Item item : items) {
            item.printDetails();
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void listCustomers() {
        for (Customer customer : customers) {
            customer.printDetails();
        }
    }

    public void searchCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                customer.printDetails();
                return;
            }
        }
        System.out.println("Customer not found.");
    }
}

// Main application
public class InventoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        while (true) {
            System.out.println("------ Inventory Management ------");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. List All Items");
            System.out.println("5. Add Customer");
            System.out.println("6. List All Customers");
            System.out.println("7. Search Item by Name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter unit price: ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Enter quantity available: ");
                    int quantityAvailable = scanner.nextInt();
                    database.addItem(new Item(name, description, unitPrice, quantityAvailable));
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    database.removeItem(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter quantity change: ");
                    int amount = scanner.nextInt();
                    database.updateItemQuantity(itemName, amount);
                    break;
                case 4:
                    database.listItems();
                    break;
                case 5:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter contact details: ");
                    String contactDetails = scanner.nextLine();
                    database.addCustomer(new Customer(customerName, contactDetails));
                    break;
                case 6:
                    database.listCustomers();
                    break;
                case 7:
                    System.out.print("Enter item name to search: ");
                    database.searchItem(scanner.nextLine());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
