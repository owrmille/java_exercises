import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsExercises {
    public static <T> Set<T> findSymmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> symmetricDifference = new HashSet<>();
        for (T element : set1) {
            if (!set2.contains(element)) {
                symmetricDifference.add(element);
            }
        }
        for (T element : set2) {
            if (!set1.contains(element)) {
                symmetricDifference.add(element);
            }
        }
        return symmetricDifference;
    }

    public static <T> Set<T> alternativeFindSymmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> symmetricDifference = new HashSet<>();
        set1.forEach(x -> { if (!set2.contains(x)) symmetricDifference.add(x); });
        set2.forEach(x -> { if (!set1.contains(x)) symmetricDifference.add(x); });
        return symmetricDifference;
    }

    public static List<Integer> removeNumbersOnEvenPositionsAndReverse() throws Exception {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; scanner.hasNext(); i++) {
            int value = scanner.nextInt();
            if (i % 2 != 0) {
                numbers.add(value);
            }
        }
        Collections.reverse(numbers);
        return numbers;
    }

    public static void main(String[] args) throws Exception {
        // String
        Set<String> set1 = new HashSet<>(Arrays.asList("sun", "fox", "orange"));
        Set<String> set2 = new HashSet<>(Arrays.asList("orange", "sun", "ball"));
        System.out.println(alternativeFindSymmetricDifference(set1, set2));

        // Integer
        Set<Integer> set3 = new HashSet<>(Arrays.asList(42, 1, 108));
        Set<Integer> set4 = new HashSet<>(Arrays.asList(0, 1));
        System.out.println(alternativeFindSymmetricDifference(set3, set4));

        List<Integer> numbers = removeNumbersOnEvenPositionsAndReverse();
        String modifiedNumbers = numbers.stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.joining(" "));
        System.out.println(modifiedNumbers);
    }
}
