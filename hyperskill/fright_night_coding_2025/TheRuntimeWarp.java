import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* You will receive a list of four-dimensional vectors, where each vector consists of four integers. Your goal is to calculate the total distance traveled through these vectors in sequence:
1. Calculate the Euclidean distance between each consecutive pair of vectors (first to second, second to third, third to fourth, etc.).
2. If any distance is not a whole number, round it up to the nearest integer.
3. Add all the rounded up distances together to get your final answer.

You can use the Euclidean distance formula for 4D vectors: https://en.wikipedia.org/wiki/Euclidean_distance
 */
public class TheRuntimeWarp {
    public static long calculateTotalDistance(List<List<Integer>> coords) {
        long totalDistance = 0;
        for (int i = 0; i < coords.size() - 1; i++) {
            int intermediateSum = 0;
            for (int j = 0; j < 4; j++) {
                intermediateSum += Math.pow((double)coords.get(i + 1).get(j) - (double)coords.get(i).get(j), 2);
            }
            totalDistance += Math.ceil(Math.sqrt(intermediateSum));
        }
        return totalDistance;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/iasemintopchu/Desktop/backend core/java_exercises/hyperskill/fright_night_coding_2025/datasets/hyperskill-dataset-117421667.txt"))) { // hyperskill-dataset-117421417
            List<List<Integer>> coords = new ArrayList<>();
            while (scanner.hasNextLine()) {
                coords.add(Arrays.asList(scanner.nextLine().split(",")).stream().map(Integer::parseInt).collect(Collectors.toList()));
            }
            long result = calculateTotalDistance(coords);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
}
