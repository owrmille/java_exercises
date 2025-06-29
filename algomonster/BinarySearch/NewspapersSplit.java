import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class NewspapersSplit {
    public static int splitNewspapers(List<Integer> times, int numWorkers) {
        int low = Collections.max(times);
        int high = 0;
        int minPossibleVal = -1;
        for (int time : times) {
            high += time;
        }
        while (low <= high) {
            int mid = (low + high)/2;
            if (feasible(times, numWorkers, mid)) {
                minPossibleVal = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minPossibleVal;
    }

    public static boolean feasible(List<Integer> inputTimes, int inputNumWorkers, int limit) {
        int time = 0, numWorkers = 0;
        for (int inputT : inputTimes) {
            if (inputT + time > limit) {
                time = 0;
                numWorkers++;
            }
            time += inputT;
        }
        if (time != 0) numWorkers++;
        return numWorkers <= inputNumWorkers;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(", "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of times: ");
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.print("Enter number of workers: ");
        int numWorkers = scanner.nextInt();
        scanner.close();
        System.out.println("Minimum possible value of time that a workes can have: " + splitNewspapers(arr, numWorkers));
    }
}