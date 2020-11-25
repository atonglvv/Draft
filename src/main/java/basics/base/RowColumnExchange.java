package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 15:12
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 3.	写一段程序，将二维数组a = {{3,0,6,4,2},{5,8,9,7,8}}行与列的数据交换，并打印输出
 */
public class RowColumnExchange {

    public static void main(String[] args) {
        int[][] a = {{3,0,6,4,2},{5,8,9,7,8}};
        int[][] result = new int[5][2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (j == 0) {
                    System.out.print(result[i][j]);
                }else {
                    System.out.print(" " + result[i][j]);
                }
            }
            System.out.println();
        }
    }
}
