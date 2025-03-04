public class StringSplit {
    public static String[] solution(String s) {
      String[] pairs = new String[(s.length() + 1) / 2];
      int j = 0;
      for (int i = 0; i < s.length(); i += 2) {
        if (i == s.length() - 1)
          pairs[j] = s.substring(i) + "_";
        else {
          pairs[j] = s.substring(i, i + 2);
        }
        j++;
      }
      return pairs;
    }

    public static String[] alternSolution(String s) {
      int size = s.length();
      if (size % 2 != 0) {
        s += "_";
        size += 1;
      }
      String[] pairs = new String[size / 2];
      for (int i = 0; i < size / 2; i++) {
        pairs[i] = "" + s.charAt(i * 2) + s.charAt(i * 2 + 1);
      }
      return pairs;
    }

    public static void main(String[] args) {
      String str = "Hell";
      for (String s : alternSolution(str)) {
          System.out.println(s);
      }
    }
}