package basics.base;

import java.util.Scanner;

/**
 * @Auther: carver
 * @Date: 2019/4/13 09:45
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Four {

    public static void main(String[] args) {
        int num1,num2,rever1 = 0,rever2  = 0;
        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
        if (num1 < 1 || num1 > 70000) {
            System.out.println("请输入大于等于1且小于等于70000的整数");
            return;
        }
        num2 = scanner.nextInt();
        if (num2 < 1 || num2 > 70000) {
            System.out.println("请输入大于等于1且小于等于70000的整数");
            return;
        }
        while (num1 != 0) {
            rever1 = rever1 * 10 + (num1 % 10);
            num1 /= 10;
        }
        while (num2 != 0) {
            rever2 = rever2 * 10 + (num2 % 10);
            num2 /= 10;
        }
        System.out.println(rever1 + rever2);
    }
}
