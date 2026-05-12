
import java.util.Scanner;

public class FindMissingLetter {
    public static char findMissingLetter(char[] array) {
        char prev = array[0];
        for (char c : array) {
            if (Math.abs(c - prev) > 1) {
                return (char) (prev+1);  // ++prev also works (it: 1.increments val as char 2.returns it)
            }
            prev = c;
        }
        return prev;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // expected input: ['a', 'b', 'c', 'd', 'f']
            String input = scanner.nextLine();

            input = input.replaceAll("[\\[\\]',\\s]", "");
            
            char[] chars = input.toCharArray();

            System.out.println("Misisng letter: " + String.valueOf(findMissingLetter(chars)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
