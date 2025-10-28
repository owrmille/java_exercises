import java.io.File;
import java.util.Scanner;

/* You will receive a decimal phone number as your dataset. 
Respond with a number of overflows and a 32-bit binary 
unsigned integer in that order, divided by a single comma. 
If the decimal is too big to fit in the 32-bit binary, 
increase the number of overflows and subtract decimal value 
at which overflow occurs from the phone number. Then try to 
convert it again, until it does not overflow. If the binary 
has any leading zeroes, remove them. 
*/

public class ThePhoneCall {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/iasemintopchu/Desktop/backend core/java_exercises/hyperskill/fright_night_coding_2025/datasets/hyperskill-dataset-117454715.txt"))) {
            long input = (long)scanner.nextLong();
            int iter = 0;
            double base = Math.pow(2, 32);
            while (input > base) {
                iter++;
                input -= (long)base;
            }
            System.out.println(iter + "," + Long.toBinaryString(input));
        } catch (Exception e) {
            System.err.println("Error! " + e.toString());
        }
    }
}
