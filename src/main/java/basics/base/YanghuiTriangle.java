package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 16:41
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        //第一列以及对角线所有值为1
        for (int i = 0;i < 5; i++) {
            a[i][0] = 1;
            a[i][i] = 1;
        }
        for (int i = 2;i < 5;i++) {
            for (int j = 1;j <= i;j++) {
                a[i][j] = a[i-1][j] + a[i-1][j-1];
            }
        }
        for (int i = 0;i < 5;i++) {

            for(int j = 0;j < a[i].length;j++) {
                if (a[i][j] != 0) {
                    System.out.print(a[i][j] + "\t");
                }
            }
            System.out.println();

        }
    }
}
