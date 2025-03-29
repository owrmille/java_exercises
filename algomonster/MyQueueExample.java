import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MyQueueExample {
    public static Queue<Integer> execute(List<String> operations) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (String instruction : operations) {
            if (instruction.equals("peek")) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty!");
                } else {
                    System.out.println(queue.peek());
                }
            } else if (instruction.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty!");
                } else {
                    queue.poll();
                }
            } else {
                int val = Integer.parseInt(instruction.substring(5));
                queue.add(val);
            }
        }
        return queue;
    }
    public static void main(String[] args) {
        List<String> operations = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numOperations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOperations; i++) {
            operations.add(scanner.nextLine());
        }
        scanner.close();
        System.out.println();
        Queue<Integer> res = execute(operations);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
