package thread.communicate;

/**
 * @program: draft
 * @description: Wait 和 Notify 实现线程间通信
 * @author: atong
 * @create: 2021-12-18 21:56
 */
public class WatiAndNotify {
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
    }
}

//资源类
class Share {
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
