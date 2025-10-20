package calculator;

public class SumCalculator {
    public static int getSum(int[] values) {
        int sum = 0;
        for (int value : values) {
            if (sum > Integer.MAX_VALUE - value) {
                throw new IllegalArgumentException("Sum 값을 연산하는데 overflow가 발생하였습니다.");
            }
            sum += value;
        }
        return sum;
    }
}
