import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KClosestPoints {
    // min heap
    public static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {
        Comparator<List<Integer>> distComparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> p1, List<Integer> p2) {
                return distanceToOrigin(p1) - distanceToOrigin(p2);
            }

            public int distanceToOrigin(List<Integer> p) {
                return p.get(0) * p.get(0) + p.get(1) * p.get(1);
            }
        };
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(points.size(), distComparator);
        for (List<Integer> el : points) {
            heap.add(el);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        return res;
    }
    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pointsLen = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> points = new ArrayList<>();
        for (int i = 0; i < pointsLen; i++) {
            points.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();

        // using min heap:
        List<List<Integer>> res = kClosestPoints(points, k);

        for (List<Integer> el : res) {
            System.out.println(el.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
