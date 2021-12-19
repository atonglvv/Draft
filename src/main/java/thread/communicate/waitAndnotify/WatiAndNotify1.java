package thread.communicate.waitAndnotify;

/**
 * @program: draft
 * @description: Wait 和 Notify 实现线程间通信
 * 如果是两个线程对共享资源+1, 两个线程对共享资源-1。
 * 就会出现问题, 虚假唤醒的问题。
 * 因为wait的线程, 被唤醒后, 会紧接着上次被wati的地方往下执行。
 *
 * 考虑, 线程A获取到锁, 然后 number++,执行完后释放锁
 * 如果线程A又获取到了锁, 因为此时 number!=0 所以, Thread A wait, 释放锁
 * 然后 Thread C 又获取到了锁, 因为此时 number!=0 所以, Thread A wait, 释放锁
 * 然后ThreadB或者ThreadD, 获取到锁后, number--, 然后通知其他Thread
 * ThreadA获取到锁, number++, 释放锁
 * ThreadC获取到锁, 因为 ThreadC在wait之前已经走过了if判断, 所以会接着往下执行, number++, 然后number结果变为了2
 * 所以一般 wait 外面用 while 包着
 * @author: atong
 * @create: 2021-12-19 17:50
 */
public class WatiAndNotify1 {
    public static void main(String[] args) {
        Share1 share = new Share1();
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
class Share1 {
    //初始值
    private Integer number = 0;

    //+1的方法
    public synchronized void incr () throws InterruptedException {
        if (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        this.notifyAll();
    }

    //-1的方法
    public synchronized void desc () throws InterruptedException {
        if (number != 1) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "::" + number);
        this.notifyAll();
    }
}
