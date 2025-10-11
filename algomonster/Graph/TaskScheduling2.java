import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskScheduling2 {
    public static Map<String, Integer> findInDegree(Map<String, List<String>> graph) {
        Map<String, Integer> inDegree = new HashMap<>();
        graph.keySet().forEach(key -> {
            inDegree.put(key, 0);
        });
        graph.entrySet().forEach(entry -> {
            // counting parents
            for (String neighbour : entry.getValue()) {
                inDegree.put(neighbour, inDegree.get(neighbour) + 1);  // updating value by 1
            }
        });
        return inDegree;
    }

    public static int topoSort(Map<String, List<String>> graph, Map<String, Integer> taskTimes) {
        int ans = 0;
        Map<String, Integer> distances = new HashMap<>();
        graph.keySet().forEach(key -> {
            distances.put(key, 0);
        });
        Queue<String> queue = new ArrayDeque<>();

        Map<String, Integer> inDegree = findInDegree(graph);
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.add(node);
                distances.put(node, taskTimes.get(node));
                ans = Math.max(ans, distances.get(node));
            }
        }

        while (!queue.isEmpty()) {
            String node = queue.poll();
            for (String neighbour : graph.get(node)) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                distances.put(neighbour, Math.max(distances.get(neighbour), distances.get(node) + taskTimes.get(neighbour)));
                ans = Math.max(ans, distances.get(neighbour));
                if (inDegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return ans;
    }

    public static int taskScheduling2(List<String> tasks, List<Integer> times, List<List<String>> reqs) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> taskTimes = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            graph.put(tasks.get(i), new ArrayList<>());
            taskTimes.put(tasks.get(i), times.get(i));
        }

        for (List<String> req : reqs) {
            graph.get(req.get(0)).add(req.get(1));
        }
        return topoSort(graph, taskTimes);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = splitWords(scanner.nextLine());
        List<Integer> times = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int reqsLen = Integer.parseInt(scanner.nextLine());
        List<List<String>> reqs = new ArrayList<>();
        for (int i = 0; i < reqsLen; i++) {
            reqs.add(splitWords(scanner.nextLine()));
        }
        scanner.close();
        int res = taskScheduling2(tasks, times, reqs);
        System.out.println(res);
    }
}
