import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MoveZeros {
    public static void moveZeros(List<Integer> arr) {
        int slow = 0; 

        for (int fast = 0; fast < arr.size(); fast++) {
            if (arr.get(fast) != 0) {
                int temp = arr.get(fast);
                arr.set(fast, arr.get(slow));
                arr.set(slow, temp);
                slow++;
            }
        }
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        moveZeros(arr);
        System.out.println("Modified array: " + arr);
        scanner.close();
    }
}