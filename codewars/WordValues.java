import java.util.Scanner;

public class WordValues {
    public static int calculateStrVal(String s) {
        int sum = 0;
      
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sum += c - 'a' + 1;
            }
        }
      
        return sum;
    }
  
    public static int [] nameValue(String [] arr){
        int[] res = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            res[i] = calculateStrVal(arr[i].toLowerCase()) * (i+1);
        }
      
        return res;  
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] arr = scanner.nextLine().replaceAll("[\\[\\]\\s\"]", "").split(",");
            int[] res = nameValue(arr);
            for (int el : res) {
                System.out.println(el);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
