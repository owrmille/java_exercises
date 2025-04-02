import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private final byte[] sequence;

    public AsciiCharSequence(byte[] codes) {
        this.sequence = Arrays.copyOf(codes, codes.length);
    }

    @Override
    public final int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char)sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(sequence, start, end));
    }

    @Override 
    public String toString() {
        return new String(sequence);
    }

    public static void main(String [] args) {
        byte[] codes = {77, 101, 79, 119};
        AsciiCharSequence cat = new AsciiCharSequence(codes);
        cat.sequence[2] = 63; // how to prevent it from changing values from the outside?
        System.out.println(cat.length());
        System.out.println(cat.charAt(2));
        System.out.println(cat.subSequence(1, 2));
        System.out.println(cat.toString());
    }
}
