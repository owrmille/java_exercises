import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class BubbleSort {
    public static List<Integer> bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = n - 1; i >= 0; i--) {
            boolean isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return list;
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
        List<Integer> sortedList = bubbleSort(unsortedList);
        System.out.println(sortedList);
    }
}