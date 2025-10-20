package calculator;

public class NumberParser {
    private int[] values;

    public NumberParser(String text, String[] delimiters) {
        for (String delimiter : delimiters) {
            if (delimiter == null || delimiter.equals(delimiters[0])) continue;
            text = text.replace(delimiter, delimiters[0]);
        }

        String[] tokens = text.split(delimiters[0]);
        values = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            try{
                values[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 값이 입력되었습니다.");
            }
            if (values[i] <= 0) {
                throw new IllegalArgumentException("양수가 아닌 값이 입력되었습니다.");
            }
        }
    }

    public int[] getValues() {
        return values;
    }
}
