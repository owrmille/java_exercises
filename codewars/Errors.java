import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Errors {
    public static LinkedHashMap<String, Integer> mapErrors() {
        Map<String, Integer> map = new HashMap<>();

        File file = new File("data/server.log");

        final String keyword = "ERROR: ";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith(keyword)) {
                    String error = line.substring(keyword.length()).toLowerCase();
                    map.put(error, map.getOrDefault(error, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        LinkedHashMap<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sorted.put(entry.getKey(), entry.getValue());
        }

        return sorted;
    }

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = mapErrors();
        System.out.print(map);
    }
}
