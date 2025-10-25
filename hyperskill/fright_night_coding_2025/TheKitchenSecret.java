import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheKitchenSecret {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("datasets/hyperskill-dataset-117360974.txt"))) {
            
            List<List<String>> instructions = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                instructions.add(Arrays.asList(input.split(",")));
            }
            // This size doesn't include empty line in the end of the file!
            System.out.println("Instructions number: " + instructions.size() + "\n---------");
            // for (int i = 0; i < instructions.size(); i++) {
            //     System.out.println("Instruction: " + instructions.get(i));
            // }

            String[][] matrix = { {"A", "B", "C", "D"}, {"E", "F", "G", "H"}, {"I", "J", "K", "L"}, {"M", "N", "O", "P"} };
            
            List<String> res  = new ArrayList<>();
            for (int i = 0; i < instructions.size(); i++) {
                int x = 0;
                int y = 0;
                for (String direction : instructions.get(i)) {
                    if (direction.equals("UP") && y > 0) {
                        y--;
                    } else if (direction.equals("DOWN") && y < 3) {
                        y++;
                    } else if (direction.equals("RIGHT") && x < 3) {
                        x++;
                    } else if (direction.equals("LEFT") && x > 0) {
                        x--;
                    }
                }
                res.add(matrix[y][x]);
            }

            // Scanner.getLine() reads all characters on the currently line, including the line terminator (if there is one), 
            // and then it discards the line terminator. Using this method, there is no way of knowing if the file ends with or 
            // without a line terminator. That's why we add "A" - it is for empty line as an instruction.
            res.add("A");
            // Alternative: 
            // It would make more sense to read and write the files as a stream of bytes, e.g. using InputStream.read(byte[]). 
            // Even better, use java.nio.file.Files.copy(Path source, OutputStream out)

            res.forEach(System.out::print);
            System.out.println("\nResult length: " + res.size());

        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
}
