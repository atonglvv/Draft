package sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Auther: carver
 * @Date: 2019/3/13 16:56
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args){
        //初始化一个容量为1000的1-100的正整数数组
        Integer[] array = new Integer[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(100) + 1;
            array[i] = num;
        }

        quickSort(array, 0, array.length-1);

        //转为List输出
        List<Integer> lists = Arrays.asList(array);
        System.out.println(lists);
    }

    public static void quickSort(Integer[] array, int low, int high){
        int i,j,temp,t;
        if(low > high){
            return;
        }
        i = low;
        j = high;
        //选择一个基数[这里选用第一个元素作为基数]
        temp = array[low];

        while (i < j) {
            //由右至左比较，如果大于等于基数则继续往左进行比较,直到找到找到一个小于基数的数
            while (temp <= array[j] && i < j) {
                j--;
            }
            //由左至右比较，如果小于等于基数则继续往左进行比较,直到找到一个大于基数的数
            while (temp >= array[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = array[j];
                array[j] = array[i];
                array[i] = t;
            }
        }
        //交换基数, 将基数与指针[low/high]相遇的地方数值交换
        array[low] = array[i];
        array[i] = temp;
        //递归调用左半数组
        quickSort(array, low, j-1);
        //递归调用右半数组
        quickSort(array, j+1, high);
    }
}
