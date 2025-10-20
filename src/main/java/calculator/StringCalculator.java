package calculator;

public class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        // 구분자 인식
        String[] delimiters = {",", ":", null};
        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            if (index == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 확인할 수 없습니다.");
            }
            String customDelimiter = input.substring(2, index);
            delimiters[2] = customDelimiter;
            input = input.substring(index+2);
        }

        // 문자열 추출 및 숫자 변환
        for (String delimiter : delimiters) {
            if (delimiter == null || delimiter.equals(delimiters[0])) continue;
            input = input.replace(delimiter, delimiters[0]);
        }

        String[] tokens = input.split(delimiters[0]);
        int[] values = new int[tokens.length];

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

        // 덧셈 연산 수행 및 결과 출력
        int sum = 0;
        for (int value : values) {
            sum += value;
        }

        return sum;
    }
}
