import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharacterStreamExercises {
    public static void displayByteRepresentationInUtf8() throws IOException {
        while (true) {
            int byteR = System.in.read();
            System.out.println(byteR);
        }
    }

    public static void displayCharacterOutOfRange() throws IOException {
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write('ы');
        writer.flush();
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int readByte = reader.read();
        String concatenatedData = "";
        while (readByte != -1) {
            concatenatedData += (char)readByte;
            readByte = reader.read();
        }
        return concatenatedData;
    }

    public static String alternativeReadAsString(InputStream inputStream, Charset charset) throws IOException {
        int readData = inputStream.read();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while (readData != -1) {
            outputStream.write(readData);
            readData = inputStream.read();
        }
        return new String(outputStream.toByteArray(), charset);
    }

    public static void main(String[] args) throws IOException {
        // displayCharacterOutOfRange();
        // displayByteRepresentationInUtf8();
        Charset charset = StandardCharsets.US_ASCII;
        byte[] data = {48, 49, 50, 51};
        InputStream inputStream = new ByteArrayInputStream(data);
        System.out.println(alternativeReadAsString(inputStream, charset));
    }
}
