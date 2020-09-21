package sword.al;

/**
 * @Auther: carver
 * @Date: 2019/1/31 21:02
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 题目描述：
 *              一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *              求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Steps {

    public int steps(int n) {
        if (n <= 2) {
            return n;
        }
        int step1 = 1,step2 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }
        return result;
    }

}
