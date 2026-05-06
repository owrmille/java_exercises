import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OctoProblem {

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static String Octopus(String idea) {
        StringBuilder res = new StringBuilder(); 
		Map<Character, Integer> freqMap = new HashMap<>();

        String lowered = idea.toLowerCase();
        for (int i = 0; i < idea.length(); i++) {
            
            char c = lowered.charAt(i);
            
            if (freqMap.containsKey(c)) {
                if (isDigit(c) && freqMap.get(c) < 2) {
                    res.append(c);
                }
                else res.append("*");
            } else {
                res.append(idea.charAt(i));
            }
            
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            if ((i+1) % 8 == 0) {
                freqMap.clear();
            }
        }

        return res.toString();
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String idea = scanner.nextLine();
        scanner.close();

        System.out.println(Octopus(idea));
    }
}
