import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Sales {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Map<String, Map<String, Long>> database = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line  = reader.readLine()) != null) {
            st = new StringTokenizer(line);

            String name = st.nextToken();
            String item = st.nextToken();
            long numberOfUnits = Long.parseLong(st.nextToken());

            Map<String, Long> items = database.computeIfAbsent(name, k -> new TreeMap<>());
            items.put(item, items.getOrDefault(item, 0L) + numberOfUnits);
        }

        for (Map.Entry<String, Map<String, Long>> client : database.entrySet()) {
            String name = client.getKey();
            sb.append(name).append(":\n");

            Map<String, Long> items = client.getValue();
            for (Map.Entry<String, Long> item : items.entrySet()) {
                sb.append(item.getKey()).append(' ').append(item.getValue()).append('\n');
            }

        }

        writer.write(sb.toString());
        
        reader.close();
        writer.close();
    }
}
