import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
        if (targetCombo.equals("0000")) {
            return 0;
        }
        HashSet<String> trappedComboSet = new HashSet<>(trappedCombos);
        HashMap<String, Integer> steps = new HashMap<>();
        ArrayDeque<String> bfsQueue = new ArrayDeque<>();
        steps.put("0000", 0);
        bfsQueue.offer("0000");
        while (!bfsQueue.isEmpty()) {
            String top = bfsQueue.poll();
            for (int i = 0; i < 4; i++) {
                String newCombo = top.substring(0, i).concat(String.valueOf(prevDigit.get(top.charAt(i)))).concat(top.substring(i + 1));
                if (!trappedComboSet.contains(newCombo) && !steps.containsKey(newCombo)) {
                    bfsQueue.offer(newCombo);
                    steps.put(newCombo, steps.get(top) + 1);
                    if (newCombo.equals(targetCombo)) {
                        return steps.get(newCombo);
                    }
                }
                newCombo = top.substring(0, i).concat(String.valueOf(nextDigit.get(top.charAt(i)))).concat(top.substring(i + 1));
                if (!trappedComboSet.contains(newCombo) && !steps.containsKey(newCombo)) {
                    bfsQueue.offer(newCombo);
                    steps.put(newCombo, steps.get(top) + 1);
                    if (newCombo.equals(targetCombo)) {
                        return steps.get(newCombo);
                    }
                }
            }
        }
        return -1;
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
