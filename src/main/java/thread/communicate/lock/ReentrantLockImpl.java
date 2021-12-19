package thread.communicate.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: draft
 * @description: 重入锁实现线程间通信
 * @author: atong
 * @create: 2021-12-19 18:43
 */
public class ReentrantLockImpl {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.desc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.desc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread D").start();
    }
}

//资源类
class Share {
    //初始值
    private Integer number = 0;
    //创建Lock
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //+1的方法
    public void incr () throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            //通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //-1的方法
    public void desc () throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            //通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
