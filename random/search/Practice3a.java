import java.util.*;

public class Practice3a {
    public static Map<String, Integer> countFreqs(String text) {
        Map<String, Integer> freq = new HashMap<>();
        String[] tokens = text.toLowerCase().split("[^a-z0-9]+");  // O(text_length)

        for (String t : tokens) {  // O(tokens_num)
            if (t.isEmpty()) continue;
            freq.merge(t, 1, Integer::sum);  // O(1)
        }

        return freq;
    }

    public static void main(String[] args) {
        String text = "Lucene is a search library. A library for searching searchable items.";
        Map<String, Integer> freq = countFreqs(text);
        System.out.println(freq);
    }
}

// O(text_length) if text_length proportional to tokens_num