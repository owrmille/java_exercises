import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FindMaximum {
    public static int findMaximum(List<Integer> arr) {
        int maxEl = arr.get(0);
        for (int el : arr) {
            if (el > maxEl) maxEl = el;
        }
        return maxEl;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = findMaximum(arr);
        System.out.println(res);
    }
}
