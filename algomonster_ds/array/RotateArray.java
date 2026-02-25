import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class RotateArray {
    public static List<Integer> rotateArray(List<Integer> arr, int k) {
        if (arr.isEmpty() || k == 0) {
            return new ArrayList<>(arr);
        }

        List<Integer> res = new ArrayList<>();
        int size = arr.size();
        k = k % size;  // since rotations are done in cycles, one full cycle doesn't change anything, but the remainder of division will tell what didn't fit into a cycle and was in fact changed

        // for (int i = size - k; i < size; i++) {
        //     res.add(arr.get(i));
        // }
        res.addAll(arr.subList(size - k, size));

        // for (int i = 0; i < size - k; i++) {
        //     res.add(arr.get(i));
        // }
        res.addAll(arr.subList(0, size - k));
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<Integer> res = rotateArray(arr, k);
        System.out.println(res);
    }
}
