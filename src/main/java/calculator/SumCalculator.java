package calculator;

public class SumCalculator {
    public static int getSum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
