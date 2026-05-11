import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountOfPosSumOfNeg {
    //return an array with count of positives and sum of negatives
    public static int[] countPositivesSumNegatives(int[] input)
    {
        if (input == null || input.length == 0) return new int[0];

        // commented out cause walking twice through array:
        // int countPos = (int) Arrays.stream(input).filter(n -> n > 0).count();
        // int sumNeg = Arrays.stream(input).filter(n -> n < 0).sum();

        int countPos = 0, sumNeg = 0;

        for (int n : input) {
            if (n > 0) countPos++;
            else sumNeg += n;
        }
        
        return new int[] {countPos, sumNeg};
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Arrays.asList() : List.of(s.split(", "));
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] nums = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            int[] res = countPositivesSumNegatives(nums);
            System.out.println(res[0] + ", " + res[1]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
