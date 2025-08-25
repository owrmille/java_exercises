import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinaryTreeZigZagLevelOrderTraversal {
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

    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftToRight = true;
        while (queue.size() > 0) {
            
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);  // works only since Java 21 for List, O(n) [O(level size)] -> can degrate to O(n^2).
                    // alternatively can use LinkedList<Integer> level, then addFirst() is O(1) and overall O(n), but heavy, 
                    // or ArrayDeque<Integer> level and res.add(new ArrayList<>(level)), then overall O(n) - optimal
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                
            }
            /* alternative way:
            if (leftToRight) {
                res.add(level);
            } else {
                res.add(level.reversed());
            }
            */
            leftToRight = !leftToRight;

            res.add(level);
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
        List<List<Integer>> res = zigZagTraversal(root);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
