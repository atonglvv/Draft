package basics.array;

/**
 * @Auther: carver
 * @Date: 2019/2/16 20:05
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Array {

    public static void main(String[] args) {
        /**
         * 数组的内容分为动态初始化和静态初始化两种，
         * 动态初始化必须使用关键字new。
         * 静态初始化直接在声明时使用大括号（{}）为数组进行初始化。
         */

        //使用静态初始化声明数组
        int[] score = {89, 95, 88, 99, 97};
        for (int i = 0; i < 5; i++) {
            System.out.println("score[" + i + "]=" + score[i]);
        }

        //使用静态初始化声明二维数组
        int[][] score2 = {{21, 22}, {87, 88}, {52, 22}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(score2[i][j] + "\t");
            }
            //换行
            System.out.println("");

        }


    }
}
