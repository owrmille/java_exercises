public class Accumul {
    
    public static String accum(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) result += "-";
            result += s.substring(i, i + 1).toUpperCase() + s.substring(i, i + 1).toLowerCase().repeat(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));
        System.out.println(accum("RqaEzty"));
        System.out.println(accum("cwAt"));
    }
}
