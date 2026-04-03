import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().trim().split("\\s+");
        Set<Integer> nums = new HashSet<>(100000 * 2);
        for (String el : parts) {
            nums.add(Integer.parseInt(el));
        }
        writer.write(String.valueOf(nums.size()));

        reader.close();
        writer.close();
    }
}