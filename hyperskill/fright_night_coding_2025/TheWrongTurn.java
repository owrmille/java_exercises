
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheWrongTurn {
    public static void printFourMostCommonDigits(List<Integer> nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (Integer el = 0; el < 10; el++) {
            numsMap.put(el, 0);
        }
        for (int i = 0; i < nums.size(); i++) {
            numsMap.put(nums.get(i), numsMap.get(nums.get(i)) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numsMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("datasets/hyperskill-dataset-117278428.txt"))) {
            String token = scanner.next();
            System.out.println(token);
            List<Integer> nums = token.chars().mapToObj(c -> String.valueOf((char)c)).toList().stream().map(Integer::parseInt).collect(Collectors.toList());
            printFourMostCommonDigits(nums);
        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
}
