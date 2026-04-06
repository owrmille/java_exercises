import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DictionaryOfSynonyms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> dict1 = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            StringTokenizer st = new StringTokenizer(line);
            
            String word1 = st.nextToken();
            String word2 = st.nextToken();

            dict1.put(word1, word2);
            dict1.put(word2, word1);
        }

        String word = reader.readLine();
        writer.write(dict1.get(word));
        
        reader.close();
        writer.close();
    }
}
