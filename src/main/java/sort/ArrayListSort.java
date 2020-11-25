package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayListSort {

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


//        Integer[] a = {1,2,3,6,3,76,4,23,65,23,12,54,65,21,67,90,23,11,2,5,4};


//        lists.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
//
//        System.out.println(lists);
    }

    public static ArrayList sort() {

        return new ArrayList();
    }
}
