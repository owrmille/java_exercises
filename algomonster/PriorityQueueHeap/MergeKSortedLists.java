
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeKSortedLists {
    public static class Element {
        private int val;
        private List<Integer> currentList;
        private int headIdx;

        public Element(int val, List<Integer> currentList, int headIdx) {
            this.val = val;
            this.currentList = currentList;
            this.headIdx = headIdx;
        }
    }

    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(lists.size(), Comparator.comparingInt(e -> e.val));
        // add first element of each list to the heap
        for (List<Integer> list : lists) {
            minHeap.add(new Element(list.get(0), list, 0));
        }

        //
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            // pop the smallest
            Element curSmallest = minHeap.poll();
            // add to result list, forming a sorted merged list
            res.add(curSmallest.val);

            // retrieve current idx and list for convenience
            int curHeadIdx = curSmallest.headIdx;
            List<Integer> curList = curSmallest.currentList;
            // if we have a next element in the list to update the heap with it, then do it
            if (curHeadIdx + 1 < curList.size()) {
                minHeap.add(new Element(curList.get(curHeadIdx + 1), curList, curHeadIdx + 1));
            }
        }
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listsLen = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < listsLen; i++) {
            lists.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<Integer> res = mergeKSortedLists(lists);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
