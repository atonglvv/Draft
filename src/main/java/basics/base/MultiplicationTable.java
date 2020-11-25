package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 14:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class MultiplicationTable {

    public static void main(String[] args) {

        //    九九乘法表
        for (int i = 1;i <= 9;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

}
