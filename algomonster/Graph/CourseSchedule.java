import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseSchedule {
    private enum State {
        TO_VISIT,
        VISITED,
        VISITING
    }

    private static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> prereqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> dependency : prereqs) {  
            graph.computeIfAbsent(dependency.get(0), k -> new ArrayList<>()).add(dependency.get(1));
        }
        return graph;
    }

    private static boolean dfs(int firstNodeInPaths, Map<Integer, List<Integer>> graph, State[] states) {
        // VISITING - is a status active for only one current path -> 
        // if some node in loop already has VISITING status while checking candidates, 
        // then we have marked it visited AGAIN in the recursive call of dfs(nextNode)

        // candidates for nextNode can't be marked as VISITING before recursive call, 
        // only the first node in the path is (if there are no cycles).
        // but then we go into recursive calls following one current path and one-by-one mark all nodes in this path as visiting. 
        // and when we are out of nodes in the path, and none of the nodes in the path were seen VISITING (but only was made VISITING once), 
        // it means, we don't have cycles in this path. 
        // then we continue branching and do the same with the next path. 
        // then we consider paths starting from another node (in isValidCourseSchedule()'s for loop), and so on.
        
        states[firstNodeInPaths] = State.VISITING;
        if (graph.get(firstNodeInPaths) != null) {
            List<Integer> candidatesForNextNode =  graph.get(firstNodeInPaths);
            for (Integer nextNode : candidatesForNextNode) {
                if (states[nextNode] == State.VISITED) continue;
                if (states[nextNode] == State.VISITING) return false;
                if (!dfs(nextNode, graph, states)) return false;
            }
        }

        states[firstNodeInPaths] = State.VISITED;
        return true;
    }

    public static boolean isValidCourseSchedule(int courseNum, List<List<Integer>> prereqs) {
        // build graph as: if having [[1, 0], [1, 2]], then graph is [1: [0, 2]]
        // because if we want to do course number 1, then we definitely need to do courses 0 and 2 (so we eventually reach them if we consider 1)
        // that's why we don't do the opposite like I though before: [2: 1, 0: 1]
        Map<Integer, List<Integer>> graph = buildGraph(prereqs);

        // create and initialize states
        State[] states = new State[courseNum];
        Arrays.fill(states, State.TO_VISIT);

        for (int firstNodeInPaths = 0; firstNodeInPaths < courseNum; firstNodeInPaths++) {
            if (!dfs(firstNodeInPaths, graph, states)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int courseNum = Integer.parseInt(scanner.nextLine());
        int prereqsLen = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> prereqs = new ArrayList<>();
        for (int i = 0; i < prereqsLen; i++) {
            prereqs.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        boolean res = isValidCourseSchedule(courseNum, prereqs);
        System.out.println(res);
    }
}
