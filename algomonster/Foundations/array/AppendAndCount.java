import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class AppendAndCount {
    public static int appendAndCount(List<Integer> arr, List<Integer> values) {
        int cnt = arr.size();
        for (int i = 0; i < values.size(); i++) {
            arr.add(values.get(i));
            cnt++;
        }
        return cnt;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> values = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = appendAndCount(arr, values);
        System.out.println(res);
    }
}
