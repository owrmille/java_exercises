import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class BinarySearch {
    public static int vanillaBinarySearch(List<Integer> arr, int target) {
        int size = arr.size();
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 5, 9, 11, 15, 20, 21, 22, 25);
        System.out.println(arr);
        System.out.println("Index of target: " + vanillaBinarySearch(arr, 21));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of numbers: ");
        List<Integer> scannedArr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.print("Enter a target value: ");
        int target = scanner.nextInt();
        scanner.close();
        System.out.println("Index of target: " + vanillaBinarySearch(scannedArr, target));
    }
}