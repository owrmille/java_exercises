import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class SerializingDeserializingBinaryTree {
    public static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public static Node buildTree(Iterator<String> iter) {
            String nxt = iter.next();
            if (nxt.equals("x")) return null;
            Node node = new Node(Integer.parseInt(nxt));
            node.left = buildTree(iter );
            node.right = buildTree(iter);
            return node;
        }

        public static void printTree(Node root, List<String> out) {
            if (root == null) {
                out.add("x");
            } else {
                out.add(String.valueOf(root.val));
                printTree(root.left, out);
                printTree(root.right, out);
            }
        }
    }

    private static void serializeDfs(Node root, StringJoiner res) {
        if (root == null) {
            res.add("x");
            return;
        }
        res.add(Integer.toString(root.val));
        serializeDfs(root.left, res);
        serializeDfs(root.right, res);
    }

    public static String serialize(Node root) {
        StringJoiner res = new StringJoiner(" ");
        serializeDfs(root, res);
        return res.toString();
    }

    private static Node deserializeDfs(Iterator<String> iter) {
        String val = iter.next();
        if (val.equals("x")) {
            return null;
        }
        Node root = new Node(Integer.parseInt(val));
        root.left = deserializeDfs(iter);
        root.right = deserializeDfs(iter);
        return root;
    }

    public static Node deserialize(String s) {
        return deserializeDfs(Arrays.asList(s.split(" ")).iterator());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        scanner.close();
        System.out.println(serialize(root));
        Node newRoot = deserialize(serialize(root));
        ArrayList<String> out = new ArrayList<>();
        Node.printTree(newRoot, out);
        System.out.println(String.join(" ", out));
    }
}
