package thread.lock.dead;

/**
 * @program: draft
 * @description: 打破线程死锁
 * 如何避免线程死锁：
 * 破坏互斥条件
 *      这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
 * 破坏请求与保持条件
 *      一次性申请所有的资源。
 * 破坏不剥夺条件
 *      对于持有部分资源的进程进一步申请其他资源时，如果申请不到，可以主动释放它所持有的资源。
 * 破坏循环等待条件
 *      靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。
 * @author: atong
 * @create: 2021-12-18 15:13
 */
public class BreakDeadLock {
    //资源 1
    private static Object resource1 = new Object();
    //资源 2
    private static Object resource2 = new Object();
    public static void main(String[] args) {
        //线程1在持有resource1未释放的前提下，去锁resource2
        new Thread(() -> {
            //线程1通过 synchronized(resource1)获得resource1的监视器锁
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    //让线程 A 休眠 1s 为的是让线程 B 得到执行然后获取到 resource2 的监视器锁
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                //线程1请求获取resource2，但resource2已被线程2持有且未释放。
                //导致死锁
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();

        /**
         * 造成死锁的原因和申请资源的顺序有很大关系,
         * 使用资源申请的有序性原则就可以避免死锁
         * 该类与src/main/java/thread/lock/dead/DeadLock.java 不同之处,
         * 在于：该类 线程2 先去获取resource1, 后去获取 resource2, 跟线程1资源顺序保持一致
         */
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    //让线程 B 休眠 1s 为的是让线程 A 得到执行然后获取到 resource1 的监视器锁
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                //线程2请求获取resource1，但resource1已被线程1持有且未释放。
                //导致死锁
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程 2").start();
    }
}
