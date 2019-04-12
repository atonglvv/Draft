package basics.base;

import java.util.Arrays;

/**
 * @Auther: carver
 * @Date: 2019/4/10 16:33
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 编写一段程序，对一维数组 a = {5,8,9,7,3,1,6,4,2}进行排序。
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] a = {5,8,9,7,3,1,6,4,2};
        Arrays.sort(a);
        for (int i = 0; i < a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}
