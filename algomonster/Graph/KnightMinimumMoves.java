import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class KnightMinimumMoves {
    public static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this == obj) return true;
            if (!(obj instanceof Coordinate)) return false;
            Coordinate other = (Coordinate)obj;
            return other.r == r && other.c == c;
        }
    }

    private static List<Coordinate> getNeighbours(Coordinate node) {
        int[] deltaRow = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] deltaCol = {-1, 1, 2, 2, 1, -1, -2, -2};
        List<Coordinate> neighbours = new ArrayList<>();
        for (int i = 0; i < deltaRow.length; i++) {
            int neighbourRow = node.r + deltaRow[i];
            int neighbourCol = node.c + deltaCol[i];
            neighbours.add(new Coordinate(neighbourRow, neighbourCol));
        }
        return neighbours;
    }

    private static int bfs(Coordinate start, int x, int y) {
        int moves = 0;
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        HashSet<Coordinate> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Coordinate node = queue.pop();
                if (node.c == x && node.r == y) return moves;
                List<Coordinate> neighbours = getNeighbours(node);
                for (Coordinate neighbour : neighbours) {
                    if (visited.contains(neighbour)) continue;
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
            moves++;
        }
        return moves;
    }

    public static int getKnightShortestPath(int x, int y) {
        return bfs(new Coordinate(0, 0), x, y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = getKnightShortestPath(x, y);
        System.out.println(res);
    }
}
