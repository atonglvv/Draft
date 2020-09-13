package sort;

import java.util.*;

/**
 * Arrays.sort()排序
 */
public class ArraysSort {

    public static void main(String[] args) {
        //初始化一个容量为1000的1-100的正整数数组
        Integer[] array = new Integer[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(100) + 1;
            array[i] = num;
        }
        //排序
        Arrays.sort(array);
        //转为List输出
        List<Integer> lists = Arrays.asList(array);
        System.out.println(lists);
    }
}
