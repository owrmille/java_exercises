
import java.util.Scanner;

class SquareRoot {
    public static int squareRoot(int val) {
        if (val == 0) return 0;
        if (val == 1) return 1;
        int left = 0;
        int right = val / 2 + 1;
        int boundaryRoot = 0;
        
        while (left <= right) {
            int mid = left + (right-left)/2; 
            if (val / mid >= mid) {  // comparing to mid * mid <= val, this prevents overflow
                boundaryRoot = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return boundaryRoot;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value: ");
        System.out.println("Square root: " + squareRoot(scanner.nextInt()));
        scanner.close();
    }
}