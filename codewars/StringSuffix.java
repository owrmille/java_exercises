import java.util.Scanner;

public class StringSuffix {
    public static boolean checkIfSuffix(String str, String ending) {
        return str.endsWith(ending);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");
            boolean isSuffix = checkIfSuffix(input[0], input[1]);
            System.out.println(isSuffix);
        }
    }
}
