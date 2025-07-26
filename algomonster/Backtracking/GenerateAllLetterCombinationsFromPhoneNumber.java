import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GenerateAllLetterCombinationsFromPhoneNumber {
    private static String phoneDigits;
    private static List<String> res = new ArrayList<>();
    private static Map<Character, char[]> KEYBOARD = Map.of(
        '2', "abc".toCharArray(),
        '3', "def".toCharArray(),
        '4', "ghi".toCharArray(),
        '5', "jkl".toCharArray(),
        '6', "mno".toCharArray(),
        '7', "pqrs".toCharArray(),
        '8', "tuv".toCharArray(),
        '9', "wxyz".toCharArray()
    );

    public static void dfs(int startIndex, StringBuilder path) {
        if (startIndex == phoneDigits.length()) {
            res.add(path.toString());
            return;
        }
        char nextLetter = phoneDigits.charAt(startIndex);
        for (char letter : KEYBOARD.get(nextLetter)) {
            path.append(letter);
            dfs(startIndex + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        phoneDigits = digits;
        dfs(0, new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        scanner.close();
        List<String> res = letterCombinationsOfPhoneNumber(digits);
        System.out.println(String.join(" ", res));
    } 
}
