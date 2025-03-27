
public class ArraysAndStrings {
    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // System.out.println(cleanedText);
        StringBuilder reversedText = new StringBuilder(cleanedText).reverse();
        // System.out.println(reversedText);
        return cleanedText.equals(reversedText.toString().toLowerCase());
        // or : return cleanedText.equalsIgnoreCase(reversedText.toString()); - then we don't need to change the case in both strings
    }

    public static void main(String[] args) {
        String text = "Madam, I'm Adam!";
        // System.out.println(text);
        System.out.println(isPalindrome(text));
    }
}
