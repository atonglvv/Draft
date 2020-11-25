package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 17:06
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 按照1+1+2+3+5=12的格式打印斐波那契数列（f(n)=f(n-1)+f(n-2)）前8项，并求和
 */
public class FibonacciEight {

    public static void main(String[] args) {
        int a = 1,b = 1;
        int sum = 0;
        int[] fibonacci = new int[8];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < 8; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        for (int i = 0; i < 8; i++) {
            sum += fibonacci[i];
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(fibonacci[i] + "+");
        }
        System.out.println(fibonacci[7] + "=" + sum);
    }

    /**
     * 只计算前n项和
     */
//    public static void main(String[] args) {
//        int a = 1,b = 1;
//        int result = 2;
//        for (int i = 2; i < 8; i++) {
//            result += (a + b);
//            int temp = a;
//            a = b;
//            b = temp + b;
//        }
//        System.out.println(result);
//    }
}
