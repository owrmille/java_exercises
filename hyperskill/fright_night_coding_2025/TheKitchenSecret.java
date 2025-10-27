import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* A strange keypad on the wall with letters instead of digits. It looked like this:

A B C D
E F G H
I J K L
M N O P

Apparently, whoever put this wall here wanted you to input an extremely long sequence on the keypad. 
But instead of giving you the code right away, they wrote down all movements of the finger you need 
to make in order to get to the proper button. UP means you need to put your finger one key up, LEFT 
one key left, RIGHT one key right, DOWN one key down.

Imagine the following example:

DOWN,LEFT,RIGHT,UP,UP,RIGHT

You always start at top left corner (on letter A) for each input. First, you go DOWN to E, then instruction 
wants you to go LEFT, but you can't, so you stay on E. Then you go RIGHT to F, UP to B, next UP is ignored 
because you can't get much higher. And finally, the last RIGHT puts you to C. So the first letter in the sequence is C.

After that you return back to A and start with the next instruction. Instructions are separated by \n.
 */
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
