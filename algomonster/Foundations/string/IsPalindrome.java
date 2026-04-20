import java.util.Scanner;

public class IsPalindrome {
    public static boolean isPalindrome(String input) {
        int len = input.length() - 1;
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome_upd(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return reversed.equals(input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        boolean res = isPalindrome_upd(input);
        System.out.println(res);
    }    
}