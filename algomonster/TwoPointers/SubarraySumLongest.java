import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class SubarraySumLongest {
    public static int subarraySumLongest(List<Integer> arr, int target) {
        int left = 0;
        int maxLength = 0;
        int longestSum = 0;

        for (int right = 0; right < arr.size(); right++) {
            longestSum += arr.get(right);
            while (longestSum > target) {
                longestSum -= arr.get(left);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: "); 
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.print("Enter a target: "); 
        int target = scanner.nextInt();
        System.out.println("Output: " + subarraySumLongest(arr, target));
        scanner.close();
    }
}