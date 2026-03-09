import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DecodingSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> res = new ArrayList<>();
        String code = reader.readLine();
        int i = 0;
        while (i < code.length()) {
            if ((code.charAt(i) == '1' || code.charAt(i) == '2') && i+2<code.length() && code.charAt(i+2) == '#') {
                int n = Integer.valueOf(code.substring(i, i+2));
                writer.write((char)n+96);
                i += 3;
            } else {
                int n = Integer.valueOf(code.substring(i, i+1));
                writer.write((char)n+96);
                i++;
            }
        }
        /*
        Example: -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}