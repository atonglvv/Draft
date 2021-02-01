package sword.leetcode.linearlist.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: draft
 * @description:
 * FourSum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets[n. 四胎儿；四胞胎之一；成套的四件] in the array which gives the sum of target.
 * Note:
 * • Elements in a quadruplet (a, b, c, d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * • The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1, 0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2, 0, 0, 2)
 *
 * Solution:
 * 1.先排序,然后左右夹逼。时间复杂度O(n³),会超时。
 * 2.使用hashmap缓存两个数的和,时间复杂度O(n²)。该策略也适用于ThreeSum。
 * @author: atong
 * @create: 2021-01-29 17:33
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2, 0, 1};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(lists);
    }


    /**
     * @description
     * 方法1:先排序,固定两个值然后左右夹逼。时间复杂度O(n³),会超时。
     * 该方法与ThreeSum的解法思路一致。
     * @param nums: 数组
     * @param target: 目标值
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @author atong
     * @date 2021/2/1 11:05
     * @version 1.0.0.1
     */
    public static List<List<Integer>> fourSum (int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        low ++;
                        high --;
                    }else if (sum < target) {
                        low ++;
                    }else {
                        high --;
                    }
                }
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }
}
