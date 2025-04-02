public class FilterComments {
    interface TextAnalyzer {
        Label processText(String text);
    }

    abstract static class KeywordAnalyzer implements TextAnalyzer {
        protected abstract String[] getKeywords();

        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            String[] keywords = getKeywords();
            String upperText = text.toUpperCase();
            for (String word : keywords) {
                if (upperText.contains(word.toUpperCase())) {
                    return getLabel();
                }
            }
            return Label.OK;
        }

    }

    public static class SpamAnalyzer extends KeywordAnalyzer {
        private final String[] keywords;

        public SpamAnalyzer(String[] words) {
            this.keywords = words;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    public static class NegativeTextAnalyzer extends KeywordAnalyzer {
        public NegativeTextAnalyzer() {}

        @Override
        protected String[] getKeywords() {
            return  new String[]{":(", "=(", ":|"};
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    public static class TooLongTextAnalyzer implements TextAnalyzer {
        private final int maxLength;

        public TooLongTextAnalyzer(int num) {
            this.maxLength = num;
        }

        @Override
        public Label processText(String text) {
            if (text.length() > maxLength) {
                return Label.TOO_LONG;
            }
            return Label.OK;
        }
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer check : analyzers) {
            Label result = check.processText(text);
            if (result != Label.OK) {
                return result;
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {
    // TooLongTextAnalyzer Test
    TooLongTextAnalyzer tooLongAnalyzer = new TooLongTextAnalyzer(60);
    System.out.println("TooLongTextAnalyzer Tests:");
    System.out.println(tooLongAnalyzer.processText("Short text"));
    System.out.println(tooLongAnalyzer.processText("Very long text... (omitted for brevity)"));
    System.out.println();

    // NegativeTextAnalyzer Test
    NegativeTextAnalyzer negativeAnalyzer = new NegativeTextAnalyzer();
    System.out.println("NegativeTextAnalyzer Tests:");
    String[] testNegativeTexts = {"Fine", "Disappointing :(", "=(", ":|"};
    for (String text : testNegativeTexts) {
        System.out.println(negativeAnalyzer.processText(text));
    }
    System.out.println();

    // SpamAnalyzer Test
    SpamAnalyzer spamAnalyzer = new SpamAnalyzer(new String[]{"dog", "bark"});
    System.out.println("SpamAnalyzer Tests:");
    String[] testSpamTexts = {"I like cats", "Dogs are better lol", "Does anyone have a real barking record?"};
    for (String text : testSpamTexts) {
        System.out.println(spamAnalyzer.processText(text));
    }
    System.out.println();

    // Check Multiple Analyzers
    System.out.println("Check Multiple Analyzers:");
    TextAnalyzer[] analyzers = {tooLongAnalyzer, negativeAnalyzer, spamAnalyzer};
    System.out.println(checkLabels(analyzers, "Good text"));
    System.out.println(checkLabels(analyzers, "Does anyone have a real barking record? :("));
}

}
