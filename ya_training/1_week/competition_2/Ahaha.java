import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ahaha {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(reader.readLine());
        String text = reader.readLine();
        int maxCnt = 0;
        int cnt = 0;
        int k;
        boolean isFirst = true;
        for (int i = 0; i < n; i++) {

            cnt = 0;
            isFirst = true;
            while (i < n && text.charAt(i) == 'a' || text.charAt(i) == 'h') {
                
                if (isFirst) {
                    cnt++;
                    isFirst = false;
                }
                if (i + 1 < n && text.charAt(i) != text.charAt(i + 1) && (text.charAt(i + 1) == 'a' || text.charAt(i + 1) == 'h')) {
                    cnt++;
                    i++;
                } else {
                    break;
                }
            
            
            }
            if (maxCnt < cnt) maxCnt = cnt;
        }
        writer.write(String.valueOf(maxCnt));
        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        reader.close();
        writer.close();
    }
}
