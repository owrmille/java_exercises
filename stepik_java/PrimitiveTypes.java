
public class PrimitiveTypes {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return ((a & b) & (!c & !d)) || ((a & c) & (!b & !d)) || ((a & d) & (!b & !c))
            || ((b & c) & (!a & !d)) || ((b & d) & (!a & !c)) || ((c & d) & (!a & !b));
    }

    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        System.out.println(a + b + c);
        return Math.abs(c - (a + b)) <= 1E-4 ;
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ (int)Math.pow(2.0, (double)(bitIndex - 1));
        // return value ^ 1 << bitIndex - 1;  // another solution
    }

    public static char charExpression(int a) {
        return (char)('\\' + a);
    }
    
    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        return (value != 0 && (Math.abs(value) & (Math.abs(value) - 1)) == 0);
        // return Integer.bitCount(Math.abs(value)) == 1;  // another solution
    }

    public static void main(String[] args) {
        System.out.println(booleanExpression(true, false, false, true));
        System.out.println(leapYearCount(100));
        System.out.println(doubleExpression(0.000001, 0.000002, 0.000003));
        System.out.println(flipBit(0, 1));
        System.out.println(charExpression(6));
        System.out.println(isPowerOfTwo(-2));
    }
}
