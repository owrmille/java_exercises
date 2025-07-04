import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class SubarraySumShortest {
    public static int subarraySumShortest(List<Integer> nums, int target) {
        int shortest = nums.size() + 1;
        int windowSum = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); right++) {
            windowSum += nums.get(right);
            while (windowSum >= target) {
                shortest = Math.min(shortest, right - left + 1);
                windowSum -= nums.get(left);
                left++;
            }  
        }
        return shortest > nums.size() ? 0 : shortest;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of numbers: ");
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.print("Enter a target: ");
        int target = scanner.nextInt();
        System.out.println("Output: " + subarraySumShortest(nums, target));
        scanner.close();
    }
}
