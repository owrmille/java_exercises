
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FirstOccurrence {
    public static int firstOccurrence(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr.get(mid) == target) {
                boundaryIndex = mid;
                right = mid - 1;
            } else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of numbers: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.print("Enter a target: ");
        int target = scanner.nextInt();
        scanner.close();
        System.out.println("First occurrence: " + firstOccurrence(arr, target));
    }
}