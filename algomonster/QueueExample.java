import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QueueExample {
    public static Queue<Integer> execute(List<String> program) {
        // initialize a new ArrayDeque representing a queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (String instruction : program) {
            if (instruction.equals("peek")) {
                if (queue.isEmpty()) {
                    // print warning message if queue is empty
                    System.out.println("Queue is empty!");
                } else {
                    // print out the first item in queue
                    System.out.println(queue.peek());
                }
            } else if (instruction.equals("pop")) {
                if (queue.isEmpty()) {
                    // print warning message if queue is empty
                    System.out.println("Queue is empty!");
                } else {
                    // pop the first item in queue
                    queue.poll();
                }
            } else {
                // get the data in the "push" instruction
                int data = Integer.parseInt(instruction.substring(5));
                // push data to the end of queue
                queue.add(data);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int programLength = Integer.parseInt(scanner.nextLine());
        List<String> program = new ArrayList<>();
        for (int i = 0; i < programLength; i++) {
            program.add(scanner.nextLine());
        }
        scanner.close();
        Queue<Integer> res = execute(program);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}