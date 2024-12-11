import java.util.Scanner;
import java.util.function.Function;
 
public class BinaryConverter {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
 
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
 
        Function<Integer, String> toBinary = (Integer n) -> Integer.toBinaryString(n);
 
        String binaryRepresentation = toBinary.apply(number);
        System.out.println("Binary representation: " + binaryRepresentation);
        scanner.close();
    }
}