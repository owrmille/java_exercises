import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* There are 16 letters on each line. 8 left and 8 right. 
14 of them, 7 left and 7 right, have an exact pair.
2 of them, on each side, do not. Your answer is the pairless letters.

Example dataset:

HVbNpDBmBNDVbmHi

The answer here would be pi, since p and i are the two letters without 
pairs. Notice that lowercase and uppercase letters are treated as 
different letters.
*/


public class TheGoodEnding {
    public static List<String> findPairlessLetters(List<String> data) {
        List<String> pairlessLetters = new ArrayList<>();
        int start, end;
        for (int i = 0; i < data.size(); i++) {
            String str = data.get(i);
            for (int j = 0; j < str.length(); j++) {
                if (j >= 8) {
                    start = 0;
                    end = 8;
                } else {
                    start = 8;
                    end = 16;
                }
                if (!str.substring(start, end).contains(str.substring(j, j + 1))) {
                    pairlessLetters.add(str.substring(j, j + 1));
                }
            }
        }

        return pairlessLetters;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/iasemintopchu/Desktop/backend core/java_exercises/hyperskill/fright_night_coding_2025/datasets/hyperskill-dataset-117537296.txt"))) {
            List<String> data = new ArrayList<>();
            while (scanner.hasNext()) {
                data.add(scanner.nextLine());
            }

            List<String> pairlessLetters = findPairlessLetters(data);
            for (int i = 0; i < pairlessLetters.size(); i++) {
                System.out.print(pairlessLetters.get(i));
            }

        } catch (Exception e) {
            System.err.println("Error! " + e.toString());
        }
    }
}
