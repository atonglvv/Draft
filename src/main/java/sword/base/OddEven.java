package sword.base;

/**
 * @program: draft
 * @description: 奇数偶数相关
 * 判断一个整数是否为奇数,用 x % 2 != 0, 不要用 x % 2 == 1, 因为x可能是负数。
 * 比如 -3 % 2 == -1
 * @author: atong
 * @create: 2021-01-15 11:25
 */
public class OddEven {
    public static void main(String[] args) {
        int number = -3;
        boolean isOdd = isOdd(number);
        System.out.println(number + ": " + isOdd);
    }

    public static boolean isOdd(int number) {
        System.out.println("number % 2 = " +  number % 2);
        if (number % 2 != 0) {
            return true;
        }
        return false;
    }
}
