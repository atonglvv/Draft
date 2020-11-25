package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/12 10:26
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 打印阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        new Factorial().factorial(5);
    }
    public void factorial(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            if (i + 1 > n) {
                System.out.print(i + " = ");
            }else {
                System.out.print(i + " * ");
            }
        }
        System.out.println(sum);
    }
}
