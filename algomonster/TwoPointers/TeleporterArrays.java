import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeleporterArrays {
    public static final int MODULO = 1000000007;
    public static int maximumScore(List<Integer> arr1, List<Integer> arr2) {
        int ptr1 = 0, ptr2 = 0;
        int n1 = arr1.size(), n2 = arr2.size();
        long result = 0;
        long subSum1 = 0, subSum2 = 0;

        while (ptr1 != n1 || ptr2 != n2) {
            if (ptr1 < n1 && ptr2 < n2 && arr1.get(ptr1).equals(arr2.get(ptr2))) {
                result += Math.max(subSum1, subSum2) + arr1.get(ptr1);
                result %= MODULO;
                ptr1++;
                ptr2++;
                subSum1 = 0;
                subSum2 = 0;
                continue;
            }
            if (ptr1 == n1 || (ptr2 != n2 && arr1.get(ptr1) > arr2.get(ptr2))) {
                subSum2 += arr2.get(ptr2);
                ptr2++;
            } else {
                subSum1 += arr1.get(ptr1);
                ptr1++;
            }
        }
        result +=  Math.max(subSum1, subSum2);
        result %= MODULO;
        return (int)result;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr1 = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> arr2 = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        System.out.println(maximumScore(arr1, arr2));
    }
}
