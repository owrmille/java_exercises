import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
          
          int complement = target - numbers[i];
          
          if (seen.containsKey(complement)) {
              return new int[] {i, seen.get(complement)};
          }
          
          seen.put(numbers[i], i);
        }
        
        return new int[0]; 
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(scanner.nextLine());

            int[] res = twoSum(numbers, target);
            System.out.println(res[0] + ", " + res[1]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
