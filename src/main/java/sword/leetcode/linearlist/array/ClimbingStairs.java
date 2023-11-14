package sword.leetcode.linearlist.array;

/**
 * @program: draft
 * @description:
 * https://leetcode.cn/problems/climbing-stairs/
 * Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Solution:
 * 设f(n)表示爬n阶楼梯的不同方法数，为了爬到第n阶楼梯，有两个选择:
 * - 从第n - 1阶前进1步;
 * - 从第n - 2阶前进2步;
 * 因此，有 f(n) = f(n-1) + f(n-2)。
 * 这是一个斐波那契数列。
 * 方法1 递归,太慢.
 * 方法2 迭代。
 * 方法3 数学公式。斐波那契数列的通项公式为图:ClimbingStairs.png
 * @author: atong
 * @create: 2021-02-18 09:26
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int ways = climbStairs(8);
        int ways1 = climbStairsI(8);
        int ways2 = climbStairsII(8);
        System.out.println(ways);
        System.out.println(ways1);
        System.out.println(ways2);
    }

    /**
     * 迭代
     * @param n 台阶数
     * @return ways
     */
    public static int climbStairs(int n) {
        //用于记录f(n-2)
        int prev = 0;
        //用于记录f(n-1)
        int cur = 1;
        for(int i = 1; i <= n; ++i){
            int tmp = cur;
            //f(n) = f(n-1) + f(n-2)
            cur += prev;
            prev = tmp;
        }
        return cur;
    }

    /**
     * 递归 -> 会超时
     * @param n 台阶数
     * @return ways
     */
    public static int climbStairsI(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsI(n-1) + climbStairsI(n-2);
    }

    /**
     * 公式
     * @param n 台阶数
     * @return ways
     */
    public static int climbStairsII(int n) {
        double s = Math.sqrt(5);
        return (int) Math.floor((Math.pow((1+s)/2, n+1) + Math.pow((1-s)/2, n+1))/s + 0.5);
    }
}
