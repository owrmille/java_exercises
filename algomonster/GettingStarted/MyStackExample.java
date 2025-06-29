import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MyStackExample {
    public static List<Integer> execute(List<String> operations) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (String instruction : operations) {
            if (instruction.equals("peek")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.get(stack.size() - 1));
                }
            } else if (instruction.equals("pop")) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(Integer.parseInt(instruction.substring(5)));
            }
        }
        return stack;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberLines = Integer.parseInt(scanner.nextLine());
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < numberLines; i++) {
            operations.add(scanner.nextLine());
        }
        scanner.close();
        List<Integer> res = execute(operations);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
} 