import java.util.Scanner;

public class Remover {

  public static int[] removeSmallest(int[] numbers) {
    if (numbers == null) {
        return null;
    }
    if (numbers.length == 0) {
        return new int[0];
    }

    int smallest = numbers[0];
    int idx = 0;
    for (int i = 1; i < numbers.length; i++) {
        if (smallest > numbers[i]) {
            smallest = numbers[i];
            idx = i;
        }
    }
    
    int[] numbersCopy = new int[numbers.length - 1];
    for (int i = 0; i < numbers.length; i++) {
        if (i < idx) {
            numbersCopy[i] = numbers[i];
        } else if (i > idx) {
            numbersCopy[i - 1] = numbers[i];
        }
    }
    return numbersCopy;
  }

  public static void main(String[] args) {
    int[] arr = {4, 1, 3, 8, 2, 1};
    for (int el : arr) {
        System.out.println(el);
    }
    System.err.println();

    int[] res = removeSmallest(arr);
    for (int el : res) {
        System.out.println(el);
    }
  }
}
