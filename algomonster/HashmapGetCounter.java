import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HashmapGetCounter {
    public static HashMap<Integer, Integer> getCounter(List<Integer> arr) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (Integer element : arr) {
            if (counter.containsKey(element)) {
                counter.put(element, counter.get(element) + 1);
            } else {
                counter.put(element, 1);
            }
        }
        return counter;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        Map<Integer, Integer> res = getCounter(arr);
        Map<Integer, Integer> resSorted = new TreeMap<>(res);
        for (int key :  resSorted.keySet()) {
            System.out.println(key + " " + resSorted.get(key));
        }
    }
}