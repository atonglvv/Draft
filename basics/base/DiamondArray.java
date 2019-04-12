package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 16:49
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class DiamondArray {

    public static void main(String[] args) {
        char[][] diamon = new char[7][7];
        System.out.println(diamon[0][0]);
        //上三角
        for (int i = 0; i <= 7 / 2; i++) {
            int j = 3-i;
            while (j <= i + 3) {
                diamon[i][j] = '*';
                j++;
            }
        }
        //下三角
        for (int i = 7 / 2 + 1; i < 7; i++) {
            int j = i - 3;
            while (j <= 9 - i) {
                diamon[i][j] = '*';
                j++;
            }
        }

        for (int i = 0; i < diamon.length; i++) {
            for (int j = 0; j < diamon[i].length; j++) {
                System.out.print(diamon[i][j]);
            }
            System.out.println();
        }
    }
}
