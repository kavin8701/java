import java.util.Scanner;
import java.util.function.Function;
 
public class WordCounter {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
 
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
 
        Function<String, Integer> wordCount = (String s) -> {
            if (s == null || s.trim().isEmpty()) {
                return 0;
            }
            return s.trim().split("\\s+").length;
        };
 
        int count = wordCount.apply(sentence);
        System.out.println("Number of words in the sentence: " + count);
        scanner.close();
    }
}