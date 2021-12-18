package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: carver
 * @Date: 2019/1/28 10:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: ReentrantLock还可以指定为公平锁
 *              公平锁：加锁前先查看是否有排队等待的线程，有的话优先处理排在前面的线程，先来先得。
 *              非公平所：线程加锁时直接尝试获取锁，获取不到就自动到队尾等待。
 *              非公平锁比公平锁性能高5-10倍
 *              因为公平锁需要在多核情况下维护一个队列，如果当前线程不是队列的第一个无法获取锁，增加了线程切换次数。
 */
public class FairLock extends Thread{

    //参数为true表示为公平锁，默认为非公平所
    public static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r = new FairLock();
        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);
        th1.start();
        th2.start();
    }
}
