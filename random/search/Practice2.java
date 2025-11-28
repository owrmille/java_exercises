import java.util.*;

public class Practice2 {
    public static List<String> returnTop3(List<String> words) {
        List<String> sortedWords = new ArrayList<>(words);  // copying - O(n)

        sortedWords.sort((s1, s2) -> {  // O(n log n)
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            return s1.compareToIgnoreCase(s2);
        });
        return sortedWords.subList(0, Math.min(3, words.size()));  // O(1)
    }

    public static void main(String[] args) {
        List<String> words = List.of("Lucene", "Search", "Java", "Kotlin");
        List<String> top3 = returnTop3(words);
        System.out.println(top3);
    }
}

// O(n log n)