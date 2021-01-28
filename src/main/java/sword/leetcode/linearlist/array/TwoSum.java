package sword.leetcode.linearlist.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: draft
 * @description:
 * Two Sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where
 * index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not
 * zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * Solution:
 * Idea1:暴力,复杂度O(n²),会超时
 * Idea2:使用一个Hash,存储每个数相应的下标,复杂度O(n)
 * Idea3:先排序,然后左右夹逼,排序O(nlogn),左右夹逼O(n),最终O(nlogn)。但是该题需要返回的是下标,而不是数字本身,因此该方法行不通。
 * @author: atong
 * @create: 2021-01-27 16:41
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int complement = target - nums[i];
            //判断是否存在 complement + nums[i] = target
            if (hm.containsKey(complement)) {
                return new int[] {hm.get(complement), i };
            }
            /*
             * 这一步放到for循环最下面来执行
             * 若先放到hm中,则需要在上面的if中加不能相同数的判断
             * 比如: {2, 7, 11, 15}, target = 4. ==> {0, 0}
             */
            hm.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
