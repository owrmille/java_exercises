import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ConditionsAndLoops {
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger res = new BigInteger("1");
        BigInteger factor = new BigInteger("1");
        while (factor.compareTo(BigInteger.valueOf(value)) <= 0) {
            res = res.multiply(factor);
            factor = factor.add(BigInteger.valueOf(1));
        }
        return res;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[a1.length + a2.length];
        while (i < a1.length && j < a2.length) { 
            if (a1[i] <= a2[j]) {
                res[k++] = a1[i++];
            }
            else {
                res[k++] = a2[j++];
            }
        }
        while (i < a1.length) {
            res[k++] = a1[i++];
        }
        while (j < a2.length) {
            res[k++] = a2[j++];
        }
        return res;
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            String prefix = roles[i].concat(":");
            text.append(prefix).append("\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(prefix)) {
                    text.append(j + 1).append(")").append(textLines[j].substring(prefix.length())).append("\n");
                }
            }
            if (i != roles.length - 1) {
                text.append("\n");
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a task to run.");
        System.out.println("1 - Calculate Factorial.");
        System.out.println("2 - Merge Two Sorted Arrays.");
        System.out.println("3 - Arrange Texts by Roles.");
        System.out.println("0 - Exit.");

        int choice = Integer.parseInt(scanner.nextLine());
        switch(choice) {
            case 1 -> {
                System.out.println("Task: Calculate Factorial.");
                int value = Integer.parseInt(scanner.nextLine());
                System.out.println(factorial(value));
            }
            case 2 -> {
                System.out.println("Task: Merge Two Sorted Arrays.");
                int[] a1 = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int[] a2 = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                System.out.println();
                for (int el : a1) {
                    System.out.print(el + " ");
                }
                System.out.println();
                for (int el : a2) {
                    System.out.print(el + " ");
                }
                System.out.println();
                int[] res = mergeArrays(a1, a2);
                for (int el : res) {
                    System.out.print(el + " ");
                }
            }
            case 3 -> {
                System.out.println("Task: Arrange Texts by Roles.");
                int[] numLines = Arrays.stream(scanner.nextLine().split(" "))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                String[] roles = new String[numLines[0]];
                String[] textLines = new String[numLines[1]];

                String line = scanner.nextLine();
                if (line.equals("roles:")) {
                    for (int i = 0; i < numLines[0]; i++) {
                        line = scanner.nextLine();
                        roles[i] = line;
                    }
                }
            
                line = scanner.nextLine();
                if (line.equals("textLines:")) {
                    for (int i = 0; i < numLines[1]; i++) {
                        line = scanner.nextLine();
                        textLines[i] = line;
                    }
                }

                System.out.println();
                System.out.println(printTextPerRole(roles, textLines));
            }
            case 0 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}