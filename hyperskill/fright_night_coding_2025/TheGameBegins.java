import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TheGameBegins {
   public static void main(String[] args) {
    try (Scanner scanner = new Scanner(new File("datasets/hyperskill-dataset-117336623.txt"))) {
        String input = scanner.next();
        List<String> letters = Arrays.asList(input.split(""));
        Map<String, Integer> lettersMap = new HashMap<>();
        List<String> alphabet = Arrays.asList(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                                    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"});
        for (int i = 0; i < alphabet.size(); i++) {
            lettersMap.put(alphabet.get(i), 0);
        }
        for (int i = 0; i < letters.size(); i++) {
            lettersMap.put(letters.get(i), lettersMap.get(letters.get(i)) + 1);
        }
        for (int i = 0; i < alphabet.size(); i++) {
            if (lettersMap.get(alphabet.get(i)) == 1) {
                System.out.print(alphabet.get(i) + " -> ");
                System.out.println(lettersMap.get(alphabet.get(i)));
            }
        }

        // letters.stream().forEach(System.out::print);
        // Set<String> uniqueLetters = new HashSet<>(letters);
        // uniqueLetters.stream().forEach(System.out::print);
        
        // List<Character> chars = input.chars().mapToObj(c -> (char)c).toList();
        // // chars.stream().forEach(System.out::print);
        // List<Character> uniqueChars = chars.stream().distinct().collect(Collectors.toList());
        // uniqueChars.stream().forEach(System.out::print);
    } catch (Exception e) {
        System.err.println("Error!");
    }
   }
}
