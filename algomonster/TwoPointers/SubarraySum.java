import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubarraySum {
    // here we need to keep track of indices
    public static List<Integer> subarraySum(List<Integer> nums, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int curSum = 0;
        prefixSums.put(0, 0);
        for (int i = 0; i < nums.size(); i++) {
            curSum += nums.get(i);
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                return List.of(prefixSums.get(complement), i + 1);
            }
            prefixSums.put(curSum, i + 1);
        }
        return null;
    }

    // here we need to keep track of frequences
    public static int subarraySumTotal(List<Integer> nums, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int curSum = 0;
        int cnt = 0;
        prefixSums.put(0, 1);
        for (int i = 0; i < nums.size(); i++) {
            curSum += nums.get(i);
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                cnt += prefixSums.get(complement);
            }
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }
        return cnt;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.print("Enter a target: ");
        int target = scanner.nextInt();        
        scanner.close();
        System.out.println("Output: " + subarraySum(nums, target));
        System.out.println("Output: " + subarraySumTotal(nums, target));
    }
}
