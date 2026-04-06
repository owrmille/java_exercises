import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BankAccounts {
    public static void processOperation(Map<String, Long> accounts, String operation, StringTokenizer st, StringBuilder sb) {
        if (operation.equals("DEPOSIT") || operation.equals("WITHDRAW")) {

            String name = st.nextToken();
            long sum = Long.parseLong(st.nextToken());

            long updatedSum = operation.equals("DEPOSIT") 
                ? accounts.getOrDefault(name, 0L) + sum 
                : accounts.getOrDefault(name, 0L) - sum;
    
            accounts.put(name, updatedSum);

        } else if (operation.equals("BALANCE")) {

            String name = st.nextToken();

            if (accounts.containsKey(name)) sb.append(accounts.get(name));
            else sb.append("ERROR");

            sb.append('\n');

        } else if (operation.equals("TRANSFER")) {

            String sender = st.nextToken();
            String receiver = st.nextToken();
            long sum = Long.parseLong(st.nextToken());

            accounts.put(sender, accounts.getOrDefault(sender, 0L) - sum);
            accounts.put(receiver, accounts.getOrDefault(receiver, 0L) + sum);

        } else if (operation.equals("INCOME")) {

            long percentage = Long.parseLong(st.nextToken());
            for (Map.Entry<String, Long> client : accounts.entrySet()) {
                long balance = client.getValue();
                if (balance > 0) {
                    client.setValue(balance + percentage * balance / 100L);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        Map<String, Long> accounts = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            
            String operation = st.nextToken();

            processOperation(accounts, operation, st, sb);
        }

        writer.write(sb.toString());

        reader.close();
        writer.close();
    }
}
