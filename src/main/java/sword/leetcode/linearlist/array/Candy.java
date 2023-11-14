package sword.leetcode.linearlist.array;

import java.util.Arrays;

/**
 * @program: draft
 * @description:
 * https://leetcode.cn/problems/candy/description/
 * Candy
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to[遭受;承受;使某人经历某事] the following requirements:
 * • Each child must have at least one candy.
 * • Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Solution
 * 方法一: 两次遍历
 * 我们可以将「相邻的孩子中，评分高的孩子必须获得更多的糖果」这句话拆分为两个规则，分别处理。
 * 左规则：当 ratings[i - 1] < ratings[i] 时，i号学生的糖果数量将比 i−1 号孩子的糖果数量多。
 * 右规则：当 ratings[i] > ratings[i+1] 时，i 号学生的糖果数量将比 i+1 号孩子的糖果数量多。
 * 我们遍历该数组两次，处理出每一个学生分别满足左规则或右规则时，最少需要被分得的糖果数量。每个人最终分得的糖果数量即为这两个数量的最大值。
 * 具体地，以左规则为例：我们从左到右遍历该数组，假设当前遍历到位置 ii，如果有 ratings[i−1] < ratings[i] 那么 i 号学生的糖果数量将比 i−1 号孩子的糖果数量多，
 * 我们令 left[i]=left[i−1]+1 即可，否则我们令 left[i]=1。
 * 在实际代码中，我们先计算出左规则 left 数组，在计算右规则的时候只需要用单个变量记录当前位置的右规则，同时计算答案即可。
 *
 * 方法二: 常数空间遍历
 *
 * @author: atong
 * @create: 2021-02-22 09:26
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        int candy = candy(ratings);
        System.out.println(candy);
    }

    /**
     * 方法一:两次遍历
     * @param ratings 小朋友分值数组
     * @return candy 最小数量
     */
    public static int candy (int[] ratings) {
        int n = ratings.length;
        //从左向右遍历,记录小朋友的糖果数。并保证高评分小朋友比其左边低评分小朋友分到的糖果多
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                //如果右边小朋友评分大于左边小朋友评分,则 右边小朋友糖果数 = 左边小朋友糖果数 + 1;
                left[i] = left[i - 1] + 1;
            } else {
                //否则 小朋友糖果数最小值1
                left[i] = 1;
            }
        }
        System.out.println(Arrays.toString(left));
        //从最后一个下朋友手里的糖果开始计算
        int ret = left[ratings.length - 1];
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //关于此处为何是 right++,如果连续的左边比右边分值大,则需要不断+1
                //如果连续断了,则走 else 重新设置right为1。
                right++;
            } else {
                right = 1;
            }
            //最终小朋友糖果数是Math.max(left[i], right)
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    /**
     * 方法二: 常数空间遍历
     * 我们从左到右枚举每一个同学，记前一个同学分得的糖果数量为 pre：
     * 如果当前同学比上一个同学评分高，说明我们就在最近的递增序列中，直接分配给该同学 pre+1 个糖果即可。
     * 否则我们就在一个递减序列中，我们直接分配给当前同学一个糖果，并把该同学所在的递减序列中所有的同学都再多分配一个糖果，以保证糖果数量还是满足条件。
     * 我们无需显式地额外分配糖果，只需要记录当前的递减序列长度，即可知道需要额外分配的糖果数量。
     * 同时注意当当前的递减序列长度和上一个递增序列等长时，需要把最近的递增序列的最后一个同学也并进递减序列中。
     * 这样，我们只要记录当前递减序列的长度 dec，最近的递增序列的长度 inc 和前一个同学分得的糖果数量 pre 即可。
     *
     * @param ratings 小朋友分值数组
     * @return 最小数量
     */
    public static int candyI(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        /**
         * inc -> 最近的递增序列长度
         * dec -> 记录当前的递减序列长度
         * pre -> 记录前一位小朋友糖果数量,此时初始化为第一个小朋友手里的糖果数1
         */
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                //如果右边小朋友分值大于左边小朋友分值,则更新pre为pre+1,若相等,则pre继续为1
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                //记录递增序列长度
                inc = pre;
            } else {
                //记录递减序列长度
                dec++;
                //当当前的递减序列长度和上一个递增序列等长时，需要把最近的递增序列的最后一个同学也并进递减序列中
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}
