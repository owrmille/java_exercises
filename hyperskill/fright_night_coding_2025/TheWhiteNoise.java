import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TheWhiteNoise {
    // hyperskill-dataset-117293954
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("datasets/hyperskill-dataset-117293954.txt"))) {
            String content = scanner.next();
            int sumOfDegrees = Arrays.asList(content.split(",")).stream().map(Integer::parseInt).reduce(0, Integer::sum);
            int res = (sumOfDegrees + 360) % 360;
            System.out.println(res);
        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
}
