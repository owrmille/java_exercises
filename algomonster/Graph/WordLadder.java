import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordLadder {
    public static Set<String> unvisitedWords = new HashSet<>();
    public static char[] ALPHABET = new char[26];
    static {
        for (int i = 0; i < 26; i++) {
            ALPHABET[i] = (char)(i + 'a');
        }
    }

    public static List<String> getNeighbours(String word) {
        List<String> unvisitedNeighbours = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c : ALPHABET) {
                StringBuilder newWord = new StringBuilder(word.length());
                newWord.append(word.substring(0, i));
                newWord.append(c);
                newWord.append(word.substring(i + 1));
                String nextWord = newWord.toString();
                if (unvisitedWords.contains(nextWord)) {
                    unvisitedNeighbours.add(nextWord);
                    unvisitedWords.remove(nextWord);
                }
            }
        }
        return unvisitedNeighbours;
    }

    public static int wordLadder(String start, String end, List<String> wordList) {
        if (start.equals(end)) {
            return 0;
        }
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String word : wordList) {
            unvisitedWords.add(word);
        }
        queue.add(start);
        unvisitedWords.remove(start);
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String word = queue.pop();
                for (String neighbour : getNeighbours(word)) {
                    if (neighbour.equals(end)) {
                        return distance;
                    }
                    queue.add(neighbour);
                }
            }

        }
        return -1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String end = scanner.nextLine();
        List<String> wordList = splitWords(scanner.nextLine());
        scanner.close();
        int res = wordLadder(start, end, wordList);
        System.out.println(res);
    }
}