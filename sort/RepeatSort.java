package sort;

import java.util.Random;

public class RepeatSort {

    public static void main(String[] args) {
        //初始化一个容量为1000的1-100的正整数数组
        Integer[] array = new Integer[1000];
        //结果集
        Integer[] result = new Integer[1000];
        //初始化一个容量为101的数组
        Integer[] a = new Integer[101];
        //构造数据
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(100) + 1;
            array[i] = num;
        }

        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            a[index]++;
        }
        for (int i = 0; i < a.length; i++) {

        }


    }

}
