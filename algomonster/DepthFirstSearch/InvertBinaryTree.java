import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class InvertBinaryTree {
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

    public static Node<Integer> invertBinaryTree(Node<Integer> root) {
        if (root == null) return null;
        return new Node<>(root.val, invertBinaryTree(root.right), invertBinaryTree(root.left));
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

    public static <T> void formatTree(Node<T> node, List<String> out) {
        if (node == null) {
            out.add("x");
            return;
        }
        out.add(node.val.toString());
        formatTree(node.left, out);
        formatTree(node.right, out);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        scanner.close();
        Node<Integer> res = invertBinaryTree(root);
        ArrayList<String> resArr = new ArrayList<>();
        formatTree(res, resArr);
        System.out.println(String.join(" ", resArr));
    }
}
