import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ContainerWithMostWater {
    public static int containerWithMostWater(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int maxArea = 0;
        while (left < right) {
            int newArea = Integer.min(arr.get(left), arr.get(right)) * (right-left);
            maxArea = Math.max(maxArea, newArea);
            if (arr.get(left) < arr.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(","));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("Maximum area of water: " + containerWithMostWater(arr));
        scanner.close();
    }
}