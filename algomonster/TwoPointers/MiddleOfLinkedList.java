
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.function.Function;

class MiddleOfLinkedList {
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

    public static int middleOfLinkedList(Node<Integer> head) {
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static <T> Node<T> buildList(Iterator<String> iter, Function<String,T> f) {
        if (!iter.hasNext()) return null;
        String val = iter.next();
        Node<T> next = buildList(iter, f);
        return new Node<T>(f.apply(val), next);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of values: ");
        Node<Integer> head = buildList(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
        System.out.println("Middle of a linked list: " + middleOfLinkedList(head));
        scanner.close();
    }
}