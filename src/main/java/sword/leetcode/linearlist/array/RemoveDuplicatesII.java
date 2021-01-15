package sword.leetcode.linearlist.array;

import java.util.Arrays;

/**
 * @program: draft
 * @description:
 * Remove Duplicates from Sorted Array II:
 * Follow up[追踪/跟进] for ”Remove Duplicates”: What if duplicates are allowed at most twice?
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3]
 * Solution:
 * 加一个变量记录一下元素出现的次数即可。因为这题是已经排好序的数组,所以一个变量即可解决。
 * 如果是未排好序的数组,则需要引入一个hashmap来记录出现次数。
 * 声明一个boolean变量,
 * 如果前后两个值不相等则直接交换,并且把boolean设置为true。
 * 如果前后两个值相等,
 * @author: atong
 * @create: 2021-01-15 15:22
 */
public class RemoveDuplicatesII {

    public static void main(String[] args) {
        int[] array = {1, 1,1,2,2,3,4,5,5,5,5,6,6,6,7,8,8,9,0};
        int length = removeDuplicates(array);
        System.out.println("length = " + length + ", and array is now " + Arrays.toString(array));
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int removeDuplicates(int[] array) {
        if (array.length < 2) {
            return array.length;
        }
        int length = 0;
        boolean a = true;
        for (int i = 1; i < array.length; i++) {
            if (array[length] != array[i]) {
                array[++length] = array[i];
                a = true;
            }else if (a) {
                array[++length] = array[i];
                a = false;
            }
        }
        return length + 1;
    }

    /**
     * 灵活配置 most time
     * @param array: 数组
     * @return int length
     * @author atong
     * @date 2021/1/15 17:37
     * @version 1.0.0.1
     */
    public static int removeDuplicatesII(int[] array) {
        if (array.length < 2) {
            return array.length;
        }
        int length = 0;
        int a = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[length] != array[i]) {
                array[++length] = array[i];
                a = 1;
            }else if (a < 2) {
                array[++length] = array[i];
                a++;
            }
        }
        return length + 1;
    }
}
