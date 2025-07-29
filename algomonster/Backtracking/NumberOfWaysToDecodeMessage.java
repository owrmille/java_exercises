import java.util.Arrays;
import java.util.Scanner;

public class NumberOfWaysToDecodeMessage {
    public static int dfs(int startIndex, String digits, int[] memo) {
        if (startIndex == digits.length()) return 1;
        if (memo[startIndex] != -1) return memo[startIndex];

        int ways = 0;
        if (digits.charAt(startIndex) == '0') return ways;
        ways += dfs(startIndex + 1, digits, memo);

        if (startIndex + 2 <= digits.length() &&
            Integer.parseInt(digits.substring(startIndex, startIndex + 2)) <= 26) {
                ways += dfs(startIndex + 2, digits, memo);
        }

        memo[startIndex] = ways;

        return ways;
    }

    public static int decodeWays(String digits) {
        int[] memo = new int[digits.length()];
        Arrays.fill(memo, -1);
        return dfs(0, digits, memo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        scanner.close();
        int res = decodeWays(digits);
        System.out.println(res);
    } 
}
