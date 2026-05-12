import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharactersInString {
    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();

        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        return freqMap;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            Map<Character, Integer> res = count(input);
            
            System.out.println(res);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
