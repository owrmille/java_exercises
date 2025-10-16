import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinimumSpanningTreeForests {
    public static class UnionFind<T> {
        private Map<T, T> childParentMap = new HashMap<>();

        public T find(T x) {
            // get parent of x -> it may be already representative of the set
            T rootCandidate = childParentMap.getOrDefault(x, x);
            // only representative (root) can have itself as a parent, so if child != parent, then we need to keep searching for root further
            if (x != rootCandidate) {
                rootCandidate = find(rootCandidate);
                childParentMap.put(x, rootCandidate);
            }
            return rootCandidate;
        }

        public void union(T x, T newCommonRoot) {
            // if x from set 1, and newCommonRoot from set 2 (sets are not connected), 
            // then root of set 2 becomes common root for united sets, and root of set 1 becomes 2's child
            childParentMap.put(find(x), find(newCommonRoot));
        }

    }

    public static int mstForest(int treesNum, List<List<Integer>> pairs) {
        // attention : treesNum is not useful here
        int minNumFences = 0;
        UnionFind<Integer> mstUnionFind = new UnionFind<>();

        // 1. sort edges by weights (idx=0 - first vertex, idx=1 - second vertex, idx=2 - weight/distance)
        Collections.sort(pairs, (a, b) -> a.get(2).compareTo(b.get(2)));

        // 2. try every edge 
        for (int i = 0; i < pairs.size(); i++) {
            int a = pairs.get(i).get(0);
            int b = pairs.get(i).get(1);
            int w = pairs.get(i).get(2);

            // 3. if both vertices of the edge are not in the same set (i.e. are not having the same representative (root), i.e. are not connected by some path).
            // then add new edge to the graph
            if (mstUnionFind.find(a) != mstUnionFind.find(b)) {
                mstUnionFind.union(a, b);
                minNumFences += w;

                // 4. since there is a chance that not all nodes will be connected, 
                // we continue not till we have connected n-1 edges, but till the very end(finishing considering alll edges)
                // -> there is no early termination
            }
        }
        
        return minNumFences;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int treesNum = Integer.parseInt(scanner.nextLine());
        int pairsLen = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < pairsLen; i++) {
            pairs.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int minNumFences = mstForest(treesNum, pairs);
        System.out.println(minNumFences);
    }
}
