package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 15:34
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 */
public class SumOfFractionalSequences {

    public static void main(String[] args) {
        double a = 2,b = 1,sum = 0;
        for (int i = 0;i < 20;i++) {
            sum += a / b;
            double temp = a;
            a = a + b;
            b = temp;
        }
        System.out.println(sum);
    }
}
