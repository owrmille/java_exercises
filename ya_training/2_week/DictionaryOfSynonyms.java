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

        StringTokenizer st;
        Map<String, String> synonyms = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            st = new StringTokenizer(line);
            
            String word1 = st.nextToken();
            String word2 = st.nextToken();

            synonyms.put(word1, word2);
            synonyms.put(word2, word1);
        }

        String word = reader.readLine();
        writer.write(synonyms.get(word));
        
        reader.close();
        writer.close();
    }
}
