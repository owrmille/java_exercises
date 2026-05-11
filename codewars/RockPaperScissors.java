import java.util.Map;
import java.util.Scanner;

public class RockPaperScissors {
    private static final Map<String, String> loserWinnerMap = Map.of(
        "rock", "paper",
        "scissors", "rock",
        "paper", "scissors"
    );

    public static String rps(String p1, String p2) {

        p1 = p1.toLowerCase();
        p2 = p2.toLowerCase();

        if (p1.equals(p2)) return "Draw!";

        return loserWinnerMap.get(p1).equals(p2)
                ? "Player 2 won!"
                : "Player 1 won!";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // input: "word1",   "word2" -> number of spaces may be different
            String input = scanner.nextLine().trim();

            String[] words = input.substring(1, input.length() - 1).split("\",\s*\"");
            System.out.println(rps(words[0], words[1]));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
