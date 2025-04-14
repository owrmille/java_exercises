import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStream {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        int readByte = inputStream.read();
        while (readByte != -1) {
            sum = Integer.rotateLeft(sum, 1) ^ readByte;
            readByte = inputStream.read();
        }
        return sum;
    }

    public static void main(String[] args) {
        byte[] data = {0x33, 0x45, 0x01};
        InputStream inputStream = new ByteArrayInputStream(data);
        try {
            System.out.println(checkSumOfStream(inputStream));   
        } catch (Exception e) {
            System.out.println("Something went wrong."); 
        }
        
    }
}
