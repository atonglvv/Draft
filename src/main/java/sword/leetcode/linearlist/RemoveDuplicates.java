package sword.leetcode.linearlist;

import java.util.Arrays;

/**
 * @program: draft
 * @description:
 * Remove Duplicates from Sorted Array:
 * Given a sorted[排好序的,分好类的] array,
 * remove the duplicates in place[in place -> 适当的,在适当的位置] such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory[固定的内存].
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * @author: atong
 * @create: 2021-01-15 13:37
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1,1,2};
        int length = removeDuplicates(array);
        System.out.println("length = " + length + ", and array is now " + Arrays.toString(array));
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int removeDuplicates(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        //声明返回值length,并使用该值作为数组index
        int length = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[length] != array[i]) {
                array[++length] = array[i];
            }
        }
        return length + 1;
    }
}
