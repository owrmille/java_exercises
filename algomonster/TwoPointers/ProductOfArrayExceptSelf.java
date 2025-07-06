import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {
    public static List<Integer> productOfArrayExceptSelf(List<Integer> nums) {
        int len = nums.size();
        List<Integer> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            result.add(0);
        }

        int left = 1;
        for (int i = 0; i < len; i++) {
            result.set(i, left);
            left *= nums.get(i);
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result.set(i, right * result.get(i));
            right *= nums.get(i);
        }
        return result;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = productOfArrayExceptSelf(nums);
        System.out.println("Output: " + res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
