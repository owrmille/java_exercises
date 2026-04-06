import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Turtles {
    public static boolean isValidMove(Set<Integer> ahead, Set<Integer> behind, int aheadNum, int behindNum, int n) {
        return !ahead.contains(aheadNum) && !behind.contains(behindNum) &&
                aheadNum >= 0 && behindNum >= 0 &&
                aheadNum <= n - 1 && behindNum <= n - 1 &&
                aheadNum + behindNum == n - 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> ahead = new HashSet<>();
        Set<Integer> behind= new HashSet<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();

            StringTokenizer st = new StringTokenizer(line);

            int aheadNum = Integer.parseInt(st.nextToken());
            int behindNum = Integer.parseInt(st.nextToken());

            if (isValidMove(ahead, behind, aheadNum, behindNum, n)) {

                ahead.add(aheadNum);
                behind.add(behindNum);
            }
            
        }

        int result = (ahead.size() == behind.size() ? ahead.size() : 0);
        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }
}