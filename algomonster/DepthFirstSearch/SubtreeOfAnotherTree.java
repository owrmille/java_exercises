import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SubtreeOfAnotherTree {
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

    private static boolean isSameTree(Node<Integer> root1, Node<Integer> root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val.equals(root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public static boolean subtreeOfAnotherTree(Node<Integer> root, Node<Integer> subRoot) {
        if (root == null) return false;
        return isSameTree(root, subRoot) || subtreeOfAnotherTree(root.left, subRoot) || subtreeOfAnotherTree(root.right, subRoot);
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        Node<Integer> subRoot = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        boolean res = subtreeOfAnotherTree(root, subRoot);
        System.out.println(res);
    }
}
