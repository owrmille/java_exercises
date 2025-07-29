import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordBreak {
    public static boolean dfs(int startIndex, Boolean[] memo, String s, List<String> words) {
        if (startIndex == s.length()) return true;
        if (memo[startIndex] != null) return memo[startIndex];
        boolean ans = false;
        for (String word : words) {
            if (s.startsWith(word, startIndex)) {
                ans = ans || dfs(startIndex + word.length(), memo, s, words);
            }
        }
        memo[startIndex] = ans;
        return ans;
    }

    public static boolean wordBreak(String s, List<String> words) {
        return dfs(0, new Boolean[s.length()], s, words);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> words = splitWords(scanner.nextLine());
        scanner.close();
        boolean res = wordBreak(s, words);
        System.out.println(res);
    }    
}
