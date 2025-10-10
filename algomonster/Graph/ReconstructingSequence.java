import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ReconstructingSequence {
    public static boolean sequenceReconstruction(List<Integer> original, List<List<Integer>> seqs) {
        int n = original.size();
        Map<Integer, Set<Integer>> graph = new HashMap<>(); // using set here cuz possibility of repeated sequences
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                int earlyNum = seq.get(i), lateNum = seq.get(i + 1);
                if (!graph.get(earlyNum).contains(lateNum)) {
                    graph.get(earlyNum).add(lateNum);
                }
            }
        }
        return topoSort(graph, original);
    }

    public static <T> Map<T, Integer> findInDegree(Map<T, Set<T>> graph) {
        Map<T, Integer> indegree = new HashMap<>();
        graph.keySet().forEach(node -> {
            indegree.put(node, 0);
        });
        graph.entrySet().forEach(entry -> {
            for (T neighbor : entry.getValue()) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        });
        return indegree;
    }

    public static <T> boolean topoSort(Map<T, Set<T>> graph, List<T> original) {
        List<T> reconstructed = new ArrayList<>();
        ArrayDeque<T> q = new ArrayDeque<>();
        Map<T, Integer> indegree = findInDegree(graph);
        indegree.entrySet().forEach(entry -> {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        });
        while (!q.isEmpty()) {
            if (q.size() > 1) { // if there's > 1 node in the queue, the reconstruction is not unique
                return false;
            }
            T node = q.poll();
            reconstructed.add(node);
            for (T neighbor : graph.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }
        // check if sequence is the same as original sequence
        return original.equals(reconstructed);
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
