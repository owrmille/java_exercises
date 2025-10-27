import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/* It looked like some madman was trying to make the TV work by randomly tilting the wire, scrupulously writing down 
every movement in degrees. You felt a sudden urge to set it right. But there are hundreds of precise inputs in the notebook! 
It would be much easier to just calculate all movements with a simple program and make just one proper turn. 
You opened your handy laptop again.

Remember several properties of degrees:

- 360 degrees equal a full turn. So, for example, 390 degrees is the same as 30 degrees.

- Counterclockwise (negative degrees) movement also falls somewhere on the 360 degrees scale. So, for example, 
-40 degrees is the same as 320 degrees.

Given that information, your answer should be a number between 0 and 359.
 */
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
