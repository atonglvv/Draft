package basics.base;

import java.util.Scanner;

/**
 * @Auther: carver
 * @Date: 2019/4/13 09:17
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class One {

    public static void main(String[] args) {
        double avg,sum = 0;
        Scanner scanner  = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            sum += scanner.nextInt();
        }
        avg = sum / 5;
        System.out.println("平均值：" + avg);

        if (avg < 60) {
            System.out.println("评级：不及格");
        }else if (avg < 81) {
            System.out.println("评级：良");
        }else if (avg < 91) {
            System.out.println("评级：好");
        }else {
            System.out.println("评级：优秀");
        }
    }
}
