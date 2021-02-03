package sword.leetcode.linearlist.array;

import java.util.ArrayList;

/**
 * @program: draft
 * @description:
 * Permutation Sequence
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive[adj.包含的，包括的；包含全部费用的;包括提到的所有……在内的；范围广泛的].
 *
 * Solution:
 * 方法一:
 * 最简单的可使用暴力枚举法,调用k-1次nextPermutation().
 * 暴力枚举法把前k个排列都求出来了,比较浪费时间,而我们只需要第k个排列。
 * 方法二:
 * 利用康托编码来求。[Cantor expansion]
 * 其实就是康托展开的逆过程。
 * 康托展开用来求某个全排列数是第几小的数，也就是当这些数按顺序排时第几个数。
 * 过程如下：比如求 321 是第几小的，可以这样来想：小于3的数有1和2两个，首位确定之后后面两位有2！中情况，所以共有2*2！=4种可能。
 * 小于2的数只有一个1，所以有1*1！=1种情况，最后一位是1，没有比一小的数，所以是0*0！=0
 * 综上：小于321的数有4+1=5个，所以321是第六小的数。
 * 逆过程就是已知这个数是第k个数，求这个数是多少，当然是知道n的值的。
 * 第k个数就是有k-1个数比这个数小。
 * 所以就是 k-1 = an*(n-1)! + an-1*(n-2)! + .... + a1*0!;
 *
 * 补充:
 * Cantor expansion算法的思想是，在n!个排列中，第一位的元素总是(n-1)!一组出现的，
 * 也就说如果 p = k / (n-1)!，那么排列的最开始一个元素一定是nums[p]。以下公式给出了全排列到一个自然数的一一双射：
 * X = an*(n-1)! + an-1*(n-2)! + ... + ai*(i-1)! + ... + a2*1! + a1*0!
 *
 * 举个例子：
 * 问1324是{1,2,3,4}排列数中第几个组合：
 * 第一位是1，小于1的数没有，是0个，0*3!，
 * 第二位是3，小于3的数有1和2，但1已经存在于第一位了，所以只有一个数2，1*2! 。
 * 第三位是2小于2的数是1，但1在第一位，所以有0个数，0*1!，
 * 所以比1324小的排列有0*3!+1*2!+0*1!=2个，1324是第3个组合。
 *
 * 以上是Cantor编码的过程，即把一个全排列映射1324为一个自然数3，
 * 而该题目是已知一个自然数k，求其对应的全排列，相对以上步骤来说是一个解码的过程，下面给出一个具体的例子：
 * 如何找出{1,2,3,4,5}的第16个排列？
 * 1. 首先用16-1，得到15；
 * 2. 用15去除4!,得到0，余15;故有0个数比它小的数是1，所以第一位是1;
 * 3. 用15去除3!,得到2，余3;故有2个数比它小的数是3，但1已经在之前出现过，所以第二位是4;
 * 4. 用3去除2!,得到1，余1;故有1个数比它小的数是2，但1已经在之前出现过了所以第三位是3;
 * 5. 用1去除1!,得到1，余0;故有1个数比它小的数是2，但1,3,4都出现过了所以第四位是5;
 * 6. 根据上述推论,最后一个数只能是2;
 * 所以排列为{1,4,3,5,2}。
 *
 * 所以排列为{1,4,3,5,2}。
 * @author: atong
 * @create: 2021-02-02 13:59
 */
public class PermutationSequence {

    public static void main(String[] args) {
        String s = permutationSequence(3, 2);
        System.out.println(s);
    }

    /**
     * 给出 [1,2,3,...,n] 数组以及该数组全排列的第 K 个序列编号，求第 K 个数是啥
     *
     * @param n 数组的最大值
     * @param k 序号
     * @return 第K个数的值
     */
    public static String permutationSequence(int n, int k) {
        // 先搞一个1~n的数组，用来在里面选择合适的数字加入 ans 中
        ArrayList<Integer> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            array.add(i + 1);
        }

        StringBuilder ans = new StringBuilder();
        k -= 1;

        // 执行 n 次循环得到 n 个数，组合成一个答案
        for (int i = 0; i < n; i++) {
            // 计算从 (n-1)! 开始的阶乘
            int factorial = getFactorial(n - i - 1);
            // 计算获取数组的那一个位置的数字
            int index = k / factorial;
            // 获取该数字
            ans.append(array.get(index));
            // 更新 k 为上一次除法计算的余数
            k %= factorial;
            // 同时更新数组，删除已经获得过的数字
            array.remove(index);
        }
        return ans.toString();
    }

    /**
     * @description 求n的阶乘
     * @param n:
     * @return int
     * @author atong
     * @date 2021/2/2 17:18
     * @version 1.0.0.1
     */
    public static int getFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        int res = n;
        for (int i = 1; i < n; i++) {
            res *= i;
        }
        return res;
    }
}
