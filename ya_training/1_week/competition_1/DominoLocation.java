import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DominoLocation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> dims = Arrays.asList(reader.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int n = dims.get(0);  // # of rows
        int m = dims.get(1);  // col
        
        Character[][] grid = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') {
                    if (i+1 < n && grid[i+1][j] == '.') {
                        cnt++;
                    }
                    if (j+1 < m && grid[i][j+1] == '.') {
                        cnt++;
                    }
                    grid[i][j] = '#';
                }
            }
        }
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */
        writer.write(String.valueOf(cnt));
        reader.close();
        writer.close();
    }
}