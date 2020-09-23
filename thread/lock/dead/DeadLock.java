package thread.lock.dead;

/**
 *认识线程死锁
 *
 *产生死锁的四个必备条件：
 * 1.互斥条件：该资源任意一个时刻只由一个线程占用。
 * 2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * 3.不剥夺条件:线程已获得的资源在末使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
 * 4.循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 *
 * 如何避免线程死锁：
 * 1.破坏互斥条件 ：这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
 * 2.破坏请求与保持条件 ：一次性申请所有的资源。
 * 3.破坏不剥夺条件 ：占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
 * 4.破坏循环等待条件 ：靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。
 */
public class DeadLock {

    private static Object resource1 = new Object(); //资源 1
    private static Object resource2 = new Object(); //资源 2
    public static void main(String[] args) {
        //线程1在持有resource1未释放的前提下，去锁resource2
        //线程1通过 synchronized(resource1)获得resource1的监视器锁
        new Thread(() -> {
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

        //线程2在持有resource2未释放的前提下，去锁resource1
        new Thread(() -> {
            synchronized (resource2) {
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
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程 2").start();
    }
}
