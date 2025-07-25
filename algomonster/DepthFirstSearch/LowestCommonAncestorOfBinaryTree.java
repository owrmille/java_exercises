import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class LowestCommonAncestorOfBinaryTree {
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

    public static Node<Integer> lca(Node<Integer> root, Node<Integer> node1, Node<Integer> node2) {
        // base case: reached end of a branch, nothing found here
        if (root == null) {
            return null;
        }

        // if current node is one of the targets, return it
        // (either it will be the LCA itself or it will help find it) 
       if (root.val == node1.val || root.val == node2.val) {
            return root;
        }
        // search left and right subtrees
        Node<Integer> left = lca(root.left, node1, node2);
        Node<Integer> right = lca(root.right, node1, node2);

        // if both are not null, then we found LCA! 
        // current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // otherwise, return the non-null result (could be a target node or LCA)
        // [at this point left and right can't be both NON-null]
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        // if neither side found anything, return null// if not found
        return null;
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

    public static <T> Node<T> findNode(Node<T> root, T target) {
        if (root == null) return null;
        if (root.val == target) return root;
        Node<T> leftSearch = findNode(root.left, target);
        if (leftSearch != null) {
            return leftSearch;
        }
        return findNode(root.right, target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> root = buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator(), Integer::parseInt);
        Node<Integer> node1 = findNode(root, Integer.parseInt(scanner.nextLine()));
        Node<Integer> node2 = findNode(root, Integer.parseInt(scanner.nextLine()));
        scanner.close();
        Node<Integer> ans = lca(root, node1, node2);
        System.out.println(ans == null ? "null" : ans.val);
    }
}
