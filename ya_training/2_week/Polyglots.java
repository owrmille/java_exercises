import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Note:
// - HashSet -> arbitrary order
// - LinkedHashSet -> insertion order
// - TreeSet -> sorted order

public class Polyglots {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        Set<String> allLanguages = new HashSet<>();
        Set<String> commonLanguages = new HashSet<>();

        int studentsNum = Integer.parseInt(reader.readLine());
        for (int i = 0; i < studentsNum; i++) {
            Set<String> curStudentLanguage = new HashSet<>();

            int langsNum = Integer.parseInt(reader.readLine());
            
            for (int j = 0; j < langsNum; j++) {
                String curLang = reader.readLine();
                allLanguages.add(curLang);
                curStudentLanguage.add(curLang);
            }

            if (i == 0) {
                commonLanguages.addAll(curStudentLanguage);
            } else {
                commonLanguages.retainAll(curStudentLanguage);
            }
        }

        sb.append(commonLanguages.size()).append('\n');
        for (String lang : commonLanguages) {
            sb.append(lang).append('\n');
        }

        sb.append(allLanguages.size()).append('\n');
        for (String lang : allLanguages) {
            sb.append(lang).append('\n');
        }
        
        writer.write(sb.toString());

        reader.close();
        writer.close();
    }
}
