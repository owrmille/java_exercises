
import java.util.Objects;

public class Pair<A, B> {
    private final A first;
    private final B second;

    private Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair<>(first, second);
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Pair<?, ?> newPair = (Pair<?, ?>)anObject;
        // since first and second can be null, Objects.equals() is used instead of .equals() directly
        return Objects.equals(first, newPair.getFirst()) == true && Objects.equals(second, newPair.getSecond()) == true;
    }

    @Override
    public int hashCode() {
        int res = first != null ? first.hashCode() : 0;
        res += second != null ? second.hashCode() : 0;
        return res;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        System.out.println(String.format("%d %s", i, s));

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(String.format("%b %b", mustBeTrue, mustAlsoBeTrue));
    }
}
