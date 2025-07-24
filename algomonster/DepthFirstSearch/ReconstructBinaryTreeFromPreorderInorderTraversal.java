import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReconstructBinaryTreeFromPreorderInorderTraversal {
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

    public static Node<Integer> buildTreeRecursive(
                    List<Integer> preorder, 
                    Map<Integer,Integer> inorderIndexMap,
                    int preorderStart, 
                    int inorderStart, 
                    int size) {
        if (size <= 0) return null;
        int rootVal = preorder.get(preorderStart);
        int rootIndexInInorderArray = inorderIndexMap.get(rootVal);
        int leftPartSize = rootIndexInInorderArray - inorderStart;

        Node<Integer> left = buildTreeRecursive(
                    preorder, 
                    inorderIndexMap, 
                    preorderStart + 1, 
                    inorderStart, 
                    leftPartSize);
        Node<Integer> right = buildTreeRecursive(
                    preorder, 
                    inorderIndexMap, 
                    preorderStart + leftPartSize + 1, 
                    rootIndexInInorderArray + 1, 
                    size - leftPartSize - 1);

        return new Node<>(rootVal, left, right);
    }

    public static Node<Integer> constructBinaryTree(List<Integer> preorder, List<Integer> inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < preorder.size(); i++) {
            inorderIndexMap.put(inorder.get(i), i);
        }
        return buildTreeRecursive(
                    preorder, 
                    inorderIndexMap,
                    0,
                    0,
                    preorder.size());
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
        List<Integer> preorder = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> inorder = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        Node<Integer> res = constructBinaryTree(preorder, inorder);
        ArrayList<String> resArr = new ArrayList<>();
        formatTree(res, resArr);
        System.out.println(String.join(" ", resArr));
    }
}
