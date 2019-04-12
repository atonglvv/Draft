package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/10 17:16
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Average {
    public static void main(String[] args) {
        double[] score = {8,9.6,5,7,7.8,9.3,5};
        double max = score[0],min = score[0];
        int indexMax = 0;
        int indexMin = 0;
        double sum = 0,avg;
        //迭代求数组最大值最小值以及其索引
        for (int i = 1; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
                indexMax = i;
            }
            if (score[i] < min) {
                min = score[i];
                indexMin = i;
            }
        }
        //将最大值最小值设为0
        score[indexMax] = 0;
        score[indexMin] = 0;
        //求和
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        //求平均值
        avg = sum / (score.length -2);
        System.out.println(avg);
    }
}
