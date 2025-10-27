import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* You are doing well so far. Hang in there. This piano is special. 
I retrieved it from some abandoned school. You see, it had some 
stupid bird-related puzzle attached to it. I got rid of all that 
boring stuff, and reprogrammed it to use another sequence. 
Your clue is on the other side of this note. 
Find the shortest sequence that contains all 7 notes, and play it
to get the key.

The seven notes are A, B, C, D, E, F, G.

For example, with the following dataset: ADCEEFAGABDC the answer 
would be EFAGABDC, since it has all 7 notes in it and it's the 
shortest sequence like that.

In the case of several sequences of the same length, you will 
need to choose the one that appears in the dataset first.
 */


public class ThePianoPuzzle {
    public static List<String> letters = Stream.of("A", "B", "C", "D", "E", "F", "G").collect(Collectors.toList());
    
    public static boolean hasFullSequence(Map<String, Integer> counter) {
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 0) {
                return false;
            } 
        }
        return true;
    }

    public static List<String> findShortestSequence(List<String> data) {
        Map<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < letters.size(); i++) {
            counter.put(letters.get(i), 0);
        }

        int left = 0;
        int right = 0;
        int dataSize = data.size();
        List<String> result = new ArrayList<>();
        int smallestSizeOfSequence = dataSize;
        int optimalLeft = 0;
        int optimalRight = dataSize;
        while (right < dataSize) {
            
            // we will cut the sequence from the left (wanting to get the shortest possible one that is valid) till it's not valid anymore
            while (hasFullSequence(counter)) {
                // this "strictly less" helps to filter valid solutions of the same length that appears later and store the first one of them
                if (right-left < smallestSizeOfSequence) {
                    smallestSizeOfSequence = right-left;
                    optimalLeft = left;
                    optimalRight = right;
                }
                // decrease the counter of the value at index left, cause we are moving it forward
                if (left < dataSize) {
                    counter.put(data.get(left), counter.get(data.get(left)) - 1);
                }
                // moving forward
                left++;
                
                // we don't need to increase counter while moving left forward, 
                // cause these elements were already counted by right
            }
            if (right < dataSize) {
                counter.put(data.get(right), counter.get(data.get(right)) + 1);
            }
            right++;
            
        }
        return data.subList(optimalLeft, optimalRight);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/iasemintopchu/Desktop/backend core/java_exercises/hyperskill/fright_night_coding_2025/datasets/hyperskill-dataset-117383259.txt"))) {
            List<String> data = scanner.next().chars().mapToObj(c -> String.valueOf((char)c)).toList();
            System.out.println("Input data:");
            data.forEach(System.out::print);
            System.out.print("\n---------------------------\n");
            System.out.println("Solution:");
            List<String> res = findShortestSequence(data);
            res.forEach(System.out::print);
        } catch (Exception e) {
            System.err.println("Error!\n" + e.toString() + "\nCause:\n" + e.getCause());
        }
    }
}
