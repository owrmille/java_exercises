import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Character;

class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        List<Character> arr = s.codePoints().mapToObj(c -> (char)c).filter(Character::isLetterOrDigit).collect(Collectors.toList());
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            if (Character.toLowerCase(arr.get(left)) != Character.toLowerCase(arr.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        System.out.println("Is palindrome? Answer: " + isPalindrome(s));
        scanner.close();
    }
}