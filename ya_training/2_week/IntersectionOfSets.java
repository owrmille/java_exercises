import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class IntersectionOfSets {
        public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> first = new HashSet<>();
        String line1 = reader.readLine();
        if (line1 != null && !line1.trim().isEmpty()) {
            StringTokenizer st = new StringTokenizer(line1);
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                first.add(num);
            }
        }

        Set<Integer> result = new TreeSet<>();
        String line2 = reader.readLine();
        if (line2 != null && !line2.trim().isEmpty()) {
            StringTokenizer st = new StringTokenizer(line2);
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (first.contains(num)) result.add(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(num);
        }

        writer.write(sb.toString());
        
        // String[] parts1 = reader.readLine().trim().split(" ");
        // String[] parts2 = reader.readLine().trim().split(" ");

        // Set<Integer> nums1 = new TreeSet<>();
        // for (String el : parts1) {
        //     int val = Integer.parseInt(el);
        //     nums1.add(val);
        // }

        // Set<Integer> nums2 = new TreeSet<>();
        // for (String el : parts2) {
        //     int val = Integer.parseInt(el);
        //     nums2.add(val);
        // }

        // nums1.retainAll(nums2);

        // for (Integer val : nums1) {
        //     writer.write(String.valueOf(val) + " ");
        // }

        reader.close();
        writer.close();
    }
}