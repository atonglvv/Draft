package thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: draft
 * @description: CyclicBarrierDemo
 * 集齐七颗龙珠 就可以召唤神龙
 * @author: atong
 * @create: 2021-12-24 22:50
 */
public class CyclicBarrierDemo {
    private static final int NUMBER = 7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("集齐几颗龙珠就可以召唤神龙");
        });

        //集齐七颗龙珠的过程
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "星龙珠被收集到嘞");
                //等待
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
