import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class QueueRotate {
    public static List<Integer> rotateLeftTillZero(List<Integer> nums) {
        // initialize a new deque out of nums
        ArrayDeque<Integer> queue = new ArrayDeque<>(nums);
        // continue the loop till front of queue is 0
        while (queue.peek() != 0) {
            // remove the front of the queue and add it to the end
            queue.add(queue.poll());
        }

        // create an array out of the queue
        List<Integer> res = new ArrayList<>(queue);
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = rotateLeftTillZero(nums);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
