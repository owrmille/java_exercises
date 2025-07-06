import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RangeSumQueryImmutable {
    public static int[] initSumArray(List<Integer> nums) {
        int[] prefixSums = new int[nums.size() + 1];
        for (int i = 0; i < nums.size(); i++) {
            prefixSums[i + 1] = prefixSums[i] + nums.get(i);
        }
        return prefixSums;
    }
    public static int rangeSumQueryImmutable(List<Integer> nums, int left, int right) {
        int[] prefixSums = initSumArray(nums);
        // prefixSums[right + 1] includes nums[right],
        // prefixSums[left + 1] includes nums[left] ->
        // if we subtract prefixSums[left + 1], we will lose nums[left] ->
        // so we need to subtract prefixSums[left] instead
        return prefixSums[right + 1] - prefixSums[left];
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());      
        System.out.print("Enter left index: ");
        int left = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter right index: ");
        int right = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println("Output: " + rangeSumQueryImmutable(nums, left, right));
    }
}
