
/* In this task, you will receive a map of the mansion as a dataset. 
# represents walls, . represents walkable floor,
P represents your starting point and G represents the garage. 
Your answer should be the shortest path in a format like 
the following: UDLRRLDU, where U is moving Up, D is moving Down, 
L is moving Left and R is moving Right.

Some layouts may have multiple shortest paths, any of them should be 
accepted.
 */

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class YouCanNotEscape {

    public static class Coordinate {
        private final int r;
        private final int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isPassableCell(List<List<Character>> grid, int r, int c) {
        char cell = grid.get(r).get(c);
        return cell != '#';
    }

    public static List<Coordinate> getNeighbours(Coordinate node, List<List<Character>> grid, int numRows, int numCols) {
        int row = node.r;
        int col = node.c;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        List<Coordinate> res = new ArrayList<>();
        for (int i = 0; i < deltaRow.length; i++) {
            int neighbourRow = row + deltaRow[i];
            int neighbourCol = col + deltaCol[i];
            if (neighbourRow >= 0 && neighbourRow < numRows &&
            neighbourCol >= 0 && neighbourCol < numCols &&
            isPassableCell(grid, neighbourRow, neighbourCol)) {
                res.add(new Coordinate(neighbourRow, neighbourCol));
            }
        }
        return res;
    }

    public static char getDirection(Coordinate cur, Coordinate next) {
        if (next.r > cur.r && cur.c == next.c) {
            return 'D';
        }
        if (next.r < cur.r && cur.c == next.c) {
            return 'U';
        }
        if (next.c < cur.c && cur.r == next.r) {
            return 'L';
        }
        if (next.c > cur.c && cur.r == next.r) {
            return 'R';
        }
        return 'X';
    }

    // my initial solution didn't store parents' data for each suitable neighbour - 
    // it is important to use it to backtrack the route once the escape is found
    public static List<Character> findShortestPath(List<List<Character>> grid, Coordinate start, Coordinate finish) {
        int numRows = grid.size();
        int numCols = grid.get(0).size();

        List<Character> directions = new ArrayList<>();
        if (start.r == finish.r && start.c == finish.c) return directions;

        // parent pointers
        int[][] prevR = new int[numRows][numCols];
        int[][] prevC = new int[numRows][numCols];
        for (int r = 0; r < numRows; r++) {
            Arrays.fill(prevR[r], -1);
            Arrays.fill(prevC[r], -1);
        }

        Deque<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);
        // mark visited
        grid.get(start.r).set(start.c, '#');

        while (!queue.isEmpty()) {
            Coordinate node = queue.pop();
            List<Coordinate> neighbours = getNeighbours(node, grid, numRows, numCols);
            for (Coordinate neighbour :  neighbours) {
                // skip already visited and walls
                if (grid.get(neighbour.r).get(neighbour.c) == '#') continue;

                // set parent (to later restore the shortest route from finish to start)
                prevR[neighbour.r][neighbour.c] = node.r;
                prevC[neighbour.r][neighbour.c] = node.c;

                // reached finish? reconstruct and return
                if (neighbour.r == finish.r && neighbour.c == finish.c) {
                    List<Character> path = new ArrayList<>();
                    int r = finish.r, c = finish.c;
                    while (!(r == start.r && c == start.c)) {
                        int pr = prevR[r][c], pc = prevC[r][c];
                        path.add(getDirection(new Coordinate(pr, pc), new Coordinate(r, c)));
                        r = pr; c = pc;
                    }
                    Collections.reverse(path);
                    return path;
                }

                // continue BFS
                queue.add(neighbour);
                grid.get(neighbour.r).set(neighbour.c, '#');  // mark visited
            }
        }
        return directions;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/iasemintopchu/Desktop/backend core/java_exercises/hyperskill/fright_night_coding_2025/datasets/hyperskill-dataset-117505838.txt"))) {
           List<List<Character>> grid = new ArrayList<>();

           int[] start = new int[2];
           Arrays.fill(start, 0);
           boolean foundP = false;

           int[] finish = new int[2];
           Arrays.fill(finish, 0);
           boolean foundG = false;

           int i = 0;
           while (scanner.hasNext()) {
            List<Character> row = new ArrayList<>(scanner.nextLine().chars().mapToObj(c -> (char)c).toList());
            grid.add(row);
            if (row.contains('P') && !foundP) {
                start[0] = i;
                start[1] = row.indexOf('P');
                foundP = true;
            }
            if (row.contains('G') && !foundG) {
                finish[0] = i;
                finish[1] = row.indexOf('G');
                foundG = true;
            }
            i++;
           }

        List<Character> shortestPathDirections = findShortestPath(grid, new Coordinate(start[0], start[1]), new Coordinate(finish[0], finish[1]));
        System.out.println("Shortest path directions:\n" + shortestPathDirections.stream().map(String::valueOf).collect(Collectors.joining("")));
        } catch (Exception e) {
            System.err.println("Error! " + e.toString());
        }
    }
}
