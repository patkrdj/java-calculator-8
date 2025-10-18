package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        input = input.trim();

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

    }
}
