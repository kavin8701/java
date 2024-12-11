import java.util.HashMap;
import java.util.Map;
 
public class Restaurant {
    private Map<String, Double> menuItems;
    private Map<String, Double> itemRatings;
    
    public Restaurant() {
        menuItems = new HashMap<>();
        itemRatings = new HashMap<>();
    }
 
    // adding item
    public void addItem(String itemName, double price, double rating) {
        menuItems.put(itemName, price);
        itemRatings.put(itemName, rating);
    }
 
    // removing an item
    public void removeItem(String itemName) {
        menuItems.remove(itemName);
        itemRatings.remove(itemName);
    }
 
    // calculating average rating
    public double calculateAverageRating() {
        if (itemRatings.isEmpty()) {
            return 0.0;
        }
 
        double totalRating = 0.0;
        for (double rating : itemRatings.values()) {
            totalRating += rating;
        }
 
        return totalRating / itemRatings.size();
    }
 
    // display
    public void displayMenu() {
        System.out.println("Menu:");
        for (Map.Entry<String, Double> entry : menuItems.entrySet()) {
            String itemName = entry.getKey();
            double price = entry.getValue();
            double rating = itemRatings.getOrDefault(itemName, 0.0);
            System.out.printf("Item: %s, Price: $%.2f, Rating: %.1f%n", itemName, price, rating);
        }
    }
 
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        
        restaurant.addItem("Burger", 8.99, 4.5);
        restaurant.addItem("Pizza", 12.99, 4.7);
        restaurant.addItem("Salad", 6.99, 4.0);
        
        restaurant.displayMenu();
        
        double avgRating = restaurant.calculateAverageRating();
        System.out.printf("Average Rating: %.1f%n", avgRating);
        
        restaurant.removeItem("Salad");
        
        System.out.println("\nMenu after removing Salad:");
        restaurant.displayMenu();
        
        avgRating = restaurant.calculateAverageRating();
        System.out.printf("Average Rating after removal: %.1f%n", avgRating);
    }
}