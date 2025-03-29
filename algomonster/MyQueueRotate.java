import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;


public class MyQueueRotate {
    public static List<Integer> rotateLeftTillZero(List<Integer> nums) {
        Queue<Integer> queue = new ArrayDeque<>(nums);
        while (queue.peek() != 0) {
            queue.add(queue.poll());
        }
        List<Integer> rotatedArray = new ArrayList<>(queue);
        return rotatedArray;
    }

    public static List<String> splitWords(String str) {
        return str.isEmpty() ? List.of() : Arrays.asList(str.split(" "));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> rotatedArray = rotateLeftTillZero(nums);
        System.out.println(rotatedArray.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
