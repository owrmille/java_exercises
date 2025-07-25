import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class ValidBinarySearchTree {
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

    public static boolean dfs(Node<Integer> root, int min, int max) {
        if (root == null) return true;
        if (!(min < root.val && root.val < max)) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public static boolean validBst(Node<Integer> root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        boolean res = validBst(root);
        System.out.println(res);
    }
}