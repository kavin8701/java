import java.util.*;
import java.util.stream.Collectors;
public class MostRepeatedElement {
    public static void main(String[] args) {
        
    Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
 
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Optional<Integer> mostRepeated = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream() 
                .max(Map.Entry.comparingByValue()) 
                .map(Map.Entry::getKey); 
        
        if(mostRepeated.isPresent()) {
            System.out.println("Most repeated element: " + mostRepeated.get());
        } else {
            System.out.println("No elements found in the array.");
        }
        scanner.close();
    }
}
      