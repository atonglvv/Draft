package sword.leetcode.linearlist.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: draft
 * @description:
 * Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 * Return its length: 4.
 * Your algorithm should run in O(n) complexity
 *
 * Solution:
 * 本题要求时间复杂度为O(n),所以不能先排序后计算。
 * 由于序列里的元素是无序的,又要求O(n),首先要想到用哈希表。
 * 用一个hashMap记录每个元素是否使用过。
 * 对于每个元素,查看元素左右是否存在元素,并获取存在元素的最长连续个数。
 * 获取该元素最左与最右连续数,并更新左右边界。
 *
 * @author: atong
 * @create: 2021-01-27 14:23
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {3,2,4,5};
        System.out.println(longestConsecutive(nums));
    }


    public static int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int longest = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++) {
            //不计重复
            if(map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i],1);
            int start = nums[i];
            int end = nums[i];
            //判断元素右侧是否存在元素
            if(map.containsKey(nums[i] + 1)) {
                //如果右侧存在元素,则更新最右边界值, 注意：最右边界值 = 元素值 + 右侧序列最长连续数
                end = nums[i] + map.get(nums[i] + 1);
            }
            //判断元素左侧是否存在元素
            if(map.containsKey(nums[i] - 1)) {
                //如果左侧存在元素,则更新最左边界值, 注意：最左边界值 = 元素值 - 右侧序列最长连续数
                start = nums[i] - map.get(nums[i] - 1);
            }
            //更新最长序列
            longest = Math.max(longest, end - start + 1);
            //更新左边界
            map.put(start, end - start + 1);
            //更新右边界
            map.put(end, end - start + 1);
        }
        return longest;
    }
}
