import java.util.*;

public class Practice3b {
    public static List<String> returnTopKWordsByFreqs(Map<String, Integer> freq, int k) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());  // O(freq_size)

        entries.sort((e1, e2) -> {  // O(freq_size log freq_size)
            int f1 = e1.getValue();
            int f2 = e2.getValue();
            if (f1 != f2) {
                return Integer.compare(f2, f1);
            }
            return e1.getKey().compareToIgnoreCase(e2.getKey());
        });

        List<String> topK = new ArrayList<>();
        for (int i = 0; i < entries.size() && i < k; i++) {  // O(k)
            topK.add(entries.get(i).getKey());
        }
        
        return topK;
    }

    public static void main(String[] args) {
        String text = "Lucene lucene search java Search Kotlin java java";
        int k = 3;
        Map<String, Integer> freq = Practice3a.countFreqs(text);
        List<String> topKWords = returnTopKWordsByFreqs(freq, k);
        System.out.println(topKWords);
    }
}

// O(freq_size log freq_size)