
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FindPeakOfMountainArray {
    public static int findPeakOfMountainArray(List<Integer> arr) {
        int len = arr.size();
        int left = 1;  // first element can't be a peak
        int right = len - 2;  // last element can't be a peak
        int boundaryIndex = -1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (mid + 1 < len && arr.get(mid) > arr.get(mid + 1)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("A Peak of Mountain Array: " + findPeakOfMountainArray(arr));
        scanner.close();
    }
}