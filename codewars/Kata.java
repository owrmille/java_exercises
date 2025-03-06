import static java.util.Arrays.stream;
import java.util.IntSummaryStatistics;

public class Kata {
  public static String highAndLow(String numbers) {
    String values[] = numbers.split(" ");
    Integer minVal = Integer.valueOf(values[0]);
    Integer maxVal = Integer.valueOf(values[0]);
    Integer num;
    for (String elem : values) {
        num = Integer.valueOf(elem);
        if (num < minVal) {
            minVal = num;
        }
        else if (num > maxVal) {
            maxVal = num;
        }
    }
    return maxVal + " " + minVal;
  }

  public static String alternHighAndLow(String numbers) {
    IntSummaryStatistics stat = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
    return stat.getMax() + " " + stat.getMin();
  }

  public static void main(String[] args) {
    System.out.println(highAndLow("1 2 3 4 5"));
    System.out.println(alternHighAndLow("1 2 3 4 5"));
  }
}