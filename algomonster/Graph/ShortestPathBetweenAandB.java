import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ShortestPathBetweenAandB {
       public static List<Integer> getNeighbours(List<List<Integer>> graph, int node) {
        return graph.get(node);
    }

    public static int bfs(List<List<Integer>> graph, int root, int target) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Integer> visited = new HashSet<>();
        visited.add(root);
        int len = 0;
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int node = queue.pop();
                if (node == target) return len;
                for (int neighbour : getNeighbours(graph, node)) {
                    if (visited.contains(neighbour)) {
                        continue;
                    }
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
            len++;
        }
        return  len;
    }
    
    public static int shortestPath(List<List<Integer>> graph, int a, int b) {
        return bfs(graph, a, b);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int graphLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < graphLength; i++) {
            graph.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = shortestPath(graph, a, b);
        System.out.println(res);
    }
}

