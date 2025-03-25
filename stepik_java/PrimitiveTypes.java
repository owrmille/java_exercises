
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
        return value ^ (int)Math.pow(2.0, (double)bitIndex);
    }

    public static void main(String[] args) {
        double hey = 0x0bp3;
        System.out.println(booleanExpression(true, false, false, true));
        System.out.println(leapYearCount(100));
        System.out.println(doubleExpression(0.000001, 0.000002, 0.000003));
        System.out.println(flipBit(42, 3));
    }
}
