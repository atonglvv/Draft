package tool;

import java.util.Scanner;

/**
 * @Auther: carver
 * @Date: 2019/3/23 14:11
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class MultiInput {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while(cin.hasNextInt()){
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }
    }
}
