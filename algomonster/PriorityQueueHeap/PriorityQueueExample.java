import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PriorityQueueExample {
    public static List<Integer> heapTop3(List<Integer> numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer n : numbers) {
            pq.add(n);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            res.add(pq.poll());
        }
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = heapTop3(numbers);
        System.out.println(res);
    }
}
