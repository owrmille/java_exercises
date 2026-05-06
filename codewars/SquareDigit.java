public class SquareDigit {

  public static int squareDigits(int n) {
    StringBuilder res = new StringBuilder();
    String s = String.valueOf(n);
    for (char c : s.toCharArray()) {
      int digit = c - '0';
      res.append(digit * digit);
    }
    return Integer.parseInt(res.toString());
  }

  public static void main(String[] args) {
    System.out.println(squareDigits(9119));
  }
}
