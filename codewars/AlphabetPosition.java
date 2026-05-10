import java.util.Scanner;

public class AlphabetPosition {

    public static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static String alphabetPosition(String text) {
        StringBuilder res = new StringBuilder();
        String loweredText = text.toLowerCase();
        for (char c : loweredText.toCharArray()) {
            if (isLetter(c)) {
                res.append(c - 'a' + 1);
                res.append(' ');
            }
        }
        return res.toString().trim();  // trim -> to remove extra space in the end
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            String res = alphabetPosition(input);
            System.out.println(res);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
