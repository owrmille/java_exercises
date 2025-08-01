import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Subsets {
    private static void dfs(int startIndex, List<Integer> path, List<Integer> nums, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.size(); i++) {
            path.add(nums.get(i));
            dfs(i + 1, path, nums, res);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums, res);
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<List<Integer>> res = subsets(nums);
        List<List<Integer>> resSorted = new ArrayList<>();
        for (List<Integer> row : res) {
            resSorted.add(row.stream().sorted().collect(Collectors.toList()));
        }
        resSorted.sort((l1, l2) -> {
            for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                if (l1.get(i) != l2.get(i)) {
                    return l1.get(i) - l2.get(i);
                }
            }
            return l1.size() - l2.size();
        });
        for (List<Integer> row : resSorted) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
