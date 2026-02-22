import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class CountOccurences {
    public static int countOccurrences(List<Integer> nums, int target) {
        int cnt = 0;
        for (int el : nums) {
            if (el == target) cnt++;
        }
        return cnt;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = countOccurrences(nums, target);
        System.out.println(res);
    } 
}
