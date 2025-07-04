import java.util.HashMap;
import java.util.Scanner;

class LongestSubstringWithoutRepeat {
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int longest = 0;
        int left = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (window.get(s.charAt(right)) > 1) {
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        System.out.println("Output: " + longestSubstringWithoutRepeatingCharacters(scanner.nextLine()));
        scanner.close();
    }
}
