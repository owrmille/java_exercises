import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TaskScheduling {
    public static <T> Map<T, Integer> findInDegree(Map<T, List<T>> graph) {
        Map<T, Integer> inDegree = new HashMap<>();
        graph.keySet().forEach(node -> {
            inDegree.put(node, 0);
        });
        graph.entrySet().forEach(entry -> {
            for (T neighbour : entry.getValue()) {
                inDegree.put(neighbour, inDegree.get(neighbour) + 1);
            }
        });
        return inDegree;
    }

    public static <T> List<T> topoSort(Map<T, List<T>> graph) {
        List<T> res = new ArrayList<>();
        Queue<T> queue = new ArrayDeque<>();
        // create map with values: node and number of in-edges coming into this node
        Map<T, Integer> inDegree = findInDegree(graph);
        inDegree.entrySet().forEach(entry -> {
            // add nodes with 0 in-degree to the queue
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        });
        // pretty much like standard bfs:
        while (!queue.isEmpty()) {
            T node = queue.poll();
            res.add(node);
            // explore all neighbours (nodes on the "same level" as it was in bfs -> having only 1 step between current node and itself)
            for (T neighbour : graph.get(node)) {
                // when we processed relationship between current node and its neighbour, 
                // we need to take current node out of consideration -> decrement inDegree for neighbour by 1 
                // (since we excluded current node from consideration wrt this neighbour)
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                // add nodes with 0 in-degree to the queue
                if (inDegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        // if there are still unprocessed nodes -> there is a cycle -> no solution(null); otherwise -> res
        return graph.size() == res.size() ? res : null; 
    }

    public static List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        // create graph with nodes and neighbours for each node
        Map<String, List<String>> graph = new HashMap<>();
        // add every node from tasks
        for (String el : tasks) {
            graph.put(el, new ArrayList<>());
        }
        // add all neighbours for each node
        for (List<String> el : requirements) {
            graph.get(el.get(0)).add(el.get(1));
        }
        return topoSort(graph);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = splitWords(scanner.nextLine());
        int numRequirements = Integer.parseInt(scanner.nextLine());
        List<List<String>> requirements = new ArrayList<>();
        for (int i = 0; i < numRequirements; i++) {
            requirements.add(splitWords(scanner.nextLine()));
        }
        scanner.close();
        List<String> res = taskScheduling(tasks, requirements);
        if (res.size() != tasks.size()) {
            System.out.println("output size " + res.size() + " does not match input size " + tasks.size());
            return;
        }
        HashMap<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < res.size(); i++) {
            indices.put(res.get(i), i);
        }
        for (List<String> req : requirements) {
            for (String task : req) {
                if (!indices.containsKey(task)) {
                    System.out.println("'" + task + "' is not in output");
                    return;
                }
            }
            String a = req.get(0);
            String b = req.get(1);
            if (indices.get(a) >= indices.get(b)) {
                System.out.println("'" + a + "' is not before '" + b + "'");
                return;
            }
        }
        System.out.println("ok");
    }
}
