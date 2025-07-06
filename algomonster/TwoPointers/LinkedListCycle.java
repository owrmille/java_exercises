import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LinkedListCycle {
    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean hasCycle(Node<Integer> node) {
        Node<Integer> tortoise = node.next;
        Node<Integer> hare = node.next.next;
        while (tortoise != hare && hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        if (hare == null) return false;
        if (hare.next == null) return false;
        return true;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> rawInput = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        ArrayList<Node<Integer>> nodesList = new ArrayList<>();
        for (int i = 0; i < rawInput.size(); i++) {
            nodesList.add(new Node<Integer>(i));
        }
        // clarification:
        // rawInput[i] tells which node index the i-th node should point to;
	    // -1 means “end of list”
        for (int i = 0; i < rawInput.size(); i++) {
            if (rawInput.get(i) != -1) {
                nodesList.get(i).next = nodesList.get(rawInput.get(i));
            }
        }
        Node<Integer> nodes = nodesList.get(0);
        boolean res = hasCycle(nodes);
        System.out.println("Output: " + res);
    }
}
