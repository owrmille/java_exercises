import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {
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

    public static List<Integer> binaryTreeRightSideView(Node<Integer> root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right); 
                if (i == n - 1) res.add(node.val);
            }
        }
        return res;
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
        scanner.close();
        List<Integer> res = binaryTreeRightSideView(root);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
