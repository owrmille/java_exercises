import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NumberSeenBefore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = reader.readLine();

        if (input == null || input.isEmpty()) {
            reader.close();
            writer.close();
            return;
        }

        Set<Integer> seen = new HashSet<>();
        StringTokenizer st = new StringTokenizer(input);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (seen.contains(num)) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
                seen.add(num);
            }
        }
        writer.write(sb.toString());
        reader.close();
        writer.close();
    }
}