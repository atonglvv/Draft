package thread.forkJoin;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.concurrent.RecursiveTask;

/**
 * @program: draft
 * @description: Java 7开始引入了一种新的Fork/Join线程池
 * ForkJoin的框架的基本思想是分而治之
 * 它可以执行一种特殊的任务：把一个大任务拆成多个小任务并行执行。
 * 以上 是一个简单的Join/Fork计算过程，计算两个数之间的累加和
 * @author: atong
 * @create: 2020-11-17 09:54
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    /**
     * 每个子任务划分维度
     */
    private static final Integer MAX = 200;
    /**
     *子任务 计算 开始值
     */
    private Integer startValue;
    /**
     *子任务 计算 结束值
     */
    private Integer endValue;

    public ForkJoinDemo(Integer startValue, Integer endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        if (endValue - startValue < MAX) {
            System.out.println("开始计算的部分：startValue = " + startValue + ";endValue = " + endValue);
            Integer total = 0;
            for (int index = startValue; index <= endValue; index++) {
                total += index;
            }
            return total;
        }else {
            ForkJoinDemo sumTask1 = new ForkJoinDemo(startValue, (startValue + endValue) / 2);
            sumTask1.fork();
            ForkJoinDemo sumTask2 = new ForkJoinDemo((startValue + endValue) / 2 + 1, endValue);
            sumTask2.fork();
            return sumTask1.join() + sumTask2.join();
        }
    }
}
