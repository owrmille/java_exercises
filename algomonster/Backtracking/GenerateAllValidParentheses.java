import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GenerateAllValidParentheses {
    private static void dfs(List<Character> path, int openCount, int closeCount, List<String> res, int n) {
        if (path.size() == 2 * n) {
            res.add(path.stream()
                        .map(e -> e.toString())
                        .collect(Collectors.joining()));
            return;
        }
        if (openCount < n) {
            path.add('(');
            dfs(path, openCount + 1, closeCount, res, n);
            path.remove(path.size() - 1);
        }
        if (closeCount < openCount) {
            path.add(')');
            dfs(path, openCount, closeCount + 1, res, n);
            path.remove(path.size() - 1);
        }
    }

    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        dfs(new ArrayList<Character>(), 0, 0, res, n);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> res = generateParentheses(n);
        System.out.println(res);
        scanner.close();
    }
}
