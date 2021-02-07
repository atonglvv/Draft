package sword.leetcode.linearlist.array;

import java.util.Arrays;

/**
 * @program: draft
 * @description: Plus One
 * Given a number represented as an array of digits, plus one to the number.
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * Solution:
 * 只加一可能的情况就只有两种:
 * - 除 99 之外的数字加一
 * - 数字 99
 * @author: atong
 * @create: 2021-02-07 09:44
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] nums = {9};
        int[] array = plusOne(nums);
        System.out.println(Arrays.toString(array));
    }


    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            //如果+1后等于10,则需要余10
            digits[i] %= 10;
            //如果+1后不为10,则直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
