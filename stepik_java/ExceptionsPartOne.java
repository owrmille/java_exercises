public class ExceptionsPartOne {
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + String.valueOf(x));
        }
        return Math.sqrt(x); 
    }

    public static void main(String[] args) {
        double positiveNum = 25;
        double negativeNum = - 25;
        System.out.println(sqrt(positiveNum));
        System.out.println(sqrt(negativeNum));
    }
}
