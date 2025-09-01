import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WallsAndGatesZombieInMatrix {
    public static class Coords {
        int r;
        int c;

        public Coords(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Coords add(Coords other) {
            return new Coords(r + other.r, c + other.c);
        }
    }

    public static List<Coords> directions = List.of(new Coords(0,1), new Coords(1, 0), new Coords(-1, 0), new Coords(0, -1));

    public static List<List<Integer>> mapGateDistances(List<List<Integer>> map) {
        ArrayDeque<Coords> deque = new ArrayDeque<>();
        int n = map.size();
        int m = map.get(0).size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map.get(i).get(j) == 0) {
                    deque.offer(new Coords(i, j));
                }
            }
        }
        while (!deque.isEmpty()) {
            Coords currentPos = deque.poll();
            for (Coords delta : directions) {
                Coords newPos = currentPos.add(delta);
                if (newPos.r >= 0 && newPos.r < n && newPos.c >= 0 && newPos.c < m) {
                    if (map.get(newPos.r).get(newPos.c) == Integer.MAX_VALUE) {
                        map.get(newPos.r).set(newPos.c, 1 + map.get(currentPos.r).get(currentPos.c));
                        deque.add(newPos);
                    }
                }
            }
        }
        return map;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            map.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<List<Integer>> res = mapGateDistances(map);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
