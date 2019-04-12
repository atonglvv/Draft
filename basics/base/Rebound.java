package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 15:12
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 一球从100米高度自由落下，每次落地后反跳回原高度的2/3再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 */
public class Rebound {

    public static void main(String[] args) {
        double sum = 0,height = 100;
        for (int i = 0;i < 10; i++) {
            sum += height;
            height = height * 2 / 3;
        }
        System.out.println("sum = " + sum + ",height = " + height);
    }
}
