package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        // 구분자 인식
        DelimiterParser delimiterParser = new DelimiterParser(input);
        String[] delimiters = {",", ":", delimiterParser.getDelimiter()};
        input = delimiterParser.getText();


        // 문자열 추출 및 숫자 변환
        NumberParser numberParser = new NumberParser(input, delimiters);
        int[] values = numberParser.getValues();

        // 덧셈 연산 수행 및 결과 출력
        int sum = 0;
        for (int value : values) {
            sum += value;
        }

        return sum;
    }
}
