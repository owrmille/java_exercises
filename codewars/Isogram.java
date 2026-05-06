import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Isogram {
    public static boolean isIsogram(String str) {
        Map<Character, Integer> freqDict = new HashMap<>();

        String lowered = str.toLowerCase();

        for (int i = 0; i < lowered.length(); i++) {
            char letter = lowered.charAt(i);
            freqDict.put(letter, freqDict.getOrDefault(letter, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freqDict.entrySet()) {
            if (entry.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        System.out.println(isIsogram(str));
    }
}
