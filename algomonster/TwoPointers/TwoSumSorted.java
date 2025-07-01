import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class TwoSumSorted {
    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            int res = arr.get(left) + arr.get(right);
            if (res == target) {
                return List.of(left, right);
            } else if (res > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
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
        List<Integer> res = twoSumSorted(arr, target);
        System.out.println("Numbers by these indices add up to the target: " + res);
        scanner.close();
    }
}