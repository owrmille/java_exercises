import java.util.Arrays;
import java.util.Scanner;

class ArrayExercises {
    public static int findSumStartingFromVal(int size, int[] arr, int val) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] > val) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void testFindSumStartingFromVal() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        int val = scanner.nextInt();
        System.out.println(findSumStartingFromVal(size, arr, val));
        scanner.close();
    }

    public static boolean isAlphabeticallyOrdered(String input) {
        String[] arr = input.split(" ");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void testIsAlphabeticallyOrdered() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isAlphabeticallyOrdered(scanner.nextLine()));
        scanner.close();
    }

    public static void addValueByIndex(long[] arr, int idx, long value) {
        if (idx < 0 || arr == null || arr.length == 0) {
            return;
        }
        arr[idx] += value;
    }

    public static void testAddValueByIndex() {
        Scanner scanner = new Scanner(System.in);
        long[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        int index = scanner.nextInt();
        long value = scanner.nextLong();
        addValueByIndex(array, index, value);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        scanner.close();
    }

    public static void main(String[] args) {
        // testAddValueByIndex();
        // testIsAlphabeticallyOrdered();
        testFindSumStartingFromVal();
    }
}