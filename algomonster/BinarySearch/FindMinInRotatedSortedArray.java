
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FindMinInRotatedSortedArray {
    public static int findMinInRotatedSortedArray(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int last = arr.get(right);
        int boundaryIndex = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr.get(mid) <= last) {
                right = mid - 1;
            } else {
                boundaryIndex = mid + 1;
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
        System.out.print("Enter a sequence of values: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        System.out.println("Index of min value in rotated sorrted array: " + 
            findMinInRotatedSortedArray(arr));
    }
}