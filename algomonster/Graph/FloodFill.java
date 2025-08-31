import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FloodFill {
    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static List<Coordinate> getNeighbours(Coordinate root, List<List<Integer>> image, int rootColor, int numRows, int numCols) {
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        List<Coordinate> res = new ArrayList<>();
        for (int i = 0; i < deltaRow.length; i++) {
            int neighbourRow = deltaRow[i] + root.r;
            int neighbourCol = deltaCol[i] + root.c;
            if (neighbourRow >= 0 && neighbourRow < numRows && neighbourCol >= 0 && neighbourCol < numCols) {
                if (image.get(neighbourRow).get(neighbourCol) == rootColor) {
                    res.add(new Coordinate(neighbourRow, neighbourCol));
                }
            }
        }
        return res;
    }

    private static void bfs(List<List<Integer>> image, Coordinate root, int replacement, int numRows, int numCols) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[numRows][numCols];
        queue.add(root);
        visited[root.r][root.c] = true;
        int rootColor = image.get(root.r).get(root.c);
        image.get(root.r).set(root.c, replacement);
        while (queue.size() > 0) {
            Coordinate node = queue.pop();
            List<Coordinate> neighbours = getNeighbours(node, image, rootColor, numRows, numCols);
            for (Coordinate neighbour : neighbours) {
                if (visited[neighbour.r][neighbour.c]) continue;
                image.get(neighbour.r).set(neighbour.c, replacement);
                queue.add(neighbour);
                visited[neighbour.r][neighbour.c] = true;
            }
        }
    }

    public static List<List<Integer>> floodFill(int r, int c, int replacement, List<List<Integer>> image) {
        int numRows = image.size();
        int numCols = image.get(0).size();
        bfs(image, new Coordinate(r, c), replacement, numRows, numCols);
        return image;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int replacement = Integer.parseInt(scanner.nextLine());
        int imageLen = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> image = new ArrayList<>();
        for (int i = 0; i < imageLen; i++) {
            image.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<List<Integer>> res = floodFill(r, c, replacement, image);
        System.out.println("--------");
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }    
}
