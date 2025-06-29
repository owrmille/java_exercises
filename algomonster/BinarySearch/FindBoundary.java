
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class FindBoundary {
    public static int findBoundary(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr.get(mid)) {
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
        System.out.print("Enter a sequence of boolean values: ");
        List<Boolean> arr = splitWords(scanner.nextLine()).stream().map(el -> el.equals("true")).collect(Collectors.toList());
        scanner.close();
        System.out.println("Index of first 'true' value: " + findBoundary(arr));
    }
}