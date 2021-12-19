package thread.communicate.order;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: draft
 * @description: 线程间定制化通信，各个线程间顺序执行
 * 要求：创建三个线程, 依次执行, 第一个线程输出5次, 第二个线程输出10次, 第三个线程输出15次
 * @author: atong
 * @create: 2021-12-19 21:10
 */
public class ReentrantLockOrder {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread C").start();
    }
}

//资源类
class Share {
    //定义标志位
    private Integer flag = 1;
    //创建Lock
    private final Lock lock = new ReentrantLock();
    //创建三个condition
    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    /**
     * 打印5次
     */
    public void print5 (int loop) throws InterruptedException {
        lock.lock();
        try {
            while(flag != 1) {
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + ":轮数："+ loop);
            }
            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印10次
     */
    public void print10 (int loop) throws InterruptedException {
        lock.lock();
        try {
            while(flag != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + ":轮数："+ loop);
            }
            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印15次
     */
    public void print15 (int loop) throws InterruptedException {
        lock.lock();
        try {
            while(flag != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "::" + i + ":轮数："+ loop);
            }
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
