package calculator;

public class DelimiterParser {
    private String delimiter = null;
    private String text;

    public DelimiterParser(String input) {
        this.text = input;
        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 확인할 수 없습니다.");
            }
            this.delimiter = input.substring(2, index);
            this.text = input.substring(index + 2);
        }
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getText() {
        return text;
    }
}
