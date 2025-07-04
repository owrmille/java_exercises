import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class LeastConsecutiveCardsToMatch {
    public static int leastConsecutiveCardsToMatch(List<Integer> cards) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0;
        int shortest = cards.size() + 1;
        for (int right = 0; right < cards.size(); right++) {
            window.put(cards.get(right), window.getOrDefault(cards.get(right), 0) + 1);
            while (window.get(cards.get(right)) == 2) {
                shortest = Math.min(shortest, right - left + 1);
                window.put(cards.get(left), window.getOrDefault(cards.get(left), 1) - 1);
                left++;
            }
        }
        return shortest > cards.size() ? -1 : shortest;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of numbers: ");
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Output: " + leastConsecutiveCardsToMatch(nums));
        scanner.close();
    }
}
