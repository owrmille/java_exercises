import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GenerateAllPermutations {
    private static void dfs(int startIndex, 
                        List<Character> path, 
                        boolean[] used, 
                        List<String> res, 
                        char[] letters) {
        if (startIndex == used.length) {
            res.add(
                path.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining()));
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            path.add(letters[i]);
            used[i] = true;
            dfs(startIndex + 1, path, used, res, letters);
            path.remove(path.size() - 1);
            used[i] = false;
        } 
    }

    public static List<String> permutations(String s) {
        List<String> res = new ArrayList<>();
        char[] letters = s.toCharArray();
        dfs(0, 
                new ArrayList<Character>(), 
                new boolean[s.length()], 
                res, 
                letters);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        List<String> res = permutations(s);
        res.stream().sorted().forEach(System.out::println);
    }
}
