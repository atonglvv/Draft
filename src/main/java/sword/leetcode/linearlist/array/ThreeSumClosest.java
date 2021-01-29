package sword.leetcode.linearlist.array;

import java.util.Arrays;

/**
 * @program: draft
 * @description:
 * Three Sum Closest[adj. 最靠近的]
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Solution:
 * 先排序,然后左右夹逼,时间复杂度O(n²)
 * 该题注意Closest,即为 Math.abs(sum - target)最小值。
 *
 * @author: atong
 * @create: 2021-01-29 15:29
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int result = threeSumClosest(nums, 1);
        System.out.println(result);
    }

    public static int threeSumClosest (int[] nums, int target) {
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    minGap = gap;
                    result = sum;
                }
                /**
                 * 注意该处,夹逼方式跟ThreeSum不同。
                 * 比较sum 跟 target的大小
                 * 若sum比target小则将第二个指针low往右移一位,否则high往左移一位
                 */
                if (sum < target) {
                    low++;
                }else {
                    high--;
                }
            }
        }
        return result;
    }
}
