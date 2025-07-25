import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class LowestCommonAncestorOfBst {
    public static class Node<T> {
        public T val;
        public Node<T> left;
        public Node<T> right;

        public Node(T val) {
            this(val, null, null);
        }

        public Node(T val, Node<T> left, Node<T> right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int lcaOnBst(Node<Integer> root, int p, int q) {
        if (p < root.val && q < root.val) {
            return lcaOnBst(root.left, p, q);
        } else if (p > root.val && q > root.val) {
            return lcaOnBst(root.right, p, q);
        } else {
            return root.val;
        }
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<>(f.apply(val), left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        int p = Integer.parseInt(scanner.nextLine());
        int q = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = lcaOnBst(root, p, q);
        System.out.println(res);
    }
}
