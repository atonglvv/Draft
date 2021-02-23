package sword.leetcode.linearlist.array;

/**
 * @program: draft
 * @description:
 * Single Number
 * Given an array of integers, every element appears[v.出现;呈现;看上去好像（appear的三单形式）] twice except for one.
 * Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 * Leetcode.136.只出现一次的数字
 *
 * Solution
 * 异或，不仅能处理两次的情况，只要出现偶数次，都可以清零。
 * @author: atong
 * @create: 2021-02-23 09:19
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,6,6,2,15};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    /**
     * 异或
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        //result 初始化为0, 0^A = A
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
