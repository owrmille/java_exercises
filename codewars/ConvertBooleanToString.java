public class ConvertBooleanToString {
    public static String convert(boolean b) {
        return Boolean.toString(b);
    }

    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        System.out.println(a);
        System.out.println(b);

        System.out.println(convert(a).getClass() + ", " + convert(a).equals("true"));
        System.err.println(convert(b).getClass() + ", " + convert(b).equals("false"));
    }
}
