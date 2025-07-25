import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class TernaryTreePaths {
    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }

    private static void dfs(Node<Integer> root, List<String> path, List<String> res) {
        // exit condition: when a leaf node is reached, append the path to the results
        if (root.children.isEmpty()) {
            path.add(Integer.toString(root.val));
            res.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }

        // DFS on each non-null child
        for (Node<Integer> child : root.children) {
            path.add(Integer.toString(root.val));
            dfs(child, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        List<String> res = new ArrayList<>();
        if (root != null) dfs(root, new ArrayList<String>(), res);
        return res;
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<Node<T>> children = new ArrayList<>();
        for (int i = 0; i < num; i++)
            children.add(buildTree(iter, f));
        return new Node<>(f.apply(val), children);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        List<String> res = ternaryTreePaths(root);
        for (String line : res) {
            System.out.println(line);
        }
    }
}
