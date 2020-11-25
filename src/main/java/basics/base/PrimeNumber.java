package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 14:37
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 写一段JAVA程序判断1-100存在哪些质数，按照格式a,b,c,d..打印出来，5个一行
 */
public class PrimeNumber {

    public static void main(String[] args) {

        int count = 1;

        for (int i = 2; i <= 100;i++) {
            int j;
            for (j = 2;j <= Math.sqrt(i);j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > Math.sqrt(i)) {
                //每5个打印一个换行且由逗号分隔
                if (count % 5 == 0) {
                    System.out.println(i);
                }else {
                    System.out.print(i + ",");
                }
                count++;
            }
        }
    }
}
