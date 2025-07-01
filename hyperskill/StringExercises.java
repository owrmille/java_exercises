import java.util.Scanner;

class StringExercises {
    public static void trimAndCompare() {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine().replaceAll(" ", "");
        String second = scanner.nextLine().replaceAll(" ", "");
        scanner.close();
        System.out.println(first.equals(second));
    }

    public static void appendAndPrint() {
        System.out.println(1 + 1 + "2" + 2);
        System.out.println(2 + 2 + "2");
        System.out.println("2" + 2 + 2);
        System.out.println("2" + 2 + 1 + 1);
    }

    public static void checkBurgs() {
        Scanner scanner = new Scanner(System.in);
        boolean res = scanner.nextLine().endsWith("burg");
        scanner.close();
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        // trimAndCompare();
        // appendAndPrint();
        // checkBurgs();
    }
}