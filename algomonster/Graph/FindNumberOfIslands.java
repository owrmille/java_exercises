import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindNumberOfIslands {
    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static List<Coordinate> getNeighbours(Coordinate node, int numRows, int numCols) {
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        List<Coordinate> res = new ArrayList<>();
        for (int i = 0; i < deltaRow.length; i++) {
            int neighbourRow = deltaRow[i] + node.r;
            int neighbourCol = deltaCol[i] + node.c;
            if (neighbourRow >= 0 && neighbourRow < numRows && neighbourCol >= 0 && neighbourCol < numCols) {
                res.add(new Coordinate(neighbourRow, neighbourCol)); 
            }
        }
        return res;
    }

    private static void bfs(List<List<Integer>> grid, Coordinate root, int numRows, int numCols) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        grid.get(root.r).set(root.c, 0);
        while (queue.size() > 0) {
            Coordinate node = queue.pop();
            List<Coordinate> neighbours = getNeighbours( node, numRows, numCols);
            for (Coordinate neighbour : neighbours) {
                if (grid.get(neighbour.r).get(neighbour.c) == 0) continue;
                queue.add(neighbour);
                grid.get(neighbour.r).set(neighbour.c, 0);
            }
        }
    }

    public static int countNumberOfIslands(List<List<Integer>> grid) {
        int numRows = grid.size();
        int numCols = grid.get(0).size();
        int count = 0;
        // start bfs for each individual cell in the grid
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (grid.get(r).get(c) == 0) continue;
                bfs(grid, new Coordinate(r, c), numRows, numCols);
                // each bfs call finds 1 connected island -> increment count
                count++;
            }
        }
        return count;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gridLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < gridLength; i++) {
            grid.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = countNumberOfIslands(grid);
        System.out.println(res);
    }
}
