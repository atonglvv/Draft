package basics.base;

import basics.thread.SynAndNoSyn;

import java.util.Scanner;

/**
 * @Auther: carver
 * @Date: 2019/4/10 15:23
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 编写一个Java应用程序，实现下列功能：
 * 随机数生成函数： int x=(int)(Math.random()*100);
 * 1) 程序随机分配给客户一个1-100之间的整数
 * 2) 用户在输入对话框中输入自己的猜测
 * 3) 程序返回提示信息，提示信息分别是：“猜大了”、“猜小了”和“猜对了”。
 * 4) 用户可根据提示信息再次输入猜测，直到提示信息是“猜对了”。
 */
public class Guess {
    public static void main(String[] args) {
        int x = (int) (Math.random() * 100);
        System.out.println(x);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int now = scanner.nextInt();
            if (now > x) {
                System.out.println("猜大了");
            } else if (now < x) {
                System.out.println("猜小了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
