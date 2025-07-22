import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class TreeTraversal {
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

    public static void inOrderTraversal(Node<Integer> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    public static void preOrderTraversal(Node<Integer> root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(Node<Integer> root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public static Node<Integer> simpleDfs(Node<Integer> root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        Node<Integer> left = simpleDfs(root.left, target);
        if (left != null) return left;
        return simpleDfs(root.right, target);
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
        System.out.println("In-order Traversal:");
        inOrderTraversal(root);
        System.out.println("Pre-order Traversal:");
        preOrderTraversal(root);
        System.out.println("Post-order Traversal:");
        postOrderTraversal(root);
        System.out.println("Simple DFS: " + simpleDfs(root, 7).val);
    }
}
