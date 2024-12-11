import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class Order {
    //menu items, prices, ratings, and availability
    private Map<String, Double> menuItems = new HashMap<>();
    private Map<String, Double> itemRatings = new HashMap<>();
    private Map<String, Boolean> itemAvailability = new HashMap<>();
    private Map<String, String> itemFeedback = new HashMap<>();
 
    // Method to add a menu item with price, rating, and availability
    public void addItem(String itemName, double price, double rating, boolean available) {
        menuItems.put(itemName, price);
        itemRatings.put(itemName, rating);
        itemAvailability.put(itemName, available);
        System.out.println(itemName + " added to the menu.");
    }
 
    // Method to remove a menu item
    public void removeItem(String itemName) {
        if (menuItems.containsKey(itemName)) {
            menuItems.remove(itemName);
            itemRatings.remove(itemName);
            itemAvailability.remove(itemName);
            itemFeedback.remove(itemName);
            System.out.println(itemName + " removed from the menu.");
        } else {
            System.out.println(itemName + " not found on the menu.");
        }
    }
 
    // Method to calculate the average rating of the menu items
    public double calculateAverageRating() {
        if (itemRatings.isEmpty()) {
            System.out.println("No ratings available.");
            return 0.0;
        }
        double totalRating = 0.0;
        for (double rating : itemRatings.values()) {
            totalRating += rating;
        }
        return totalRating / itemRatings.size();
    }
 
    // Method to show the discounted price of the menu items
    public void showDiscountedPrices(double discountPercentage) {
        System.out.println("Today's special offer!!!");
        System.out.println("Discounted Menu:");
        for (Map.Entry<String, Double> entry : menuItems.entrySet()) {
            String itemName = entry.getKey();
            double originalPrice = entry.getValue();
            double discountedPrice = originalPrice - (originalPrice * discountPercentage / 100);
            boolean available = itemAvailability.getOrDefault(itemName, false);
            String availability = available ? "Available" : "Not Available";
            System.out.printf("Item: %s, Original Price: $%.2f, Discounted Price: $%.2f, %s%n", itemName, originalPrice, discountedPrice, availability);
        }
    }
 
    // Method to display the menu with availability
    public void displayMenu() {
        System.out.println("Menu:");
        for (Map.Entry<String, Double> entry : menuItems.entrySet()) {
            String itemName = entry.getKey();
            double price = entry.getValue();
            double rating = itemRatings.getOrDefault(itemName, 0.0);
            boolean available = itemAvailability.getOrDefault(itemName, false);
            String availability = available ? "Available" : "Not Available";
            System.out.printf("Item: %s, Price: $%.2f, Rating: %.1f, %s%n", itemName, price, rating, availability);
        }
    }
 
    // Method to gather feedback for an item
    public void getFeedback(String itemName, String feedback) {
        if (menuItems.containsKey(itemName)) {
            itemFeedback.put(itemName, feedback);
            System.out.println("Feedback received for " + itemName);
        } else {
            System.out.println("Item not found on the menu.");
        }
    }
 
    // Main method to interact with the user
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Order restaurant = new Order();
        boolean exit = false;
 
        while (!exit) {
            System.out.println("\nABC HOTEL");
            System.out.println("1. Add menu item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. Display Menu");
            System.out.println("4. Calculate Average Rating");
            System.out.println("5. Show Discounted Prices");
            System.out.println("6. Give Feedback");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
 
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter rating (0.0 to 5.0): ");
                    double rating = scanner.nextDouble();
                    System.out.print("Is the item available? (true/false): ");
                    boolean available = scanner.nextBoolean();
                    restaurant.addItem(itemName, price, rating, available);
                    break;
 
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    restaurant.removeItem(itemToRemove);
                    break;
 
                case 3:
                    restaurant.displayMenu();
                    break;
 
                case 4:
                    System.out.printf("Average Rating: %.2f%n", restaurant.calculateAverageRating());
                    break;
 
                case 5:
                    System.out.print("Enter discount percentage: ");
                    double discount = scanner.nextDouble();
                    restaurant.showDiscountedPrices(discount);
                    break;
 
                case 6:
                    System.out.print("Enter item name to give feedback: ");
                    String feedbackItem = scanner.nextLine();
                    System.out.print("Enter your feedback: ");
                    String feedback = scanner.nextLine();
                    restaurant.getFeedback(feedbackItem, feedback);
                    break;
 
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}