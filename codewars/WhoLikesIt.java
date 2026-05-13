import java.util.Scanner;

public class WhoLikesIt {
    public static String whoLikesIt(String... names) {
        if (names == null) return "no one likes this";

        switch (names.length) {
            case 0: return "no one likes this";
            case 1: return String.format("%s likes this", names[0]);
            case 2: return String.format("%s and %s like this", names[0], names[1]);
            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine().replaceAll("[\\[\\]\"\\s]", "");
            
            String[] names = input.length() != 0 ? input.split(",") : new String[0];

            System.out.println(whoLikesIt(names));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
