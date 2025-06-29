
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class SelectionSort {
    public static List<Integer> selectSort(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int minIdx = i;
            for (int j = i; j < size - 1; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    minIdx = j + 1;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);
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
        List<Integer> sortedList = selectSort(unsortedList);
        System.out.println(sortedList);
    }
}