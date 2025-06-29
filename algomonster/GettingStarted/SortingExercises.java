
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class SortingExercises {
    public static void main(String[] args) {
        String[] words = {"cherry", "kiwi", "orange", "apple", "strawberry", "banana", "peach"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 7, 1, 9, 10, 8, 4));
        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println(numbers);
    }
}