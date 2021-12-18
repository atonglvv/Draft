package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: draft
 * @description: 通过ReentrantLock实现售票逻辑
 * @author: atong
 * @create: 2021-12-18 21:02
 */
public class LSaleTicket {
    public static void main(String[] args) {
        LTicket ticket = new LTicket();
        //创建四个线程 卖票
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread A").start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread B").start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread C").start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                ticket.sale();
            }
        }, "thread D").start();
    }
}

class LTicket {
    //票数
    private Integer num = 30;
    /* 常见可重入锁 */
    private final ReentrantLock lock = new ReentrantLock();
    public void sale () {
        //上锁
        lock.lock();
        try {
            //判断是否有票
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "︰卖出:" + (num--) + "剩下:" + num);
            }
        } finally {
            //解锁
            lock.unlock();
        }
    }
}
