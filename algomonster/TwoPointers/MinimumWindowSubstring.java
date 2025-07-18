import java.util.HashMap;
import java.util.Scanner;

public class MinimumWindowSubstring {
    public static String minimumWindowSubstring(String original, String check) {
        HashMap<Character, Integer> checkCount = new HashMap<>();
        HashMap<Character, Integer> windowCount = new HashMap<>();
        for (int i = 0; i < check.length(); i++) {
            checkCount.merge(check.charAt(i), 1, Integer::sum);
        }
        int l = 0;
        int m = original.length();
        int windowStart = -1;
        int windowLength = m + 1;
        int required = checkCount.size();
        int satisfied = 0;
        for (int r = 0; r < m; r++) {
            windowCount.put(original.charAt(r), windowCount.getOrDefault(original.charAt(r), 0) + 1);
            if (windowCount.get(original.charAt(r)) == checkCount.get(original.charAt(r))) {
                satisfied++;
            }
            while (satisfied == required) {
                if (r - l + 1 < windowLength ||
                        (r - l + 1 == windowLength && 
                        original.substring(l, r + 1).compareTo(
                        original.substring(windowStart, windowStart + windowLength)) < 0)) {
                           windowStart = l;
                           windowLength = r - l + 1; 
                }
                windowCount.put(original.charAt(l), windowCount.get(original.charAt(l)) - 1);
                if (checkCount.containsKey(original.charAt(l)) && 
                    windowCount.get(original.charAt(l)) < checkCount.get(original.charAt(l))) {
                    satisfied--;
                }
                l++;
            }
        }
        return windowStart >= 0 ? original.substring(windowStart, windowStart + windowLength) : "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        String check = scanner.nextLine();
        System.out.println(minimumWindowSubstring(original, check));
        scanner.close();
    }
}