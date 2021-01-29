package sword.leetcode.linearlist.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: draft
 * @description:
 * ThreeSum:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * • Elements in a triplet (a, b, c) must be in non-descending[v.下降;下倾;降临; adj.递降的] order. (ie, a ≤ b ≤ c)
 * • The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4}.
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * Solution:
 * 先排序,然后左右夹逼,时间复杂度(n²)
 * 该方法可以推广到k-sum,先排序,然后做k-2次循环,在最内存循环左右夹逼,时间复杂度是O(max{nlogn,n[k-1次方]})。
 * 该题可看作由三个指针解决,第一个指针用于遍历数组,
 * 第二个指针由第一个指针的下一个元素开始往右遍历,
 * 第三个指针由数组末尾元素忘左遍历.
 * 判断三个指针值的和是否等于0,如果等于0则放到结果集里,
 * 如果小于0,则第二个指针往右移一位,如果大于0,则第三个指针往左移一位。
 * 直到第二三指针相遇。
 * @author: atong
 * @create: 2021-01-28 15:09
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> result = threeSum(nums);
        System.out.println(result);
    }


    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);

                    //需要用hs来去重,不然会有重复。比如 {-1, 0, 1, 2, -1, -4} -> [-1, 0, 1]
                    if (!hs.contains(list)) {
                        hs.add(list);
                        result.add(list);
                    }
                    //如果等于0 则第二个指正往右移一位且第三个指针往左移一位
                    low++;
                    high--;
                }else if (sum < 0) {
                    //如果小于0 则第二个指针往右移一位
                    low++;
                }else  {
                    //如果大于0 则第三个指针往左移一位
                    high--;
                }
            }
        }

        return result;
    }
}
