package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 14:22
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 求1~100内，所有尾数不为8的整数的累加值。
 */
public class Accumulation {
    public static void main(String[] args) {
        int result = 0;
        int base = 8;
        //1~100累加和
        for (int i = 1; i <= 100; i++) {
            result += i;
        }

        while (base < 100) {
            result -= base;
            base += 10;
        }

        System.out.println(result);
    }
}
