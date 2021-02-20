package sword.leetcode.linearlist.array;

import java.math.BigDecimal;

/**
 * @program: draft
 * @description:
 * Gas Station
 * There are N gas stations[加油站] along a circular route, where the amount of[……的数量] gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey[n.旅行;行程,vi.旅行] with an empty tank at one of the gas stations.
 * Return the starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 * Note: The solution is guaranteed to be unique.
 *
 * leetcode.134.加油站, 如图: GasStation.png
 * input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * output: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 *
 * Solution
 * 方法1: 暴力破解法
 * 方法2: 图分析法
 * @author: atong
 * @create: 2021-02-19 15:08
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);

        int i1 = canCompleteCircuitI(gas, cost);
        System.out.println(i1);

    }

    /**
     * 暴力破解法
     * @param gas 加油站油气含量
     * @param cost 每到一个加油站需要耗费的油气量
     * @return 从哪个点出发可以经过所有的加油站
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        //考虑从每一个点出发
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            //当前剩余的油能否到达下一个点
            while (remain - cost[j] >= 0) {
                //减去花费的加上新的点的补给, %n -> 考虑转一圈回到原地
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
        }
        //任何点都不可以
        return -1;
    }

    /**
     * 该题可以使用图的思想来分析，时间复杂度 O(N)，空间复杂度 O(1)。
     * 如图: GasStationSolution.png
     * 黑色折线图即总油量剩余值，若要满足题目的要求：跑完全程再回到起点，总油量剩余值的任意部分都需要在X轴以上，且跑到终点时：总剩余汽油量 >= 0。
     * 为了让黑色折线图任意部分都在 X 轴以上，我们需要向上移动黑色折线图，直到所有点都在X轴或X轴以上。
     * 此时，处在X轴的点即为出发点。即黑色折线图的最低值的位置：index = 3。
     *
     * 从0点（i=0,即第一个站）出发的折线图，那么改变出发点时，这个图会怎么变化呢？
     * 你可以自己去画一画，你会发现，整体折线图的形状是没有变的，改变的是y值，相当于将折线图在Y轴方向上上下平移。
     * 那么，当最小点落在X轴上时（也就是使得最小点y=0时），整体折线在X轴上方，y值恒大于等于0，也就是剩余油量一直不为负，可以绕行一圈。
     * 对于本例，也就是使得i=3时，y=0。此时，意味着从i=3，第四个站出发，到此站时即没有加油也没有耗油，剩余油量为0。
     * @param gas 加油站油气含量
     * @param cost 每到一个加油站需要耗费的油气量
     * @return 从哪个点出发可以经过所有的加油站
     */
    public static int canCompleteCircuitI(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
