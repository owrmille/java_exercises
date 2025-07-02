import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllAnagrams {
    public static List<Integer> findAllAnagrams(String original, String check) {
        int checkLen = check.length();
        int originalLen = original.length();

        if (checkLen > originalLen) return List.of();

        List<Integer> indices = new ArrayList<>();
        int[] checkLettersCount = new int[26];
        int[] windowLettersCount = new int[26];

        for (int i = 0; i < checkLen; i++) {
            checkLettersCount[check.charAt(i) - 'a']++;
            windowLettersCount[original.charAt(i) - 'a']++;
        }

        for (int i = 0; i < originalLen; i++) {
            if (Arrays.equals(checkLettersCount, windowLettersCount)){
                indices.add(i);
            }
            if (i + checkLen > originalLen - 1) break;
            windowLettersCount[original.charAt(i) - 'a']--;
            windowLettersCount[original.charAt(i + checkLen) - 'a']++;
        }
        return indices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter original: ");
        String original = scanner.nextLine();
        System.out.print("Enter check: ");            
        String check = scanner.nextLine();
        List<Integer> res = findAllAnagrams(original, check);
        System.out.println("Result: " + res);
        scanner.close();
    }
} 
