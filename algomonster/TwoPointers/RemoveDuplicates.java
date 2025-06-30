
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class RemoveDuplicates {
    public static int removeDuplicates(List<Integer> arr) {
        int slow = 0;
        for (int fast = 0; fast < arr.size(); fast++) {
            if (!arr.get(fast).equals(arr.get(slow))) {
                slow++;
                arr.set(slow, arr.get(fast));
            }
        }
        return slow + 1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter a sequence of values: ");
       List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
       scanner.close();
       System.out.println("New length: " + removeDuplicates(arr));
       System.out.println("Modifed array: " + arr);
    }
}