import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MergeSortedArrays {
    public static List<Integer> mergeSortedArrays(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            if (nums1.get(i) < nums2.get(j)) {
                res.add(nums1.get(i));
                i++;
            } else {
                res.add(nums2.get(j));
                j++;
            }
        }
        while (i < nums1.size()) {
            res.add(nums1.get(i));
                i++;
        }
        while (j < nums2.size()) {
            res.add(nums2.get(j));
                j++;
        }
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums1 = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> nums2 = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = mergeSortedArrays(nums1, nums2);
        System.out.println(res);
    } 
}
