package sword.al;

import java.util.Arrays;

/**
 * @Auther: carver
 * @Date: 2019/2/3 14:34
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 问题描述:
 *              一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
 *              求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class BTSteps {
    //动态规划
    public static int btSteps(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        //注意返回target - 1
        return dp[target - 1];
    }

    public static void main(String[] args) {
        System.out.println(btSteps(2));
    }
}
