import java.io.ByteArrayInputStream;
import java.io.IOException;

// Using System.out.flush() is necessary for testing platform on stepik.org
public class NewLineFormatter {
    public static final int CAR_RET = 13;
    public static final int NEW_LINE = 10;
    public static final int END_CHAR = -1;

    public static void reformatNewLine() throws IOException {
        int cur = System.in.read();
        int next = 0;
        while (cur != -1 && next != -1) {
            if (cur == 13) {
                next = System.in.read();
                if (next == -1) {
                    System.out.print(cur);
                    break;
                }
                else if (next != 10) {
                    System.out.print(cur);
                }
                cur = next;
            }
            System.out.print(cur);
            cur = System.in.read();
        }
        System.out.flush();
    }

    public static void refactoredReformatNewLine() throws IOException {
        int cur, next;
        cur = System.in.read();
        while (cur != END_CHAR) {
            next = System.in.read();
            if (cur != CAR_RET || next != NEW_LINE) {
                System.out.write(cur);  // use .print() for displaying bytes
            }
            cur = next;
        }
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {
        byte[] data = {65, 13, 10, 10, 13};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        System.setIn(inputStream);
        //reformatNewLine();
        refactoredReformatNewLine();
    }
}
