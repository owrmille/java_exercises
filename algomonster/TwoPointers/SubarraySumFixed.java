import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class SubarraySumFixed {
    public static int subarraySumFixed(List<Integer> arr, int windowSize) {
        int maxSum = 0;
        int arrSize = arr.size();
        for (int i = 0; i < windowSize; i++) {
            maxSum += arr.get(i);
        }
        for (int left = 1; left + windowSize - 1 < arrSize; left++) {
            int newSum = maxSum;
            newSum -= arr.get(left - 1);
            newSum += arr.get(left + windowSize - 1);
            maxSum = Math.max(newSum, maxSum);
        }
        return maxSum;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.print("Enter size of subarray: ");
        int size = scanner.nextInt();
        scanner.close();
        int res = subarraySumFixed(arr, size);
        System.out.println("Largest sum among all subarrays of size " + size + ": " + res);
    }
}
