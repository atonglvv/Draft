package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 18:25
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class NarcissusPAD {

    public static void main(String[] args) {
        StringBuilder flower = new StringBuilder();
        int i = 100;
        while (i < 1000) {
            int a = i /100;
            int b = i / 10 % 10;
            int c = i % 10;

            if (a * a * a + b * b * b + c * c * c == i) {
                flower.append(i + ",");
            }
            i++;
        }

        if (flower == null) {
            System.out.println("打印：100~999之间不存在水仙花");
        }else {
            System.out.println("打印：100~999之间的水仙花有" + flower);
        }
    }
}
