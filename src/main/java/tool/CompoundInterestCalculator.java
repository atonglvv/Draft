package tool;

/**
 * @program: draft
 * @description: Compound Interest Calculator
 * @author: atong
 * @create: 2021-02-20 10:52
 */
public class CompoundInterestCalculator {
    private static final double income = 140000;

    public static void main(String[] args) {
        double rate = 0.05;
        int year = 4;
        double incomex = income(income, rate, year);
        System.out.println(incomex);
    }

    public static double income(double money, double rate, int year) {
        double result = 0;
        result = money + money * rate;
        if (year == 1) {
            return result;
        }
        //每年攒income
        return income(result + income, rate, year - 1);
    }
}
