import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KthLargestElementInArray {
    public static int findKthLargest(List<Integer> nums, int k) {
        // reverseOrder() returns comparator; we use it here so head will point to the max element 
        // (otherwise PriorityQueue is for min heap, so now we reverse it)
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.size(), Collections.reverseOrder());
        // add all elems in the heap
        for (Integer el : nums) {
            heap.add(el);
        }
        // The internal array isn’t sorted; 
        // we just get elements in descending order if we keep polling repeatedly.
        // poll first k-1 largest
        for (int i = 1; i <= k - 1; i++) {
            heap.poll();
        }
        // poll and return k-th largest
        return heap.poll();
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findKthLargest(nums, k);
        System.out.println(res);
    }
}
