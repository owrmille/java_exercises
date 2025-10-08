
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SlidingPuzzle {
    // position - "list with lists" form
    // state - number form
    public static List<Integer> rowDirections = List.of(1, -1, 0, 0);
    public static List<Integer> colDirections = List.of(0, 0, 1, -1);

    public static int targetState = 123450;

    public static int serialize(List<List<Integer>> pos) {
        int state = 0;
        for (List<Integer> row : pos) {
            for (int el : row) {
                state *= 10;
                state += el;
            }
        }
        return state;
    }

    public static List<List<Integer>> deserialize(int state) {
        List<List<Integer>> pos = new ArrayList<>();
        // just creating the outer list (pos) is not enough — you must also create and add the inner lists (the rows).
        // or you will get an IndexOutOfBoundsException (for pos.get(0).add(1);) because pos does not have any elements yet.
        pos.add(new ArrayList<>());
        pos.add(new ArrayList<>());

        int exponent;
        for (int i = 1; i >= 0 ; i--) {
            for (int j = 2; j >= 0 ; j--) {
                exponent = i * 3 + j;
                int digit = state / (int)Math.pow(10, exponent) % 10;
                pos.get(1 - i).add(digit);
            }
        }
        return pos;
    }

    public static int slidingPuzzle(List<List<Integer>> initPos) {
        int initState = serialize(initPos);
        if (initState == targetState) {
            return 0;
        }
        Deque<Integer> movesQueue = new ArrayDeque<>();
        HashMap<Integer, Integer> movesMap = new HashMap<>();
        movesQueue.offer(initState);
        movesMap.put(initState, 0);
        while (!movesQueue.isEmpty()) {
            int topState = movesQueue.poll();
            // find position of "0"
            List<List<Integer>> topPos = deserialize(topState);
            int row = 0, col = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (topPos.get(i).get(j) == 0) {
                        row = i;
                        col = j;
                    }
                }
            }

            // consider moves in all 4 directions (up, down, to the right, to the left)
            for (int i = 0; i < rowDirections.size(); i++) {
                int deltaRow = rowDirections.get(i);
                int deltaCol = colDirections.get(i);
                int newRow = row + deltaRow;
                int newCol = col + deltaCol;
                // check if new indices are valid
                if ((newRow >= 0 && newRow < 2) && (newCol >= 0 && newCol < 3)) {
                    List<List<Integer>> newPos = deserialize(topState);
                    // switch two numbers from old and new position
                    newPos.get(newRow).set(newCol, topPos.get(row).get(col));  // there is no erasure of previous value, cause we are reading from "read-only" topPos
                    newPos.get(row).set(col, topPos.get(newRow).get(newCol));
                    int newState = serialize(newPos);
                    // if newState is not in map -> add it and num. of steps to map and queue
                    if (!movesMap.containsKey(newState)) {
                        movesMap.put(newState, movesMap.get(topState) + 1);
                        movesQueue.offer(newState);
                        // if found target, return its num. of steps
                        if (newState == targetState) {
                            return movesMap.get(newState);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initPosLen = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> initPos = new ArrayList<>();
        for (int i = 0; i < initPosLen; i++) {
            initPos.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = slidingPuzzle(initPos);
        System.out.println(res);
    }
}
