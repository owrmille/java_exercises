import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CombinationSum {
    private static void dfs(List<Integer> candidates,
                            int target,
                            List<List<Integer>> res,
                            List<Integer> path,
                            int sum,
                            int startIndex) {
                                if (sum == target) {
                                    res.add(new ArrayList<>(path));
                                    return;
                                }
                                if (sum < target) {
                                    for(int i = startIndex; i < candidates.size(); i++) {
                                        sum += candidates.get(i);
                                        if (sum > target) {
                                            break;
                                        }
                                        path.add(candidates.get(i));
                                        dfs(candidates, target, res, path, sum, i);
                                        path.remove(path.size() - 1);
                                        sum -= candidates.get(i);
                                    }
                                }
                            }
    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(candidates);
        dfs(candidates, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> candidates = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<List<Integer>> res = combinationSum(candidates, target);
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
