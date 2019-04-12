package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 15:37
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 编写一段程序，检查一个二维数组是否对称，（即对所有i和j都有a[i][j]=a[j][i]）
 */
public class ArraySymmetric {
    public static void main(String[] args) {
//        int[][] arrays = {{3,0,6,4,2},{5,8,9,7,8}};
        int[][] arrays = {{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}};
        System.out.println(new ArraySymmetric().arraySymmetric(arrays));
    }

    public boolean arraySymmetric(int[][] arrays) {
        if (arrays.length != arrays[0].length) {
            return false;
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j] != arrays[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
