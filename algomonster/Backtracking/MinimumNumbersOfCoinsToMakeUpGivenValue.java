import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinimumNumbersOfCoinsToMakeUpGivenValue {
    private static int findMinCoinsNumber(List<Integer> coins, int amount, int sum, int[] memo) {
        if (sum == amount) {
            return 0;  // we don't need to add coins anymore: cnt += 0;
        }
        if (sum > amount) {
            return Integer.MAX_VALUE;  // invalid path was detected -> (from for loop): the current coin being tried in this recursive call that led to this path will be skipped in this path
        }
        if (memo[sum] != -1) {
            return memo[sum];
        }
        int minCnt = Integer.MAX_VALUE;
        for (int coin : coins) {
            int curCnt = findMinCoinsNumber(coins, amount, sum + coin, memo);
            if (curCnt == Integer.MAX_VALUE) { // this is true only if in the recursive call condition from lines 11-13 was met
                continue;  // "skip this coin in this path, it’s not helping"
            }
            minCnt = Math.min(minCnt, curCnt + 1);   
        }
        memo[sum] = minCnt;
        return minCnt;
    }

    public static int coinChange(List<Integer> coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int minCnt = findMinCoinsNumber(coins, amount, 0, memo);
        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> coins = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int amount = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = coinChange(coins, amount);
        System.out.println(res);
    }
}
