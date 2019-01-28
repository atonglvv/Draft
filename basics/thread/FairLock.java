package basics.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: carver
 * @Date: 2019/1/28 10:14
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: ReentrantLock还可以指定为公平锁
 */
public class FairLock extends Thread{

    //参数为true表示为公平锁，默认为非公平所
    public static ReentrantLock lock = new ReentrantLock(true);

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
