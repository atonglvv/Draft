package thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: carver
 * @Date: 2019/1/24 12:21
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: Reentrantlock用于替代synchronized
 *              注意使用reentrantlock必须要手动释放锁(重要的事情说三遍)
 *              使用syn锁定的话如果遇到异常,jvm会自动释放锁,但是lock必须手动释放锁,因此经常在finally中进行锁的释放
 */
public class ReentrantlockCustomer {

    Lock lock = new ReentrantLock();

    void m1() {
        //synchronized(this)
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2() {
        lock.lock();
        try {
            System.out.println("m2...");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantlockCustomer r = new ReentrantlockCustomer();
        new Thread(r::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r::m2).start();
    }

}
