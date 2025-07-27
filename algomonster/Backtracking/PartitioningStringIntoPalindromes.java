import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitioningStringIntoPalindromes {
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(r) != s.charAt(l)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void dfs(int startIndex, List<String> path, String s, List<List<String>> res) {
        if (startIndex == s.length()) {
            List<String> onePartition = new ArrayList<>(path);
            res.add(onePartition);
        }
        for (int end = startIndex; end < s.length(); end++) {
            if (isPalindrome(s.substring(startIndex, end + 1))) {
                path.add(s.substring(startIndex, end + 1));
                dfs(end + 1, path, s, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, new ArrayList<String>(), s, res);
        return res;
    }

   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    scanner.close();
    List<List<String>> res = partition(input);
    System.out.println(res);
   } 
}
