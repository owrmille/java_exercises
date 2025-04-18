import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class StreamApiExercises {
    public static IntUnaryOperator getMiddle() {
        return number -> number / 10 % 1000;
    }

    public static IntStream pseudoRandomStream(int seed) {
        IntStream randomNumbers = IntStream.iterate(seed, x -> getMiddle().applyAsInt(x * x));
        return randomNumbers;
    }

    public static void main(String[] args) {
        pseudoRandomStream(13).limit(12).forEach(System.out::println);
    }
}
