import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

// TreeMap(String letter, Integer count) -> tree because of the alphabetical order priority -> 
// start from A
// if count is even -> subtract count and put half of count letters in the beginning ('A': 4 -> 'A': 0, "AA"), move on
// if odd -> subtract slosest even (smaller than count) and put half of it leters in the beginning
// (in both ways, increase the number of letters needed to be mirrowed)
// if odd and this letter is the last -> add it but don't increase the number of letters needed to be mirrowed
// in the end -> mirrow the word by the number of letters needed to be mirrowed
public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> frequency = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());
        String input = reader.readLine();

        for (int i = 0; i < n; i++) {
            char letter = input.charAt(i);
            frequency.put(letter, frequency.getOrDefault(letter, 0) + 1);
        }

        StringBuilder leftHalf = new StringBuilder();
        char middleChar = 0;
        boolean isMiddleCharSet = false;

        for (Map.Entry<Character, Integer>  entry : frequency.entrySet()) {
            char letter = entry.getKey();
            int count = entry.getValue();
            
            for (int j = 0; j < count/2; j++) {
                leftHalf.append(letter);
            }

            if (!isMiddleCharSet && count % 2 == 1) {
                middleChar = letter;
                isMiddleCharSet = true;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(leftHalf);

        if (isMiddleCharSet) {
            result.append(middleChar);
        }
    
        for (int i = leftHalf.length() - 1; i >= 0; i--) {
            result.append(leftHalf.charAt(i));
        }

        writer.write(result.toString());

        reader.close();
        writer.close();
    }
}
