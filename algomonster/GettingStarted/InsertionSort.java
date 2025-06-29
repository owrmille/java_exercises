import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InsertionSort {
    public static List<Integer> insertionSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int current = i;
            while (current > 0 && list.get(current) < list.get(current - 1)) {
                int temp = list.get(current);
                list.set(current, list.get(current - 1));
                list.set(current - 1, temp);
                current--;
            }
        }
        return list;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> unsortedList = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> sortedList = insertionSort(unsortedList);
        System.out.println(sortedList);
    }
}