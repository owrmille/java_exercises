import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* You will receive a dataset containing many words, written in the Old Gods language, 
split by a whitespace. You will have to find one that does not have an anagram 
(meaning, you can't rearrange letters in the word to get another word in the dataset). 
That will be your answer.
*/

public class TheEldritchHorror {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/iasemintopchu/Desktop/backend core/java_exercises/hyperskill/fright_night_coding_2025/datasets/hyperskill-dataset-117477593.txt"))) {
            List<String> words = Arrays.asList(scanner.nextLine().split(" "));
            List<Map<Character, Integer>> maps = new ArrayList<>();
            for (String word : words) {
                Map<Character, Integer> wordLetters = new HashMap<>();
                for (Character c : word.toCharArray()) {
                    wordLetters.put(c, wordLetters.getOrDefault(c, -1) + 1);
                }
                maps.add(wordLetters);
            }

            boolean[] candidates = new boolean[maps.size()];
            Arrays.fill(candidates, true);
            for (int i = 0; i < maps.size(); i++) {
                for (int j = i + 1; j < maps.size(); j++) {
                    if (maps.get(i).equals(maps.get(j))) {
                        candidates[i] = false;
                        candidates[j] = false;
                        break;
                    }
                }
            }

            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i]) {
                    System.out.println(words.get(i));
                }
            }

        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
}
