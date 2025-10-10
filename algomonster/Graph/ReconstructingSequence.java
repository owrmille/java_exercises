import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ReconstructingSequence {
    public static <T> Map<T, Integer> findInDegree(Map<T, Set<T>> graph) {
        Map<T, Integer> inDegree = new HashMap<>();
        graph.keySet().forEach(key -> {
            inDegree.put(key, 0);
        });
        graph.entrySet().forEach(entry -> {
            for (T neighbour : entry.getValue()) {
                inDegree.put(neighbour, inDegree.get(neighbour) + 1);
            }
        });
        return inDegree;
    }

    public static <T> boolean topoSort(Map<T, Set<T>> graph, List<T> original) {
        List<T> res = new ArrayList<>();
        Queue<T> queue = new ArrayDeque<>();
        Map<T, Integer> inDegree = findInDegree(graph);

        inDegree.entrySet().forEach(entry -> {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        });

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            T node = queue.poll();
            res.add(node);
            for (T neighbour :  graph.get(node)) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if (inDegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return original.equals(res);
    }

    public static boolean sequenceReconstruction(List<Integer> original, List<List<Integer>> seqs) {
        int n = original.size();
        Map<Integer, Set<Integer>> graph = new HashMap<>();  // set -> no repeptitions of sequences
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                int earlyVal = seq.get(i);
                int lateVal = seq.get(i + 1);
                if (!graph.get(earlyVal).contains(lateVal)) {
                    graph.get(earlyVal).add(lateVal);
                }
            }
        }
        return topoSort(graph, original);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> original = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int seqsLen = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> seqs = new ArrayList<>();
        for (int i = 0; i < seqsLen; i++) {
            seqs.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        boolean res = sequenceReconstruction(original, seqs);
        System.out.println(res);
    }
}
