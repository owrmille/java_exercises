import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.MatchResult;

public class NumberOfVisibleNodes {
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int dfs(Node<Integer> root, int maxValSoFar) {
        if (root == null) {
            return 0;
        }
        // System.out.println("Visiting node: " + root.val + ", maxValSoFar: " + maxValSoFar);
        int total = 0;
        if (root.val >= maxValSoFar) {
            total++;
        }
        total += dfs(root.left, Math.max(maxValSoFar, root.val));
        total += dfs(root.right, Math.max(maxValSoFar, root.val));
        return total;
    }

    public static int visibleTreeNode(Node<Integer> root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public static <T> Node<T> buildNodes(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildNodes(iter, f);
        Node<T> right = buildNodes(iter, f);
        return new Node<>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildNodes(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        System.out.println(visibleTreeNode(root));
    }
}
