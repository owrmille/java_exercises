
public class Practice6 {
    public static boolean isSubseq(String seq, String subseq) {
        int ptr1 = 0;  // seq ptr
        int ptr2 = 0;  // subseq ptr
        while (ptr1 < seq.length() && ptr2 < subseq.length()) {  // O(seq_length)
            char c1 = seq.charAt(ptr1);
            char c2 = subseq.charAt(ptr2);
            if (c1 == c2) {
                ptr2++;
            }
            ptr1++;
        }
        return ptr2 == subseq.length();
    }

    public static void main(String[] args) {
        String seq = "L1uc23renttxe";
        String subseq = "Lucene";
        String notSubseq = "Lucane";

        System.out.println(isSubseq(seq, subseq));
        System.out.println(isSubseq(seq, notSubseq));
    }
}