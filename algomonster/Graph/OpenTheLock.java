import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpenTheLock {
    public static Map<Character, Character> nextDigit = Map.of(
        '0', '1',
        '1', '2',
        '2', '3',
        '3', '4',
        '4', '5',
        '5', '6',
        '6', '7',
        '7', '8',
        '8', '9',
        '9', '0');

    public static Map<Character, Character> prevDigit = nextDigit
                                                            .entrySet()
                                                            .stream()
                                                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public static int numSteps(String targetCombo, List<String> trappedCombos) {
        
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetCombo = scanner.nextLine();
        List<String> trappedCombos = splitWords(scanner.nextLine());
        scanner.close();
        int res = numSteps(targetCombo, trappedCombos);
        System.out.println(res);
    }
}
