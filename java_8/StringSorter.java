import java.util.*;
import java.util.stream.Collectors;
 
public class StringSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
 
        List<String> strings = new ArrayList<>();
 
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings.add(scanner.nextLine());
        }
 
        List<String> ascendingOrder = strings.stream()
                .sorted()
                .collect(Collectors.toList());
 
        List<String> descendingOrder = strings.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("\nStrings in Ascending Order:");
        ascendingOrder.forEach(System.out::println);
 
        System.out.println("\nStrings in Descending Order:");
        descendingOrder.forEach(System.out::println);
        scanner.close();
    }
}