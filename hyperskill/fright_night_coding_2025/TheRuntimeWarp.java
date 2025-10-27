import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
