import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InsertAtPosition {
    public static List<Integer> insertAtPosition(List<Integer> arr, int index, int value) {
        arr.add(index, value);
        return arr;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int index = Integer.parseInt(scanner.nextLine());
        int value = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = insertAtPosition(arr, index, value);
        System.out.println(res);
    }
}
