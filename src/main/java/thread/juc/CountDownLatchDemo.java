package thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @program: draft
 * @description: CountDownLatchDemo
 * 班里有6个同学, 6个同学离开教室后, 班长锁门
 * @author: atong
 * @create: 2021-12-24 22:42
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号同学离开了教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + " 班长锁门嘞");
    }
}
