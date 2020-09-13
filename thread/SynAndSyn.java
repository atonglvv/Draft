package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: carver
 * @Date: 2019/1/23 13:23
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁，
 *               也就是说 Synchronized获得的锁是可重入的。
 */
public class SynAndSyn {

    synchronized void m1() {
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
    }
    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 start");
    }


}
