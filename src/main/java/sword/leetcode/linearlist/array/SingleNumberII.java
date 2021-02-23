package sword.leetcode.linearlist.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: draft
 * @description:
 * SingleNumberII
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Solution
 * 本题和上一题Single Number，考察的是位运算。
 * 方法一: 将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。
 * 方法二: 遍历输入数组，统计每个数字出现的次数，最后返回出现次数为 1 的数字(使用HashMap)
 * 方法三: 使用位运算符可以实现 O(1) 的空间复杂度。
 * 0 ^ A = A
 * A ^ A = A
 *
 *
 * @author: atong
 * @create: 2021-02-23 09:37
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    /**
     * 方法一: 将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。
     * 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
     * @param nums  array
     * @return single number
     */
    public static int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for(int n : nums) {
            sumArray += n;
            set.add((long)n);
        }
        for(Long s : set) {
            sumSet += s;
        }
        return (int)((3 * sumSet - sumArray) / 2);
    }


    /**
     * 方法二 ： HashMap
     * @param nums array
     * @return single number
     */
    public int singleNumberI(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums){
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }

        for (int k : hashmap.keySet()) {
            if (hashmap.get(k) == 1) {
                return k;
            }
        }
        return -1;
    }


    /**
     * 方法三 : 位运算
     * @param nums array
     * @return number
     */
    public int singleNumberII(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

}
